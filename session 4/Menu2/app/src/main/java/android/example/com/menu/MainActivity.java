package android.example.com.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, MenuItem.OnMenuItemClickListener {
    TextView text ;
    Button alart ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       text =(TextView)findViewById(R.id.tt) ;
       alart=(Button)findViewById(R.id.button2);
       registerForContextMenu(text);
        ImageButton imageB = (ImageButton)findViewById(R.id.imageButton);
        imageB.setOnClickListener(this);
        alart.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.imageButton) {
            //Creating the instance of PopupMenu
            PopupMenu popup = new PopupMenu(MainActivity.this, v);
            //Inflating the Popup using xml file
            popup.getMenuInflater().inflate(R.menu.menu_file, popup.getMenu());

            //registering popup with OnMenuItemClickListener
            popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                public boolean onMenuItemClick(MenuItem item) {
                    Toast.makeText(MainActivity.this, "You Clicked : " + item.getTitle(), Toast.LENGTH_SHORT).show();
                    return true;
                }
            });

            popup.show();//showing popup menu
        }
        else if (v.getId()==R.id.button2){
            AlertDialog.Builder aa = new  AlertDialog.Builder(this);
            aa.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finish();
                }
            });
            aa.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                   // nothings
                }
            });
            
            aa.setMessage("close app?");
            aa.setTitle("Alert");
            aa.show();


        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = new MenuInflater(this);
        menuInflater.inflate(R.menu.menu_file,menu);
       return true;
        // return super.onCreateOptionsMenu(menu);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu_file,menu);

        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.Item_1:
                Toast.makeText(getApplicationContext(),"item1",Toast.LENGTH_LONG).show();
                return true;
            case R.id.item_2:
                Toast.makeText(this,"item2",Toast.LENGTH_LONG).show();
                return true;
            case R.id.Item_3:
                Toast.makeText(this,"item3",Toast.LENGTH_LONG).show();
                return true;
            case R.id.item_4:
                Toast.makeText(this,"item4",Toast.LENGTH_LONG).show();
                return true;
            default:
                Toast.makeText(this,"0000",Toast.LENGTH_LONG).show();
                return false;

        }
        //return super.onContextItemSelected(item);
    }

    @Override
    public boolean onOptionsItemSelected( MenuItem item) {
        switch (item.getItemId()){
            case R.id.Item_1:
                Toast.makeText(getApplicationContext(),"item1",Toast.LENGTH_LONG).show();
                return true;
            case R.id.item_2:
                Toast.makeText(this,"item2",Toast.LENGTH_LONG).show();
                return true;
            case R.id.Item_3:
                Toast.makeText(this,"item3",Toast.LENGTH_LONG).show();
                return true;
            case R.id.item_4:
                Toast.makeText(this,"item4",Toast.LENGTH_LONG).show();
                return true;
            default:
                Toast.makeText(this,"0000",Toast.LENGTH_LONG).show();
                return false;

        }


       // return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        return false;
    }
}