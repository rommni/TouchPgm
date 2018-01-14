package fr.telecom_st_etienne.ihm.touchpgm.activity;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.sax.TextElementListener;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import java.util.Collections;
import java.util.List;

import fr.telecom_st_etienne.ihm.touchpgm.R;
import fr.telecom_st_etienne.ihm.touchpgm.save.AppDatabase;
import fr.telecom_st_etienne.ihm.touchpgm.save.Save;
import fr.telecom_st_etienne.ihm.touchpgm.save.SaveDao;

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
        final float timeValue = Float.parseFloat(time);
        final float scoreValue = Float.parseFloat(value);
        final float scoreBySecondValue = scoreValue/timeValue;
        final TextView scoreBySecond = findViewById(R.id.scoreBySecond_result);
        final String scoreBySecondText = Float.toString(scoreBySecondValue);
        scoreBySecond.setText(scoreBySecondText);


        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "save").build();
        SaveDao saveDao = db.saveDao();
        List<Save> saves = saveDao.getAllOrderByTps();
        List<Float> tpsTab = saveDao.getTpsOrderByTps();
        db.close();

        int position = 0;
        if(tpsTab != null){
            position = Collections.binarySearch(tpsTab, scoreBySecondValue) +1;
        }else {
            position = 1;
        }

        final TextView rang1 = findViewById(R.id.tab_rang_1);
        final TextView nom1 = findViewById(R.id.tab_nom_1);
        final TextView tps1 = findViewById(R.id.tab_tps_1);
        final TextView temps1 = findViewById(R.id.tab_temps_1);


        if(saves.size() >1){
            final TextView rang2 = findViewById(R.id.tab_rang_2);
            final TextView nom2 = findViewById(R.id.tab_nom_2);
            final TextView tps2 = findViewById(R.id.tab_tps_2);
            final TextView temps2 = findViewById(R.id.tab_temps_2);

            final TextView rang3 = findViewById(R.id.tab_rang_3);
            final TextView nom3 = findViewById(R.id.tab_nom_3);
            final TextView tps3 = findViewById(R.id.tab_tps_3);
            final TextView temps3 = findViewById(R.id.tab_temps_3);

            Save save1 = saves.get(position-2);
            rang1.setText(position-1);
            nom1.setText(save1.getName());
            tps1.setText(Float.toString(save1.getTps()));
            temps1.setText(Float.toString(save1.getGameTime()));

            rang2.setText(position);
            nom2.setText(R.string.votre_score);
            tps2.setText(scoreBySecondText);
            temps2.setText(time);

            Save save2 = saves.get(position);
            rang3.setText(position+1);
            nom3.setText(save2.getName());
            tps3.setText(Float.toString(save2.getTps()));
            temps3.setText(Float.toString(save2.getGameTime()));

        }else{
            rang1.setText("1");
            nom1.setText(R.string.votre_score);
            tps1.setText(scoreBySecondText);
            temps1.setText(time);
        }


        Button restart = findViewById(R.id.button4);
        restart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(ScoreResult.this, Waiting.class);
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
                finish();

            }
        });

    }

}
