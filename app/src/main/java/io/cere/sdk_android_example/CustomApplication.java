package io.cere.sdk_android_example;

import static android.view.ViewGroup.LayoutParams.FILL_PARENT;
import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;

import android.app.Application;
import android.content.res.Resources;
import android.util.Log;
import android.widget.RelativeLayout;

import io.cere.cere_sdk.CereModule;
import io.cere.cere_sdk.InitStatus;

public class CustomApplication extends Application {
    private static String TAG = "CustomApplication";
    private CereModule cereModule = null;
    public void onCreate() {
        super.onCreate();
        if (CereModule.getInstance(this).getInitStatus() == InitStatus.Initialised.INSTANCE) {
            this.cereModule = CereModule.getInstance(this);
        } else {
            this.cereModule = CereModule.getInstance(this);
            this.cereModule.setOnInitializationErrorHandler((String error) -> {
                    Log.e(TAG, error);
            });
//            RelativeLayout.LayoutParams params = new  RelativeLayout.LayoutParams(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
//            params.width = MATCH_PARENT;
//            params.height = MATCH_PARENT;


            this.cereModule.setTheme(R.style.CereEventTheme);

//            this.cereModule.webview.setInitialScale(80);

//            this.cereModule.setLayout(params);
//            this.cereModule.webview.layout(-10, -10, -10, 10);

            this.cereModule.init("2354", "", "1234567890", "112112", "TRUSTED_3RD_PARTY");
        }
    }
}
