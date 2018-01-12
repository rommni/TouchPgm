package touchpgm.ihm.the.touchpgm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ScoreResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoreresult);
        Bundle b = getIntent().getExtras();
        String value = b.getString("score");
        final String time = b.getString("time");
        final TextView score = findViewById(R.id.score_result);
        score.setText(value);
        Button restart = findViewById(R.id.button4);
        restart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(ScoreResult.this, InGame.class);
                Bundle b = new Bundle();
                b.putString("time",time);//Your id
                intent.putExtras(b); //Put your id to your next Intent
                finish();
                startActivity(intent);


            }
        });
        Button home = findViewById(R.id.button6);
        home.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
               // Intent intent = new Intent(ScoreResult.this, Accueil.class);
                finish();
                //startActivity(intent);

            }
        });

    }

}
