package io.cere.sdk_android_example;

import android.app.Application;
import android.util.Log;

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
//            this.cereModule.setOnInitializationFinishedHandler(() -> {
//                this.cereModule.sendEventTrustedEvent("LIVE_ONE_CONTEXTUAL_ENTERED");
//                return;
//            });
            this.cereModule.setOnInitializationErrorHandler((String error) -> {
                    Log.e(TAG, error);
            });
            //this.cereModule.init("242", "userID"); For version 1.0.0
            this.cereModule.init("2354", "", "1234567890", "112112", "TRUSTED_3RD_PARTY");
        }
    }
}
