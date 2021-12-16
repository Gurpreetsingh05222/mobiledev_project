package com.example.rgsj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    EditText edit_name,edit_email,edit_phone;
    Button btn_savebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        edit_name = findViewById(R.id.edit_name);
        edit_email = findViewById(R.id.edit_email);
        edit_phone = findViewById(R.id.edit_mobile);
        btn_savebtn = findViewById(R.id.btn_save);

        saveDetail();

    }

    private void saveDetail(){
        btn_savebtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                validation();
            }
        });
    }

    private void validation(){
        if (edit_name.getText().toString().trim().length() == 0){
            Toast.makeText(getApplicationContext(),"you should fill all the fields",Toast.LENGTH_LONG).show();;
        }else if (edit_email.getText().toString().trim().length() == 0){
            Toast.makeText(getApplicationContext(),"you should fill all the fields",Toast.LENGTH_LONG).show();
        }else  if (edit_phone.getText().toString().trim().length() == 0){
            Toast.makeText(getApplicationContext(),"you should fill all the fields",Toast.LENGTH_LONG).show();
        }else {
            Intent myIntent = new Intent(Register.this, Verify.class);
            myIntent.putExtra("name",edit_name.getText().toString());
            myIntent.putExtra("email",edit_email.getText().toString());
            myIntent.putExtra("phone",edit_phone.getText().toString());

            Register.this.startActivity(myIntent);
            finish();

        }
    }
}