package me.doapps.christmasrecipes.beans;

import com.parse.ParseClassName;
import com.parse.ParseObject;
import com.parse.ParseQuery;

/**
 * Created by jonathan on 25/11/2014.
 */
@ParseClassName("Recipes")
public class Recipe_DTO extends ParseObject {
    private String objectId;
    private String name;
    private int prepare;
    private int cook;
    private int serves;
    private String summary;
    private String directions;
    private String ingredients;
    private String image_url;

    private int res_id;

    public Recipe_DTO() {
    }

    public Recipe_DTO(String name, int res_id) {
        this.name = name;
        this.res_id = res_id;
    }

    public Recipe_DTO(String objectId, String directions, String summary, String name, int prepare, int serves, int cook, String ingredients) {
        this.objectId = objectId;
        this.directions = directions;
        this.summary = summary;
        this.name = name;
        this.prepare = prepare;
        this.serves = serves;
        this.cook = cook;
        this.ingredients = ingredients;
    }

    public String getObjectId() {
        return getString("objectId");
    }

    public void setObjectId(String objectId) {
        put("objectId", objectId);
    }

    public String getName() {
        return getString("name");
    }

    public void setName(String name) {
        put("name", name);
    }

    public int getPrepare() {
        return getInt("prepare");
    }

    public void setPrepare(int prepare) {
        put("prepare", prepare);
    }

    public int getCook() {
        return getInt("cook");
    }

    public void setCook(int cook) {
        put("cook", cook);
    }

    public int getServes() {
        return getInt("serves");
    }

    public void setServes(int serves) {
        put("serves", serves);
    }

    public String getSummary() {
        return getString("summary");
    }

    public void setSummary(String summary) {
        put("summary", summary);
    }

    public String getDirections() {
        return getString("directions");
    }

    public void setDirections(String directions) {
        put("directions", directions);
    }

    public String getIngredients() {
        return getString("ingredients");
    }

    public void setIngredients(String ingredients) {
        put("ingredients", ingredients);
    }

    public int getRes_id() {
        return getInt("res_id");
    }

    public void setRes_id(int res_id) {
        put("res_id", res_id);
    }

    public String getImage_url() {
        return getString("image_url");
    }

    public void setImage_url(String image_url) {
        put("image_url", image_url);
    }

    /**
     * querys*
     */
    public static ParseQuery<Recipe_DTO> getQuery() {
        return ParseQuery.getQuery(Recipe_DTO.class);
    }
}