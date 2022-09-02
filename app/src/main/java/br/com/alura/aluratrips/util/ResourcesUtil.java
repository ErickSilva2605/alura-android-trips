package br.com.alura.aluratrips.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

import androidx.core.content.res.ResourcesCompat;

public class ResourcesUtil {

    public static final String KEY_DRAWABLE = "drawable";

    public static Drawable getDrawableByName(Context context, String resourceName) {
        Resources resources = context.getResources();
        int drawableId = resources.getIdentifier(resourceName
                , KEY_DRAWABLE, context.getPackageName());
        return ResourcesCompat.getDrawable(resources, drawableId, null);
    }
}
