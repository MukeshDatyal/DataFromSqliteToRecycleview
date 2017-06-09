package com.example.mukeshdatyal.datafromsqlitetorecycleview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Details extends AppCompatActivity {
    DBHelper helper;
    List<DBModel> DBlist;
    int position;
    TextView Name,Email,RollNo,Address,Branch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_details);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        // 5. get status value from bundle
         position = bundle.getInt("position");

        Name =(TextView)findViewById(R.id.name);
        Email =(TextView)findViewById(R.id.email);
        RollNo =(TextView)findViewById(R.id.roll);
        Address =(TextView)findViewById(R.id.address);
        Branch =(TextView)findViewById(R.id.branch);
        helper = new DBHelper(this);
        DBlist= new ArrayList<DBModel>();
        DBlist = helper.getDataFromDB();

        if(DBlist.size()>0){
            String name= DBlist.get(position).getName();
            String email=DBlist.get(position).getEmail();
            String roll=DBlist.get(position).getRoll();
            String address=DBlist.get(position).getAddress();
            String branch=DBlist.get(position).getBranch();
            Name.setText(name);
            Email.setText(email);
            RollNo.setText(roll);
            Address.setText(address);
            Branch.setText(branch);
        }

        Toast.makeText(Details.this, DBlist.toString(), Toast.LENGTH_LONG);
    }


    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_details, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
