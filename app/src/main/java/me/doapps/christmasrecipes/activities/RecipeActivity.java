package me.doapps.christmasrecipes.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.shamanland.fab.FloatingActionButton;
import com.squareup.picasso.Picasso;

import me.doapps.christmasrecipes.R;
import me.doapps.christmasrecipes.utils.UtilFonts;

/**
 * Created by jonathan on 23/11/2014.
 */
public class RecipeActivity extends ActionBarActivity implements View.OnClickListener {
    private ImageView img_recipe;
    private TextView txt_recipe_name;
    private TextView txt_recipe_prepare;
    private TextView txt_recipe_cook;
    private TextView txt_recipe_serves;
    private TextView txt_summary;
    private TextView txt_ingredients;
    private TextView txt_directions;

    private FloatingActionButton fab_share_recipe;

    private String recipe_name;
    private String recipe_summary;

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
        fab_share_recipe = (FloatingActionButton)findViewById(R.id.fab_share_recipe);

        txt_recipe_name.setText(bundle.getString("name"));
        txt_recipe_prepare.setText(bundle.getString("prepare")+" minutos");
        txt_recipe_cook.setText(bundle.getString("cook")+" minutos");
        txt_recipe_serves.setText(bundle.getString("serves")+" personas");
        txt_summary.setText(bundle.getString("summary"));
        txt_ingredients.setText(bundle.getString("ingredients"));
        txt_directions.setText(bundle.getString("directions"));

        recipe_name = bundle.getString("name");
        recipe_summary = bundle.getString("summary");

        txt_recipe_name.setTypeface(UtilFonts.setHelveticaBold(this));
        txt_recipe_prepare.setTypeface(UtilFonts.setHelveticaThin(this));
        txt_recipe_cook.setTypeface(UtilFonts.setHelveticaThin(this));
        txt_recipe_serves.setTypeface(UtilFonts.setHelveticaThin(this));
        txt_summary.setTypeface(UtilFonts.setHelveticaThin(this));
        txt_ingredients.setTypeface(UtilFonts.setHelveticaThin(this));
        txt_directions.setTypeface(UtilFonts.setHelveticaThin(this));

        ((TextView)findViewById(R.id.txt_title_summary)).setTypeface(UtilFonts.setHelveticaBold(this));
        ((TextView)findViewById(R.id.txt_title_ingredients)).setTypeface(UtilFonts.setHelveticaBold(this));
        ((TextView)findViewById(R.id.txt_title_directions)).setTypeface(UtilFonts.setHelveticaBold(this));

        fab_share_recipe.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        try {
            Intent i = new Intent(Intent.ACTION_SEND);
            i.setType("text/plain");
            i.putExtra(Intent.EXTRA_SUBJECT, recipe_name);
            String sAux = "\n"+recipe_summary+":\n\n";
            sAux = sAux + "https://play.google.com/store/apps/details?id=me.doapps.pondetuparte&hl=es\n\n";
            i.putExtra(Intent.EXTRA_TEXT, sAux);
            startActivity(Intent.createChooser(i, recipe_name));
        } catch (Exception e) {
            //e.toString();
        }
    }
}
