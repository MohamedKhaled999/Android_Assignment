package android.example.com.recycleapp2;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recycleView =(RecyclerView)findViewById(R.id.recycler_view123);
        RecyclerViewAdapter recyclerViewAdapter= new RecyclerViewAdapter(MainActivity.this,getRecyclerViewItems());
        recycleView.setLayoutManager(new LinearLayoutManager(this));
        recycleView.setAdapter(recyclerViewAdapter);
    }


    private List<RecycleViewItem> getRecyclerViewItems(){
        List<RecycleViewItem> list=new ArrayList<>();

        for (int i =1;i<=12;i++)
            list.add(new RecycleViewItem("Item"+i));
        return list;
    }
}
