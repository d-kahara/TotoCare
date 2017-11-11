package com.group.TotoCare.User_Interface;


import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.group.TotoCare.R;
import com.group.TotoCare.model.Recipe;

/**
 * A simple {@link Fragment} subclass.
 */
import org.parceler.Parcels;

import butterknife.Bind;
import butterknife.ButterKnife;

public class RecipeDetailFragment extends Fragment implements View.OnClickListener {

    @Bind(R.id.recipeImageView)
    ImageView mImageLabel;
    @Bind(R.id.recipeNameTextView)
    TextView mRecipeNameLabel;
    @Bind(R.id.ratingTextView) TextView mRatingLabel;
    @Bind(R.id.prepTimeTextView) TextView mPrepTimeLabel;
    @Bind(R.id.ingredientsTextView) TextView mIngredientsTextView;
    @Bind(R.id.websiteTextView) TextView mWebsiteLabel;
    Button mSaveRecipeButton;

    private Recipe mRecipe;


    public static RecipeDetailFragment newInstance(Recipe recipe) {
        RecipeDetailFragment recipeDetailFragment=new RecipeDetailFragment();
        Bundle args=new Bundle();
        args.putParcelable("recipe", Parcels.wrap(recipe));
        recipeDetailFragment.setArguments(args);
        return recipeDetailFragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        mRecipe=Parcels.unwrap(getArguments().getParcelable("recipe"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recipe_detail, container, false);
        ButterKnife.bind(this, view);
        Glide.with(view.getContext()).load(mRecipe.getImageUrl()).into(mImageLabel);

        // mImageLabel.setText(mRecipe.getImageUrl());
        mPrepTimeLabel.setText(String.valueOf(mRecipe.getPrepTime())+ " Minutes");
        mRatingLabel.setText(Double.toString(mRecipe.getRating()) + "/5");
        //mWebsiteLabel.setText(mRecipe.getUrl());
        mRecipeNameLabel.setText(mRecipe.getRecipeName());
        mIngredientsTextView.setText(android.text.TextUtils.join("\n",mRecipe.getIngredients()));

        Typeface ralewayFont= Typeface.createFromAsset(getActivity().getAssets(),"fonts/Raleway-ExtraLight.ttf");
        mIngredientsTextView.setTypeface(ralewayFont);
        mRecipeNameLabel.setOnClickListener(this);



        return view;
    }
    @Override
    public void onClick(View v){
        if(v == mWebsiteLabel) {
            Intent webIntent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse(mRecipe.getRecipeName()));
            startActivity(webIntent);
        }


    }
}

