package touchpgm.ihm.the.touchpgm;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        Bundle b = getIntent().getExtras();
        String value = b.getString("score");
        final TextView score = findViewById(R.id.score_result);
        score.setText(value);
        Button restart = findViewById(R.id.button4);
        restart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Main4Activity.this, Main3Activity.class);
                finish();
                startActivity(intent);

            }
        });
        Button home = findViewById(R.id.button6);
        home.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
               // Intent intent = new Intent(Main4Activity.this, MainActivity.class);
                finish();
                //startActivity(intent);

            }
        });

    }

}
