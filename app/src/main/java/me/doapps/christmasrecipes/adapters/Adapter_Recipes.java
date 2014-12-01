package me.doapps.christmasrecipes.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import me.doapps.christmasrecipes.R;
import me.doapps.christmasrecipes.beans.Recipe_DTO;
import me.doapps.christmasrecipes.utils.UtilFonts;

/**
 * Created by jonathan on 29/11/2014.
 */
public class Adapter_Recipes extends BaseAdapter {
    private Context context;
    private ArrayList<Recipe_DTO> recipe_dtos;
    private LayoutInflater inflater;

    public Adapter_Recipes(Context context, ArrayList<Recipe_DTO> recipe_dtos){
        this.context = context;
        this.recipe_dtos = recipe_dtos;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return recipe_dtos.size();
    }

    @Override
    public Object getItem(int i) {
        return recipe_dtos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Holder holder = null;
        Recipe_DTO recipe_dto = recipe_dtos.get(i);
        if(view == null){
            view = inflater.inflate(R.layout.item_recipe, viewGroup, false);
            holder = new Holder();

            holder.txt_recipe_name = (TextView)view.findViewById(R.id.txt_recipe_name);
            holder.txt_recipe_serves = (TextView)view.findViewById(R.id.txt_recipe_serves);
            holder.txt_recipe_cook = (TextView)view.findViewById(R.id.txt_recipe_cook);
            holder.img_recipe = (ImageView)view.findViewById(R.id.img_recipe);

            view.setTag(holder);
        }
        else{
            holder = (Holder)view.getTag();
        }

        holder.txt_recipe_name.setText(recipe_dto.getName());
        holder.txt_recipe_name.setTypeface(UtilFonts.setHelveticaBold(context));
        holder.txt_recipe_serves.setText(String.valueOf(recipe_dto.getServes())+" personas");
        holder.txt_recipe_serves.setTypeface(UtilFonts.setHelveticaThin(context));
        holder.txt_recipe_cook.setText(String.valueOf(recipe_dto.getCook())+" min.");
        holder.txt_recipe_cook.setTypeface(UtilFonts.setHelveticaThin(context));
        Picasso.with(context).load(recipe_dto.getImage_url()).placeholder(R.drawable.recipe_default).centerCrop().fit().into(holder.img_recipe);


        return view;
    }

    /****/
    public static class Holder{
        private TextView txt_recipe_name;
        private TextView txt_recipe_serves;
        private TextView txt_recipe_cook;
        private ImageView img_recipe;
    }
}
