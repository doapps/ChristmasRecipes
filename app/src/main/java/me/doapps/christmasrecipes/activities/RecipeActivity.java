package me.doapps.christmasrecipes.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import me.doapps.christmasrecipes.R;

/**
 * Created by jonathan on 23/11/2014.
 */
public class RecipeActivity extends ActionBarActivity {
    private ImageView img_recipe;
    private TextView txt_recipe_name;
    private TextView txt_recipe_prepare;
    private TextView txt_recipe_cook;
    private TextView txt_recipe_serves;
    private TextView txt_summary;
    private TextView txt_ingredients;
    private TextView txt_directions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        Bundle bundle = getIntent().getExtras();

        img_recipe = (ImageView)findViewById(R.id.img_recipe);
        Picasso.with(RecipeActivity.this).load(bundle.getString("image_url")).placeholder(R.drawable.recipe_default).centerCrop().fit().into(img_recipe);

        txt_recipe_name = (TextView)findViewById(R.id.txt_recipe_name);
        txt_recipe_prepare = (TextView)findViewById(R.id.txt_recipe_prepare);
        txt_recipe_cook = (TextView)findViewById(R.id.txt_recipe_cook);
        txt_recipe_serves = (TextView)findViewById(R.id.txt_recipe_serves);
        txt_summary = (TextView)findViewById(R.id.txt_summary);
        txt_ingredients = (TextView)findViewById(R.id.txt_ingredients);
        txt_directions = (TextView)findViewById(R.id.txt_directions);

        txt_recipe_name.setText(bundle.getString("name"));
        txt_recipe_prepare.setText(bundle.getString("prepare")+" minutos");
        txt_recipe_cook.setText(bundle.getString("cook")+" minutos");
        txt_recipe_serves.setText(bundle.getString("serves")+" personas");
        txt_summary.setText(bundle.getString("summary"));
        txt_ingredients.setText(bundle.getString("ingredients"));
        txt_directions.setText(bundle.getString("directions"));



    }
}
