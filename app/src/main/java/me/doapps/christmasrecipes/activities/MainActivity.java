package me.doapps.christmasrecipes.activities;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.shamanland.fab.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import me.doapps.christmasrecipes.R;
import me.doapps.christmasrecipes.adapters.Adapter_Recipe;
import me.doapps.christmasrecipes.adapters.Adapter_Recipes;
import me.doapps.christmasrecipes.beans.Recipe_DTO;
import me.doapps.christmasrecipes.dialogs.Dialog_Internet;
import me.doapps.christmasrecipes.utils.InternetUtil;


public class MainActivity extends ActionBarActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
    private ListView list_recipes;
    private FloatingActionButton fab_share;
    private InterstitialAd interstitial;
    private Dialog_Internet dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dialog = new Dialog_Internet(MainActivity.this);

        /**
         * Load Intersticial
         */
        loadIntersticial();

        /**
         * Load Banner
         */
        loadBanner();


        list_recipes = (ListView) findViewById(R.id.list_recipes);
        list_recipes.setOnItemClickListener(this);
        fab_share = (FloatingActionButton)findViewById(R.id.fab_share);
        fab_share.setOnClickListener(this);

        final ArrayList<Recipe_DTO> temp_recipe_dtos = new ArrayList<Recipe_DTO>();

        /** internet **/
        InternetUtil internet = new InternetUtil(MainActivity.this);
        if (internet.isConnectingToInternet()) {
            /** parse **/
            ParseQuery<Recipe_DTO> queryRecipes = Recipe_DTO.getQuery();
            queryRecipes.findInBackground(new FindCallback<Recipe_DTO>() {
                @Override
                public void done(List<Recipe_DTO> recipe_dtos, ParseException e) {
                    if (e == null) {
                        ((ProgressBar)findViewById(R.id.loading_recipes)).setVisibility(View.GONE);
                        list_recipes.setVisibility(View.VISIBLE);
                        for (int i = 0; i < recipe_dtos.size(); i++) {
                            //temp_recipe_dtos.add(new Recipe_DTO(recipe_dtos.get(i).getName(), R.drawable.recipe_default));
                            Log.e("name", recipe_dtos.get(i).getName() + "," + recipe_dtos.get(i).getImage_url());
                            temp_recipe_dtos.add(recipe_dtos.get(i));
                        }
                        list_recipes.setAdapter(new Adapter_Recipes(MainActivity.this, temp_recipe_dtos));
                    } else {
                        e.printStackTrace();
                        dialog.show();
                    }
                }
            });
        } else {
            dialog.show();
            ((ProgressBar)findViewById(R.id.loading_recipes)).setVisibility(View.GONE);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        try {
            Intent i = new Intent(Intent.ACTION_SEND);
            i.setType("text/plain");
            i.putExtra(Intent.EXTRA_SUBJECT, "Recetas Navideñas");
            String sAux = "\nTe invito a descargar esta aplicación:\n\n";
            sAux = sAux + "https://play.google.com/store/apps/details?id=me.doapps.pondetuparte&hl=es\n\n";
            i.putExtra(Intent.EXTRA_TEXT, sAux);
            startActivity(Intent.createChooser(i, "Compartir App"));
        } catch (Exception e) {
            //e.toString();
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Recipe_DTO recipe_dto_ = (Recipe_DTO) adapterView.getAdapter().getItem(i);
        Intent intent = new Intent(MainActivity.this, RecipeActivity.class);
        intent.putExtra("name", recipe_dto_.getName());
        intent.putExtra("prepare", String.valueOf(recipe_dto_.getPrepare()));
        intent.putExtra("cook", String.valueOf(recipe_dto_.getCook()));
        intent.putExtra("serves", String.valueOf(recipe_dto_.getServes()));
        intent.putExtra("summary", recipe_dto_.getSummary());
        intent.putExtra("ingredients", recipe_dto_.getIngredients());
        intent.putExtra("directions", recipe_dto_.getDirections());
        intent.putExtra("image_url", recipe_dto_.getImage_url());
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        if (getInterstitial().isLoaded()) {
            getInterstitial().show();
        }
        super.onBackPressed();
    }

    private void loadIntersticial() {
        interstitial = new InterstitialAd(this);
        interstitial.setAdUnitId(getResources().getString(R.string.admob_interstitial));
        AdRequest adRequest = new AdRequest.Builder().build();
        interstitial.loadAd(adRequest);
    }

    public InterstitialAd getInterstitial() {
        return interstitial;
    }

    /****/
    private void loadBanner() {
        AdView adView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
    }
}
