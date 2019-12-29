package com.liveinbits.multiplelayoutrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.hasFixedSize();

        List<ModelClass> listmodel=new ArrayList<>();
        listmodel.add(new ModelClass(ModelClass.USER_DETAIL_LAY,"lakpa","kathmandu",R.drawable.nepal));
        listmodel.add(new ModelClass(ModelClass.USER_DETAIL_LAY,"sonam","boudha",R.drawable.globalnews));
        listmodel.add(new ModelClass(ModelClass.IMAGE_LAY,R.drawable.tiger));
        listmodel.add(new ModelClass(ModelClass.ADD_LAY,"Hello world"));
        listmodel.add(new ModelClass(ModelClass.IMAGE_LAY,R.drawable.globalnews));
        listmodel.add(new ModelClass(ModelClass.ADD_LAY,"Hello universe"));

        CustomAdapter adapter=new CustomAdapter(listmodel);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();


    }
}
