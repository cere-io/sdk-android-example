package io.cere.sdk_android_example;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONObject;

import io.cere.cere_sdk.CereModule;

public class AnotherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);
    }

    public void sendEvent(View view) {
        Payload payload = new Payload("abc@abc.com");
        try {
            CereModule.getInstance(this.getApplication()).sendTrustedEvent("LIVE_ONE_CONTEXTUAL_ENTERED"
                    , new ObjectMapper().writeValueAsString(payload)
            );
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

//        CereModule.getInstance(this.getApplication()).sendTrustedEvent("LIVE_ONE_CONTEXTUAL_ENTERED");
    }
}
