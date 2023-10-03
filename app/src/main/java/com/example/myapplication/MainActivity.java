package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView = findViewById(R.id.textView);
    EditText editText = findViewById(R.id.editTextText);
    Button button = findViewById(R.id.button);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    private void DisplaySavedText() {
        //Retrieving the value from SharedPref
        SharedPreferences sharedPreferences = getSharedPreferences("MyShared{ref", MODE_PRIVATE);

        String s1 = sharedPreferences.getString("name", " ");

        textView.setText(s1);
    }

    private void DisplayAndSaveText(String enteredText) {
        //Display the text
        editText.setText(enteredText);

        //Saving the text into SharedPref
        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("name", enteredText);

        editor.apply();

    }
}

