package touchpgm.ihm.the.touchpgm;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;

public class CalmDown extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calm_down);
        Bundle b = getIntent().getExtras();
        final String value = b.getString("score");
        final String time = b.getString("time");
        final ProgressBar progressBar = findViewById(R.id.progressBar);

        new CountDownTimer(1000, 10) {

            public void onTick(long millisUntilFinished) {
                long value = Math.round((double)millisUntilFinished/100);

                progressBar.setProgress((int)value);
            }
            public void onFinish() {
                Intent intent = new Intent(CalmDown.this,ScoreResult.class);
                Bundle b = new Bundle();
                b.putString("time",time);
                b.putString("score", value);
                intent.putExtras(b);
                finish();
                startActivity(intent);

            }

        }.start();

    }

}
