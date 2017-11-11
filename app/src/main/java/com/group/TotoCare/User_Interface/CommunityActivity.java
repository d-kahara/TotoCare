package com.group.TotoCare.User_Interface;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.group.TotoCare.R;
import com.group.TotoCare.model.ChatMessage;

/**
 * Created by david on 10/27/17.
 */

public class CommunityActivity extends AppCompatActivity {
    private FirebaseListAdapter<ChatMessage> adapter;
    private EditText input;
    private  TextView messageText, messageUser, messageTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community);


        FloatingActionButton fab =
                (FloatingActionButton)findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = FirebaseAuth.getInstance().getCurrentUser().getDisplayName();
                input = (EditText)findViewById(R.id.input);
                Typeface myfont = Typeface.createFromAsset(getAssets(), "fonts/Raleway-Regular.ttf");
                messageTime.setTypeface(myfont);
                input.setTypeface(myfont);


                // Read the input field and push a new instance
                // of ChatMessage to the Firebase database
                FirebaseDatabase.getInstance()
                        .getReference().child("messages")
                        .push()
                        .setValue(new ChatMessage(input.getText().toString(),name)
                        );

                // Clear the input
                input.setText("");
            }
        });

        displayChatMessages();



    }

    private void displayChatMessages() {
        ListView listOfMessages = (ListView)findViewById(R.id.list_of_messages);

        adapter = new FirebaseListAdapter<ChatMessage>(this, ChatMessage.class,R.layout.message, FirebaseDatabase.getInstance().getReference().child("messages")) {
            @Override
            protected void populateView(View v, ChatMessage model, int position) {
                // Get references to the views of message.xml
                messageText = (TextView)v.findViewById(R.id.message_text);
                messageUser = (TextView)v.findViewById(R.id.message_user);
                messageTime = (TextView)v.findViewById(R.id.message_time);
                Typeface myfont = Typeface.createFromAsset(getAssets(), "fonts/Raleway-Regular.ttf");
                messageTime.setTypeface(myfont);
                messageUser.setTypeface(myfont);
                messageText.setTypeface(myfont);

                // Set their text
                messageText.setText(model.getMessageText());
                messageUser.setText(model.getMessageUser());

                // Format the date before showing it
                messageTime.setText(DateFormat.format("dd-MM-yyyy (HH:mm:ss)",
                        model.getMessageTime()));
            }
        };

        listOfMessages.setAdapter(adapter);
    }

}
