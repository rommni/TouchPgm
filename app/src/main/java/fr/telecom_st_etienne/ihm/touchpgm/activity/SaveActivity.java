package fr.telecom_st_etienne.ihm.touchpgm.activity;


import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import fr.telecom_st_etienne.ihm.touchpgm.R;
import fr.telecom_st_etienne.ihm.touchpgm.save.AppDatabase;
import fr.telecom_st_etienne.ihm.touchpgm.save.Save;
import fr.telecom_st_etienne.ihm.touchpgm.save.SaveDao;

public class SaveActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save);
        final EditText name = findViewById(R.id.nameText);
        Bundle b = getIntent().getExtras();
        final float tps = b.getFloat("tps");
        final int gameTime = b.getInt("gameTime");


        final Button cancel = findViewById(R.id.buttonCancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        final Button save = findViewById(R.id.buttonSave);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Save save = new Save();
                save.setName(name.getText().toString());
                save.setTps(tps);
                save.setGameTime(gameTime);
                AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                        AppDatabase.class, "save").allowMainThreadQueries().build();
                SaveDao saveDao= db.saveDao();
                saveDao.insert(save);
                db.close();
                finish();

            }
        });
    }

}
