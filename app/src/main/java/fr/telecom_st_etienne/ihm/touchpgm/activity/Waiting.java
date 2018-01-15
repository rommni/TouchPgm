package fr.telecom_st_etienne.ihm.touchpgm.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import fr.telecom_st_etienne.ihm.touchpgm.R;

public class Waiting extends AppCompatActivity {

    CountDownTimer countdowntimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waiting);
        final TextView time = findViewById(R.id.waitingtime);
        if (savedInstanceState == null) {

            Bundle b = getIntent().getExtras();
            final String gametime = b.getString("time");


            countdowntimer = new CountDownTimer(3000, 10) {

                public void onTick(long millisUntilFinished) {
                    String value = String.valueOf(Math.round((double) millisUntilFinished / 1000));
                    time.setText(value);
                }

                public void onFinish() {
                    time.setText("0");
                    Intent intent = new Intent(Waiting.this, InGame.class);
                    Bundle b = new Bundle();
                    b.putString("time", gametime);
                    intent.putExtras(b);
                    finish();
                    startActivity(intent);

                }

            }.start();
        }
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        countdowntimer.cancel();
        this.finish();
    }
}
