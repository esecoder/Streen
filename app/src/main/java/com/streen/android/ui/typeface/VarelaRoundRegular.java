package com.streen.android.ui.typeface;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.Log;

import androidx.appcompat.widget.AppCompatTextView;

import java.util.Hashtable;

/**
 * Roboto typeface TextView class
 * Created by Ese Udom on 1/15/2019.
 */
public class VarelaRoundRegular extends AppCompatTextView {

    private static final String TAG = VarelaRoundRegular.class.getSimpleName();
    private static final Hashtable<String, Typeface> cache = new Hashtable<>();

    public VarelaRoundRegular(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    /*@TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public Roboto(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }*/

    public VarelaRoundRegular(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public VarelaRoundRegular(Context context) {
        super(context);
        init();
    }

    /**
     * Creates a typeface object from font file
     * @param context the current context
     * @param assetPath path to typeface ttf in the asset directory
     * @return Typeface
     */
    private static Typeface get(Context context, String assetPath) {
        synchronized (cache) {
            if (!cache.containsKey(assetPath)) {
                try {
                    Typeface typeface = Typeface.createFromAsset(context.getAssets(), assetPath);
                    cache.put(assetPath, typeface);
                } catch (Exception e) {
                    Log.e(TAG, "Could not get font " + assetPath + " because " + e.getMessage());
                    return null;
                }
            }
            return cache.get(assetPath);
        }
    }

    /**
     * Initialization method
     */
    private void init() {
        Typeface typeface = get(getContext(), "fonts/Varela-Round-regular.ttf");
        setTypeface(typeface);
    }
}
