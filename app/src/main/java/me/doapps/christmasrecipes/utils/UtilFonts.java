package me.doapps.christmasrecipes.utils;

import android.content.Context;
import android.graphics.Typeface;

/**
 * Created by jonathan on 23/11/2014.
 */
public class UtilFonts {
    public static Typeface setHollyBerry(Context context){
        return Typeface.createFromAsset(context.getAssets(), "fonts/HollyBerryWonderland.ttf");
    }
}
