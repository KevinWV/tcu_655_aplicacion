package com.example.usuario.tcu_655;

import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.app.Activity;
import android.widget.ImageView;

public class PantallaCarga extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_carga);

        int loadtime = 3000;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent next2 = new Intent(PantallaCarga.this, ActPrincipal.class);
                startActivity(next2);
                finish();
            }

        }, loadtime);
    }
}
