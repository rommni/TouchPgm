package touchpgm.ihm.the.touchpgm;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;
import java.text.DecimalFormat;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        final Button test = findViewById(R.id.button2);
        final TextView score = findViewById(R.id.score);
        final TextView time = findViewById(R.id.time);
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
        new CountDownTimer(5000, 10) {

            public void onTick(long millisUntilFinished) {
                String value = String.valueOf((double)millisUntilFinished/1000);

                //value = String.format("%.2f", value);
                time.setText(value);
            }

            public void onFinish() {
                time.setText("0");
                Intent intent = new Intent(Main3Activity.this, Main4Activity.class);
                Bundle b = new Bundle();
                b.putString("score", score.getText().toString()); //Your id
                intent.putExtras(b); //Put your id to your next Intent
                startActivity(intent);
                finish();
            }

        }.start();
    }
}
