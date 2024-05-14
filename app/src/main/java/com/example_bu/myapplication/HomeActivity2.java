package com.example_bu.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class HomeActivity2 extends AppCompatActivity implements RvInterface{

    RecyclerView r;
    RecyclerView.LayoutManager l;
    RvAdapter rv;
    int[] arr={R.drawable.arrow_black,R.drawable.baseline_cloud_done_24,R.drawable.float_btn,R.drawable.ic_launcher_foreground,R.drawable.arrow_black,R.drawable.baseline_cloud_done_24,R.drawable.float_btn,R.drawable.ic_launcher_foreground};
    String[] stra={"home","factory","school","default","home","factory","school","default"};

    String[] str2={"12.04.34.3","23.124.35.23","234.34.56.7","234.56.7.8","12.04.34.3","23.124.35.23","234.34.56.7","234.56.7.8"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        r=findViewById(R.id.rcview);
        l=new GridLayoutManager(this,2);
        r.setLayoutManager(l);
        rv=new RvAdapter(this, arr, stra);
        r.setAdapter(rv);
        r.setHasFixedSize(true);
        Toast.makeText(this, getIntent().getStringExtra("userid"), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void ItemClicked(int position) {
        Intent finalI=new Intent(HomeActivity2.this,Actionbtn.class);
        finalI.putExtra("id",str2[position]);
        finalI.putExtra("h",stra[position]);
        startActivity(finalI);


    }
}