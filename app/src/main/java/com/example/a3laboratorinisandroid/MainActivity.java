package com.example.a3laboratorinisandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String[] fak = {"Augusto Gustaičio aviacijos institutas", "Architektūros fakultetas",
            "Aplinkos inžinerijos fakultetas", "Elektronikos fakultetas",
            "Fundamentinių mokslų fakultetas", "Kūrybinių industrijų fakultetas",
            "Mechanikos fakultetas", "Statybos fakultetas", "Transporto inžinerijos fakultetas",
            "Verslo vadybos fakultetas"};
    String[] days = {"Pirmadienis", "Antradienis", "Trečiadienis", "Ketvirtadienis", "Penktadienis"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editText = (EditText) findViewById(R.id.editText);
        AutoCompleteTextView actv = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
        RatingBar simpleRatingBar = (RatingBar) findViewById(R.id.ratingBar);
        Spinner spin = (Spinner) findViewById(R.id.planets_spinner);
        TimePicker timePicker = (TimePicker) findViewById(R.id.timePicker);
        Switch swit = (Switch) findViewById(R.id.switch1);
        Button btn = (Button) findViewById(R.id.button);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this, android.R.layout.select_dialog_item, fak);
        actv.setThreshold(1);
        actv.setAdapter(adapter);

        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, days);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(aa);

        swit.setTextOff("Ne");
        swit.setTextOn("Taip");

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name, text, date, reg;
                float stars;

                name = editText.getText().toString();
                text = actv.getText().toString();
                stars = simpleRatingBar.getRating();
                date = spin.getSelectedItem().toString();

                if (swit.isChecked())
                    reg = swit.getTextOn().toString();
                else
                    reg = swit.getTextOff().toString();

                Toast.makeText(getApplicationContext(), "Pavadinimas: " + name + "\n" +
                        "Fakultetas: " + text + "\n" +
                        "Sudėtingumas: " + stars + "\n" +
                        "Diena: " + date + "\n" +
                        "Laikas: " + timePicker.getCurrentHour() + "h "
                        + timePicker.getCurrentMinute() + "min" + "\n" +
                        "Registruotis: " + reg, Toast.LENGTH_SHORT).show();
            }
        });
    }
}