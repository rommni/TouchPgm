package fr.telecom_st_etienne.ihm.touchpgm.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import fr.telecom_st_etienne.ihm.touchpgm.R;
import fr.telecom_st_etienne.ihm.touchpgm.filter.InputFilterMinMax;

public class Accueil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Resources res = getResources();
        final int minSeconde = res.getInteger(R.integer.min_secondes);
        final int maxSeconde = res.getInteger(R.integer.max_secondes);




        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);

        final TextView time = findViewById(R.id.time);
        time.setText("5");
        time.setFilters(new InputFilter[]{new InputFilterMinMax(minSeconde,maxSeconde)});

        final TextView consigneSeconde = findViewById(R.id.consigne_seconde);
        String consigneSecondeString = getString(R.string.Consigne_seconde, minSeconde, maxSeconde);
        consigneSeconde.setText(consigneSecondeString);

        final Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Accueil.this, Waiting.class);
                Bundle b = new Bundle();
                b.putString("time", time.getText().toString()); //Your id
                intent.putExtras(b); //Put your id to your next Intent
                startActivity(intent);
            }
        });
    }
}
