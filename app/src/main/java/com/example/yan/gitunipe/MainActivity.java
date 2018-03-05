package com.example.yan.gitunipe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button calculaButton;
    private EditText pesoText;
    private EditText alturaText;
    private TextView imcText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculaButton =(Button) findViewById(R.id.calcButton);
        pesoText =(EditText) findViewById(R.id.pesoText);
        alturaText =(EditText) findViewById(R.id.alturaText);
        imcText =(TextView) findViewById(R.id.imcText);

        calculaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double peso = Double.parseDouble(String.valueOf(pesoText.getText()));
                double altura = Double.parseDouble(String.valueOf(alturaText.getText()));
                double imc = peso/(altura*altura);

                imcText.setText(String.valueOf(imc));
            }
        });
    }




}
