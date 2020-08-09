package android.example.com.todo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText addedText = (EditText) findViewById(R.id.editTextTextMultiLine);
        Button addbutton = (Button) findViewById(R.id.button);
        final ListView list =(ListView)findViewById(R.id.list);
        final ArrayAdapter<String> listAdpter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1);
        list.setAdapter(listAdpter);
        addbutton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                String addTextStr = addedText.getText().toString();

                if (!addTextStr.isEmpty()) {
                    listAdpter.add(addTextStr);
                    addedText.getText().clear();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Enter text !",Toast.LENGTH_LONG).show();
                }
            }

        });
        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                listAdpter.remove(listAdpter.getItem(i));
                return false;
            }
        });



    }
}