package com.echsylon.recipe;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

public class SummaryBackgroundTarget implements Target {
    private final View backgroundContainer;

    public SummaryBackgroundTarget(View backgroundContainer) {
        this.backgroundContainer = backgroundContainer;
    }

    @Override
    public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
        backgroundContainer.setBackground(new BitmapDrawable(backgroundContainer.getResources(), bitmap));
    }

    @Override
    public void onBitmapFailed(Drawable errorDrawable) {

    }

    @Override
    public void onPrepareLoad(Drawable placeHolderDrawable) {

    }
}
