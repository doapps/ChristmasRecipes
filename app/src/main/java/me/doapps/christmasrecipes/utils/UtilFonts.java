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
    public static Typeface setHelveticaBold(Context context){
        return Typeface.createFromAsset(context.getAssets(), "fonts/Helvetica_Bold.otf.ttf");
    }
    public static Typeface setHelveticaMedium(Context context){
        return Typeface.createFromAsset(context.getAssets(), "fonts/Helvetica_Medium.otf.ttf");
    }
    public static Typeface setHelveticaRoman(Context context){
        return Typeface.createFromAsset(context.getAssets(), "fonts/Helvetica_Roman.otf.ttf");
    }
    public static Typeface setHelveticaThin(Context context){
        return Typeface.createFromAsset(context.getAssets(), "fonts/Helvetica_Thin.otf.ttf");
    }
}
