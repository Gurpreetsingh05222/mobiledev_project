package com.example.rgsj;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.rgsj.db.AppDatabase;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button btn_adduser;
    UserListAdapter adapter;
    List<com.example.rgsj.db.User> userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_adduser = findViewById(R.id.btn_adduser);

        initView();

        loadUserList();

    }

    private void initView(){
        RecyclerView recyclerView = findViewById(R.id.recycerview_userlist);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new UserListAdapter(this, itemClick);
        recyclerView.setAdapter(adapter);


        btn_adduser.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, Register.class);
                MainActivity.this.startActivity(myIntent);
            }
        });
    }

    View.OnClickListener itemClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int i  = (int) v.getTag();
            Intent myIntent = new Intent(MainActivity.this, User.class);
            myIntent.putExtra("name",userList.get(i).Name);
            myIntent.putExtra("email",userList.get(i).Eamil);
            myIntent.putExtra("phone",userList.get(i).Phone);
            MainActivity.this.startActivity(myIntent);
        }
    };

    private void loadUserList() {
        AppDatabase db = AppDatabase.getDbInstance(this.getApplicationContext());
        userList =db.userDao().getAllUsers();
        adapter.setUserList(userList);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == 100) {
            loadUserList();
        }

        super.onActivityResult(requestCode, resultCode, data);
    }
}