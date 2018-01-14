package touchpgm.ihm.the.touchpgm;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class Waiting extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waiting);
        final TextView msg = findViewById(R.id.waitingmsg);
        msg.setText(R.string.getready);
        final TextView time = findViewById(R.id.waitingtime);
        Bundle b = getIntent().getExtras();
        final String gametime = b.getString("time");


        new CountDownTimer(3000, 10) {

            public void onTick(long millisUntilFinished) {
                String value = String.valueOf(Math.round((double)millisUntilFinished/1000 + 0.8));

                time.setText(value);
            }
            public void onFinish() {
                time.setText("0");
                Intent intent = new Intent(Waiting.this, InGame.class);
                Bundle b = new Bundle();
                b.putString("time",gametime);
                intent.putExtras(b);
                finish();
                startActivity(intent);

            }

        }.start();
    }
    }
