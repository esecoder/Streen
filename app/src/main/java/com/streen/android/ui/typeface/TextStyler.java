package com.streen.android.ui.typeface;

import android.content.Context;
import android.graphics.Typeface;

/**
 * Typeface class for creating font objects
 * Created by Ese Udom on 1/15/2019.
 */
public class TextStyler {

    public TextStyler() {
    }

    public static Typeface setVarelaRoundRegularFont(Context context) {
        return Typeface.createFromAsset(context.getAssets(), "fonts/Varela-Round-regular.otf");
    }

}
