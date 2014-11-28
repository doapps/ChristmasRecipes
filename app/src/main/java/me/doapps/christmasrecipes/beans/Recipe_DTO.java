package me.doapps.christmasrecipes.beans;

/**
 * Created by jonathan on 25/11/2014.
 */
public class Recipe_DTO {
    private String objectId;
    private String name;
    private int prepare;
    private int cook;
    private int serves;
    private String summary;
    private String directions;
    private String ingredients;

    private int res_id;

    public Recipe_DTO(){}

    public Recipe_DTO(String name, int res_id){
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
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrepare() {
        return prepare;
    }

    public void setPrepare(int prepare) {
        this.prepare = prepare;
    }

    public int getCook() {
        return cook;
    }

    public void setCook(int cook) {
        this.cook = cook;
    }

    public int getServes() {
        return serves;
    }

    public void setServes(int serves) {
        this.serves = serves;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDirections() {
        return directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public int getRes_id() {
        return res_id;
    }

    public void setRes_id(int res_id) {
        this.res_id = res_id;
    }
}
