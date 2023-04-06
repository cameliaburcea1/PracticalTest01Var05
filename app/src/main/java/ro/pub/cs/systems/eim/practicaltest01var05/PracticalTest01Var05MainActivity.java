package ro.pub.cs.systems.eim.practicaltest01var05;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PracticalTest01Var05MainActivity extends AppCompatActivity {

    Button topLeft;
    Button topRight;
    Button bottomLeft;
    Button bottomRight;
    Button center;
    Button navigate;

    EditText editText;

    int clicks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var05_main);

        topLeft = findViewById(R.id.topleft);
        topRight = findViewById(R.id.topright);
        bottomLeft = findViewById(R.id.bottomleft);
        bottomRight = findViewById(R.id.bottomright);
        center = findViewById(R.id.center);
        editText = findViewById(R.id.edittext);
        navigate = findViewById(R.id.button_show);


        clicks = 0;

        topRight.setOnClickListener(view -> {
            if(editText.getText().toString().isEmpty()) {
                editText.setText("Top right");
            } else {
                editText.setText(editText.getText() + ", Top right");
            }

            clicks++;
        });


        topLeft.setOnClickListener(view -> {
            if(editText.getText().toString().isEmpty()) {
                editText.setText("Top left");
            } else {
                editText.setText(editText.getText() + ", Top left");
            }

            clicks++;
        });

        bottomRight.setOnClickListener(view -> {
            if(editText.getText().toString().isEmpty()) {
                editText.setText("Bottom right");
            } else {
                editText.setText(editText.getText() + ", Bottom right");
            }

            clicks++;
        });

        bottomLeft.setOnClickListener(view -> {
            if(editText.getText().toString().isEmpty()) {
                editText.setText("Bottom left");
            } else {
                editText.setText(editText.getText() + ", Bottom left");
            }

            clicks++;
        });

        center.setOnClickListener(view -> {
            if(editText.getText().toString().isEmpty()) {
                editText.setText("Center");
            } else {
                editText.setText(editText.getText() + ", Center");
            }

            clicks++;
        });

        navigate.setOnClickListener(view -> {
            Toast.makeText(this, String.valueOf(clicks), Toast.LENGTH_LONG).show();
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("CLICKS", String.valueOf(clicks));
        savedInstanceState.putString("TEXT", editText.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState.containsKey("CLICKS")) {
            clicks = Integer.parseInt(savedInstanceState.getString("CLICKS"));
        } else {
            clicks = 0;
        }


        Toast.makeText(this, "Total of clicks is: " + String.valueOf(clicks), Toast.LENGTH_LONG).show();

    }

}