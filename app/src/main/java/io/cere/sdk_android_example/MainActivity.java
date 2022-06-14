package io.cere.sdk_android_example;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import io.cere.cere_sdk.CereModule;

public class MainActivity extends AppCompatActivity {

    public static final String USER_HAS_NFTS = "User has nfts";
    public static final String USER_DOES_NOT_HAVE_NFTS = "User does not have nfts";

    private CereModule cereModule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        this.cereModule = CereModule.getInstance(this.getApplication());
        this.cereModule.setOnInitializationFinishedHandler(this::showButtons);
    }

    private void showButtons() {
        Handler mainHandler = new Handler(getMainLooper());
        mainHandler.post(() -> {
            ((Button) findViewById(R.id.button)).setVisibility(View.VISIBLE);
            ((Button) findViewById(R.id.button2)).setVisibility(View.VISIBLE);
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void hasNft(View view) {
        this.cereModule.hasNfts(resp -> {
            Toast.makeText(getApplicationContext(),
                    Boolean.TRUE.equals(Boolean.valueOf(resp)) ? USER_HAS_NFTS : USER_DOES_NOT_HAVE_NFTS,
                    Toast.LENGTH_LONG).show();
        });
    }

    public void goToAnotherActivity(View view) {
        Intent intent = new Intent(this, AnotherActivity.class);
        this.startActivity(intent);
    }
}
