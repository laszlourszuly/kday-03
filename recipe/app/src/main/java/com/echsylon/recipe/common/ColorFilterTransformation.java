package com.echsylon.recipe.common;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;

import com.squareup.picasso.Transformation;

public class ColorFilterTransformation implements Transformation {
    private final int color;

    public ColorFilterTransformation(int color) {
        this.color = color;
    }

    @Override
    public Bitmap transform(Bitmap source) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColorFilter(new PorterDuffColorFilter(color, PorterDuff.Mode.SRC_ATOP));

        Bitmap bitmap = Bitmap.createBitmap(source.getWidth(), source.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        canvas.drawBitmap(source, 0, 0, paint);
        source.recycle();
        return bitmap;
    }

    @Override
    public String key() {
        return getClass().getName();
    }
}