package me.doapps.christmasrecipes.adapters;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import me.doapps.christmasrecipes.R;
import me.doapps.christmasrecipes.activities.RecipeActivity;
import me.doapps.christmasrecipes.beans.Recipe_DTO;

/**
 * Created by jonathan on 25/11/2014.
 */
public class Adapter_Recipe extends RecyclerView.Adapter<Adapter_Recipe.ViewHolder> {
    private ArrayList<Recipe_DTO> recipe_dtos;
    private int itemLayout;

    public Adapter_Recipe(ArrayList<Recipe_DTO> recipe_dtos, int itemLayout) {
        this.recipe_dtos = recipe_dtos;
        this.itemLayout = itemLayout;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(itemLayout, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, int i) {
        Recipe_DTO recipe_dto = recipe_dtos.get(i);
        viewHolder.txt_recipe_name.setText(recipe_dto.getName());
        viewHolder.img_recipe.setImageResource(recipe_dto.getRes_id());
    }

    @Override
    public int getItemCount() {
        return recipe_dtos.size();
    }

    /**
     * Holder*
     */
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView txt_recipe_name;
        public ImageView img_recipe;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            txt_recipe_name = (TextView) itemView.findViewById(R.id.txt_recipe_name);
            img_recipe = (ImageView) itemView.findViewById(R.id.img_recipe);
        }

        @Override
        public void onClick(View view) {
            itemView.getContext().startActivity(new Intent(itemView.getContext(), RecipeActivity.class));
        }
    }
}
