package edu.uph.m23si1.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class KalkulatorSederhana extends AppCompatActivity implements View.OnClickListener {

    Button buttonTambah, buttonKali, buttonBagi;
    EditText editText1, editText2;
    TextView textView;
    int num1, num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_kalkulator_sederhana);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        buttonTambah = findViewById(R.id.btn_tambah);
        buttonKali = findViewById(R.id.btn_kali);
        buttonBagi = findViewById(R.id.btn_bagi);
        editText1 = findViewById(R.id.number1);
        editText2 = findViewById(R.id.number2);
        textView = findViewById(R.id.hasil);

        buttonTambah.setOnClickListener(this);
        buttonKali.setOnClickListener(this);
        buttonBagi.setOnClickListener(this);

    }

    public int getIntFromEditText(EditText editText){
        if (editText.getText().toString().equals("")){
            Toast.makeText(this, "Enter Number", Toast.LENGTH_SHORT).show();
            return 0;
        } else
            return Integer.parseInt(editText.getText().toString());
    }

    @Override
    public void onClick(View view) {
        num1 = getIntFromEditText(editText1);
        num2 = getIntFromEditText(editText2);
        if (view.getId() == R.id.btn_tambah) {
            textView.setText(String.valueOf(num1 + num2));
        } else if (view.getId() == R.id.btn_kali) {
            textView.setText(String.valueOf(num1 * num2));
        } else if (view.getId() == R.id.btn_bagi) {
            if (num2 == 0) {
                textView.setText("Cannot divide by zero");
            } else {
                textView.setText(String.valueOf((float) num1 / num2));
            }
        }
    }
}