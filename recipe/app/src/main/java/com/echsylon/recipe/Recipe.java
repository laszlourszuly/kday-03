package com.echsylon.recipe;

import com.echsylon.recipe.network.NetworkClient;
import com.echsylon.recipe.network.Request;
import com.echsylon.recipe.network.internal.AsyncNetworkRequest;
import com.echsylon.recipe.network.internal.DefaultJsonParser;
import com.echsylon.recipe.network.internal.DefaultNetworkClient;


public class Recipe {

    public static Request<Recipe> getRecipe(long id) {
        NetworkClient networkClient = new DefaultNetworkClient(new DefaultJsonParser());
        String url = String.format("%s/recipe?id=%s", BuildConfig.BASE_URL, id);
        return AsyncNetworkRequest.prepareRequest(networkClient, url, "GET", null, null, Recipe.class);
    }

    public static Request<Summary[]> getRecipes() {
        NetworkClient networkClient = new DefaultNetworkClient(new DefaultJsonParser());
        String url = String.format("%s/recipe/menu", BuildConfig.BASE_URL);
        return AsyncNetworkRequest.prepareRequest(networkClient, url, "GET", null, null, Summary[].class);
    }

    public static final class Summary {
        public final Long id = null;
        public final String image = null;
        public final String name = null;
        public final String excerpt = null;
        public final Float rating = null;
        public final String[] ingredients = null;
    }

    public static final class Section {
        public final String name = null;
        public final Ingredient[] ingredients = null;
    }

    public static final class Ingredient {
        public final String ingredient = null;
        public final Float quantity = null;
        public final String unit = null;
        public final String text = null;
    }

    public final Long id = null;
    public final String title = null;
    public final String image = null;
    public final String description = null;
    public final String rating = null;
    public final String difficulty = null;
    public final String time = null;
    public final Integer portions = null;
    public final Section[] paragraphs = null;

}
