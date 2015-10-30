package com.example.notandi.hanastel;

/**
 * Created by SigurdurMarAtlason on 29/10/15.
 */
public class CocktailRecipe {

    private String name;
    private String imgPath;

    public CocktailRecipe() {

    }

    public CocktailRecipe(String name, String imgPath) {
        this.name = name;
        this.imgPath = imgPath;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getImgPath(){
        return this.imgPath;
    }

    public void setImgPath(String imgPath){
        this.imgPath = imgPath;
    }

}
