package xyz.everstar.app.whoisspy;

import android.app.Application;
import android.graphics.Typeface;

import com.norbsoft.typefacehelper.TypefaceCollection;
import com.norbsoft.typefacehelper.TypefaceHelper;

public class WISApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        GlobalSource.FONT_ENG = Typeface.createFromAsset(getAssets(), "GloriaHallelujah.ttf");
        TypefaceCollection typefaceCollection = new TypefaceCollection.Builder()
                .set(Typeface.NORMAL, GlobalSource.FONT_ENG)
                .create();
        TypefaceHelper.init(typefaceCollection);
    }
}
