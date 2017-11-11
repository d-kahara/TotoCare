package com.group.TotoCare.User_Interface;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.group.TotoCare.Adapter.RecipeListAdapter;
import com.group.TotoCare.Constants;
import com.group.TotoCare.R;
import com.group.TotoCare.model.Recipe;

import java.io.IOException;
import java.util.ArrayList;
import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


public class RecipeActivity extends AppCompatActivity {
    //add shared preferences to allow users search recipes with the search widget and the editor
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;
    private String mRecentRecipe;
    private Button mSubmitRecipeButton;
    //  private TextView mRecipeTextView;
    //private ListView mListView;
    //use butterknife to bind the views
    @Bind(R.id.recyclerView)
    RecyclerView mRecyclerView;
    @Bind(R.id.listView)ListView mListView;
    @Bind(R.id.recipeTextView) TextView mRecipeTextView;
    private RecipeListAdapter mAdapter;
    public ArrayList<Recipe> mRecipes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
        mRecipeTextView = (TextView) findViewById(R.id.recipeTextView);

        Typeface myfont = Typeface.createFromAsset(getAssets(), "fonts/Raleway-Regular.ttf");
        mRecipeTextView.setTypeface(myfont);

        ButterKnife.bind(this);
        Intent enterRecipe = getIntent();
        String recipes = enterRecipe.getStringExtra("recipes");
        getRecipes(recipes);
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mRecentRecipe = mSharedPreferences.getString(Constants.PREFERENCES_RECIPE_KEY, null);
        if (mRecentRecipe != null) {
            getRecipes(mRecentRecipe);
        }
    }
    //overiding the onCreateOptionsMenu() and onOptionsItemSelected() methods
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search, menu);
        ButterKnife.bind(this);
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mSharedPreferences.edit();
        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);
        //attach an dedicated listener-onQueryTextListener-to listen for changes in the search View
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            //runs when the user submits a query into the search view
            @Override
            public boolean onQueryTextSubmit(String query) {
                addToSharedPreferences(query);
                getRecipes(query);
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
    //method to write data to shared preferences
    private void addToSharedPreferences(String recipe) {
        mEditor.putString(Constants.PREFERENCES_RECIPE_KEY, recipe).apply();
    }
    //receiving a response
    private void getRecipes(String recipes) {
        //Create a new instance of yummly service and call the find recipes method
        final YummlyService yummlyService = new YummlyService();
        yummlyService.findRecipes(recipes, new Callback() {
            //Method onFailure triggered when the request fails
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }
            //Method onResponse triggered when the request is successful
            @Override
            public void onResponse(Call call, Response response) {
                mRecipes = yummlyService.processResults(response);
                RecipeActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mAdapter=new RecipeListAdapter(getApplicationContext(),mRecipes);
                        mRecyclerView.setAdapter(mAdapter);
                        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(RecipeActivity.this);
                        mRecyclerView.setLayoutManager(layoutManager);
                        mRecyclerView.setHasFixedSize(true);
                    }
                });
            }
        });
    }
}
