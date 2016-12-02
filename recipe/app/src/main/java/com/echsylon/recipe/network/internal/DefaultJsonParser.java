package com.echsylon.recipe.network.internal;

import com.echsylon.recipe.network.JsonParser;
import com.google.gson.Gson;


public class DefaultJsonParser implements JsonParser {

    @Override
    public <T> T fromJson(String json, Class<T> classOfT) throws IllegalArgumentException {
        return new Gson().fromJson(json, classOfT);
    }

    @Override
    public String toJson(Object object) throws IllegalArgumentException {
        return new Gson().toJson(object);
    }

}
