package me.doapps.christmasrecipes.activities;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.shamanland.fab.FloatingActionButton;

import java.util.ArrayList;

import me.doapps.christmasrecipes.R;
import me.doapps.christmasrecipes.adapters.Adapter_Recipe;
import me.doapps.christmasrecipes.beans.Recipe_DTO;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {
    private RecyclerView recycler_recipes;
    private FloatingActionButton fab_share;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycler_recipes = (RecyclerView)findViewById(R.id.recycler_recipes);
        fab_share = (FloatingActionButton)findViewById(R.id.fab_share);
        fab_share.setOnClickListener(this);

        ArrayList<Recipe_DTO> recipe_dtos = new ArrayList<Recipe_DTO>();
        for (int i = 0; i < 10; i++) {
            if(i==0){
                recipe_dtos.add(new Recipe_DTO("Pavo al horno con papas", R.drawable.recipe_default));
            }
            else{
                if(i%2==0){
                    recipe_dtos.add(new Recipe_DTO("Yuca con uevo acaramelado", R.drawable.recipe_example_01));
                }
                else{
                    recipe_dtos.add(new Recipe_DTO("Tacos a la peruana", R.drawable.recipe_example_02));
                }
            }

        }
        recycler_recipes.setHasFixedSize(true);
        recycler_recipes.setAdapter(new Adapter_Recipe(recipe_dtos,R.layout.row_recipes));
        recycler_recipes.setLayoutManager(new LinearLayoutManager(this));
        recycler_recipes.setItemAnimator(new DefaultItemAnimator());

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
        startActivity(new Intent(MainActivity.this, RecipeActivity.class));
    }
}
