package me.doapps.christmasrecipes.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import me.doapps.christmasrecipes.R;

/**
 * Created by jonathan on 23/11/2014.
 */
public class RecipeActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
    }
}
