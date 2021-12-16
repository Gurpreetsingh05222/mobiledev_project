package com.example.rgsj;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.rgsj.db.AppDatabase;
import com.example.rgsj.db.User;

import java.util.ArrayList;
import java.util.Collections;

public class Verify extends AppCompatActivity {

    VerifyListAdapter adapter;
    Button verifybtn;
    ImageView  btn_refresh;
    int pos = 0;
    CheckBox checkBox;

    private ArrayList<VerifyModel> imageIDs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.verify);

        verifybtn = findViewById(R.id.btn_verify);
        checkBox = findViewById(R.id.checkbox);
        btn_refresh = findViewById(R.id.btn_refresh);

        imageIDs =new ArrayList<VerifyModel>();
        imageIDs.add(new VerifyModel(R.drawable.img1,0,false));
        imageIDs.add(new VerifyModel(R.drawable.img2,1,false));
        imageIDs.add(new VerifyModel(R.drawable.img3,2,false));
        imageIDs.add(new VerifyModel(R.drawable.img4,3,false));
        imageIDs.add(new VerifyModel(R.drawable.img5,4,false));
        imageIDs.add(new VerifyModel(R.drawable.img6,5,false));
        imageIDs.add(new VerifyModel(R.drawable.img7,6,false));
        imageIDs.add(new VerifyModel(R.drawable.img8,7,false));
        imageIDs.add(new VerifyModel(R.drawable.img9,8,false));

        RecyclerView recyclerView = findViewById(R.id.recyclerview_verify);
        recyclerView.setLayoutManager(new GridLayoutManager(this,3));
        adapter = new VerifyListAdapter(this, imageIDs,itemClick);
        recyclerView.setAdapter(adapter);

        btn_refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // first swap the item using  Collections.swap() method
                Collections.swap(imageIDs, 0, 8);

// than notify your adapter about change in list using  notifyItemMoved() method
                adapter.notifyItemMoved(0, 8);
            }
        });


        verifybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox.isChecked()){
                    if (pos == 6){
                        saveNewUser(
                                getIntent().getStringExtra("name"),
                                getIntent().getStringExtra("email"),
                                getIntent().getStringExtra("phone"));

                        Intent myIntent = new Intent(Verify.this, MainActivity.class);
                        Verify.this.startActivity(myIntent);
                        finish();
                    }else {
                        Toast.makeText(getApplicationContext(),"you are not verified",Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(getApplicationContext(),"you are not verified",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    void getid(int id){
       pos = id;
    }


    View.OnClickListener itemClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            /*int i = (int) v.getTag();
            if (imageIDs.get(i).isSelected() == false){
                imageIDs.get(i).setSelected(true);
                int id = imageIDs.get(i).getid();
                pos = pos + id;
                adapter.notifyDataSetChanged();
            }else if (imageIDs.get(i).isSelected() == true){
                imageIDs.get(i).setSelected(false);
                adapter.notifyDataSetChanged();
                int id = imageIDs.get(i).getid();
                pos = pos - id;
            }*/
        }
    };


    private void saveNewUser(String name, String email, String phone) {
        AppDatabase db  = AppDatabase.getDbInstance(this.getApplicationContext());

        User user = new User();
        user.Name = name;
        user.Eamil = email;
        user.Phone = phone;
        db.userDao().insertUser(user);

        Toast.makeText(getApplicationContext(),"you are successfully verified",Toast.LENGTH_SHORT).show();
        finish();

    }


}