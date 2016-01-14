package com.blogspot.darokrithia.dungeonfungeon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Start extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
    }
    public void onOkayClick(View v) {
        EditText nameTextField = (EditText) findViewById(R.id.nameTextField);
        String nameText = "Nobody";

        if (v.getId() == R.id.OkayNameButton) {
            nameText = nameTextField.getText().toString();
            RoomActivity.player = new Player(nameText);
            Intent i = new Intent(Start.this, RoomActivity.class);
            startActivity(i);
        }
    }
}
