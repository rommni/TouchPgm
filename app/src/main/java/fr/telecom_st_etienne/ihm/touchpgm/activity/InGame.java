package fr.telecom_st_etienne.ihm.touchpgm.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

import fr.telecom_st_etienne.ihm.touchpgm.R;

public class InGame extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingame);
        final Button test = findViewById(R.id.button2);
        final TextView score = findViewById(R.id.score);
        final TextView time = findViewById(R.id.time);
        Bundle b = getIntent().getExtras();
        final String value = b.getString("time");
        test.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        Random rnd = new Random();
                                        int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
                                        test.setBackgroundColor(color);
                                        int score_int;
                                        score_int = Integer.parseInt(score.getText().toString()) + 1;
                                        score.setText(String.valueOf(score_int));
                                    }
                                }
        );
        new CountDownTimer(Long.parseLong(value) * 1000, 10) {

            public void onTick(long millisUntilFinished) {
                String value = String.valueOf((double) millisUntilFinished / 1000);

                //value = String.format("%.2f", value);
                time.setText(value);
            }

            public void onFinish() {
                time.setText("0");
                Intent intent = new Intent(InGame.this, CalmDown.class);
                Bundle b = new Bundle();
                b.putString("score", score.getText().toString());
                b.putString("time", value);//Your id
                intent.putExtras(b); //Put your id to your next Intent
                finish();
                startActivity(intent);

            }

        }.start();
    }
}
