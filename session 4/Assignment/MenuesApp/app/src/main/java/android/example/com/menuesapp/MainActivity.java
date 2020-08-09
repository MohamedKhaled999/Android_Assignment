package android.example.com.menuesapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText firstNum, secondNum;
    TextView resulteFixed, resulteNum;
    Float floatFirst, floatSecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstNum = (EditText) findViewById(R.id.first_number);
        secondNum = (EditText) findViewById(R.id.Second_number);
        resulteFixed = (TextView) findViewById(R.id.result_fixed);
        resulteNum = (TextView) findViewById(R.id.result_number);
        registerForContextMenu(resulteFixed);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = new MenuInflater(this);
        menuInflater.inflate(R.menu.menu_file, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (isNOtInputEmpty()) {
            oprations(item);
            return true;
        }

        return false;
    }

    public Boolean isNOtInputEmpty() {
        String strFirst = firstNum.getText().toString();
        String strSecond = secondNum.getText().toString();
        if (!strFirst.isEmpty() && !strSecond.isEmpty()) {
            floatFirst = Float.parseFloat(strFirst);
            floatSecond = Float.parseFloat(strSecond);
//            firstNum.setText("");
//            secondNum.setText("");
            return true;
        } else {
            Toast.makeText(this, "please entre number in empty filed ", Toast.LENGTH_LONG).show();

            return false;
        }

    }

    public void oprations(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.division:
                resulteNum.setText(floatFirst / floatSecond + "");
                break;

            case R.id.multiplication:
                resulteNum.setText(floatFirst * floatSecond + "");
                break;
            case R.id.subtraction:
                resulteNum.setText(floatFirst - floatSecond + "");
                break;

            case R.id.addition:
                resulteNum.setText(floatFirst + floatSecond + "");


        }


    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu_file, menu);

        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (isNOtInputEmpty()) {
            oprations(item);
            return true;
        }

        return false;
    }
}
