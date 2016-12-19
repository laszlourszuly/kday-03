package com.echsylon.recipe.common;

import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;

import com.squareup.picasso.Transformation;

public class BlurTransformation implements Transformation {
    private final RenderScript renderScript;
    private final float radius;

    public BlurTransformation(Context context, float blurRadius) {
        this.renderScript = RenderScript.create(context);
        this.radius = blurRadius;
    }

    @Override
    public Bitmap transform(Bitmap source) {
        Allocation input = Allocation.createFromBitmap(renderScript, source);
        Allocation output = Allocation.createTyped(renderScript, input.getType());

        ScriptIntrinsicBlur script = ScriptIntrinsicBlur.create(renderScript, Element.U8_4(renderScript));
        script.setInput(input);
        script.setRadius(radius);
        script.forEach(output);

        Bitmap target = Bitmap.createBitmap(source);
        output.copyTo(target);
        source.recycle();
        return target;
    }

    @Override
    public String key() {
        return getClass().getName();
    }
}
