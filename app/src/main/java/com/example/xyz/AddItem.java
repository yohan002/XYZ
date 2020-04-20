package com.example.xyz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AddItem extends AppCompatActivity {

    private DBHelper helper;
    EditText name1,description1,quantity1;
    Button submit;
    String name_field,description_field,quantity_field;
    TextView arrowback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        arrowback = findViewById(R.id.arrowback);
        helper = new DBHelper(this);
        name1 = findViewById(R.id.name1);
        description1 = findViewById(R.id.description1);
        quantity1 = findViewById(R.id.quantity1);
        submit = findViewById(R.id.submit);

        arrowback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name_field = name1.getText().toString();
                description_field = description1.getText().toString();
                quantity_field = quantity1.getText().toString();

                if(TextUtils.isEmpty(name_field)){
                    name1.setError("Must be filled");
                    name1.requestFocus();
                }
                else if(TextUtils.isEmpty(description_field)){
                    description1.setError("Must be filled");
                    description1.requestFocus();
                }
                else if(TextUtils.isEmpty(quantity_field)){
                    quantity1.setError("Must be filled");
                    quantity1.requestFocus();
                }
                else{
                    Interface.datainterface.insertData(name_field,description_field,quantity_field);
                    finish();
                }
            }

        });

    }
}
