package com.echsylon.recipe;

import android.widget.Toast;

import com.echsylon.atlantis.Atlantis;

/**
 * Created by laszlo on 2016-12-02.
 */

public class DebugRecipeApplication extends RecipeApplication {
    private Atlantis atlantis;

    @Override
    public void onCreate() {
        super.onCreate();
        atlantis = Atlantis.start(this, "atlantis/config.json",
                () -> {
                    Toast.makeText(this, "Atlantis started successfully", Toast.LENGTH_SHORT).show();
                }, cause -> {
                    cause.printStackTrace();
                    Toast.makeText(this, "Couldn't start Atlantis", Toast.LENGTH_SHORT).show();
                });
    }
}
