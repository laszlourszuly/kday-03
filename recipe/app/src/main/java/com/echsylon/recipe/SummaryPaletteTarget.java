package com.echsylon.recipe;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.graphics.Palette;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

public class SummaryPaletteTarget implements Target {
    private static final int DEFAULT_TITLE_COLOR = Color.argb(128, 255, 255, 255);
    private static final int DEFAULT_BODY_COLOR = Color.argb(96, 255, 255, 255);

    private final ImageView imageView;
    private final TextView titleView;
    private final TextView excerptView;

    public SummaryPaletteTarget(ImageView imageView, TextView titleView, TextView excerptView) {
        this.imageView = imageView;
        this.titleView = titleView;
        this.excerptView = excerptView;
    }

    @Override
    public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
        Palette palette = Palette.from(bitmap).generate();
        Palette.Swatch swatch = palette.getDarkMutedSwatch();

        imageView.setImageBitmap(bitmap);
        titleView.setTextColor(swatch != null ?
                swatch.getTitleTextColor() :
                DEFAULT_TITLE_COLOR);
        excerptView.setTextColor(swatch != null ?
                swatch.getBodyTextColor() :
                DEFAULT_BODY_COLOR);
    }

    @Override
    public void onBitmapFailed(Drawable errorDrawable) {

    }

    @Override
    public void onPrepareLoad(Drawable placeHolderDrawable) {

    }
}
