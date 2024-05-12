package com.example_bu.myapplication;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class HomeActivity2 extends AppCompatActivity {

    RecyclerView r;
    RecyclerView.LayoutManager l;
    RvAdapter rv;
    int[] arr={R.drawable.arrow_black,R.drawable.baseline_cloud_done_24,R.drawable.float_btn,R.drawable.ic_launcher_foreground};

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
        rv=new RvAdapter(arr);
        r.setAdapter(rv);
        r.setHasFixedSize(true);
    }
}