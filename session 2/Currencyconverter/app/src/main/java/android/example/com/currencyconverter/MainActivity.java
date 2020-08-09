package android.example.com.currencyconverter;

import android.example.com.currencyconverter.R;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button convert = (Button) findViewById(R.id.button);
        Button clear = (Button) findViewById(R.id.button2);
        final EditText dollar = (EditText) findViewById(R.id.editTextNumberDecimal);
        final EditText EGY = (EditText) findViewById(R.id.editTextNumberDecimal2);
        clear.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                dollar.setText("");
                EGY.setText("");
            }


        });
        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dollarStr = dollar.getText().toString();
                String EGYStr = EGY.getText().toString();

                if (dollarStr.isEmpty() && EGYStr.isEmpty()) {
                    Toast.makeText(getApplicationContext() ,"Invalid data – try again", Toast.LENGTH_SHORT).show();
                } else if (dollarStr.isEmpty()) {
                    float setEGY =Float.parseFloat(EGYStr);
                    dollar.setText((setEGY/18)+"");}
                        else{
                    float setDollar =Float.parseFloat(dollarStr);
                        EGY.setText(""+(setDollar*18));}

                }


        });
    }
    //convert.setOnClickListener(new View.OnClickListener)

}