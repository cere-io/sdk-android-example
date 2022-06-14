package io.cere.sdk_android_example;

import android.app.Application;
import android.util.Log;
import android.view.View;
import android.widget.Button;

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

//            this.cereModule.init("2354", "", "1234567890", "112112112", "TRUSTED_3RD_PARTY", "dev");
            this.cereModule.init("2096", "", "1234567890", "112112112", "TRUSTED_3RD_PARTY", "stage");
            this.cereModule.attachEventListener((s, activity) -> {
                if ("HEADER_CLICKED".equals(s)) {
                    activity.finish();
                }
            });
        }
    }
}
