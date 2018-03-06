package com.example.yan.gitunipe;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button calculaButton;
    private EditText pesoText;
    private EditText alturaText;
    private TextView imcText;
    private EditText nomeText;
    private String nome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculaButton = (Button) findViewById(R.id.calcButton);
        pesoText = (EditText) findViewById(R.id.pesoText);
        alturaText = (EditText) findViewById(R.id.alturaText);
        imcText = (TextView) findViewById(R.id.imcText);


        calculaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });
    }

    protected void showDialog(){
        LayoutInflater layoutInflater = LayoutInflater.from(MainActivity.this);
        View view = layoutInflater.inflate(R.layout.dialog, null);
        AlertDialog.Builder aBuilder = new AlertDialog.Builder(MainActivity.this);
        aBuilder.setView(view);

        nomeText = (EditText) view.findViewById(R.id.nomeText);

        aBuilder.setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                double peso = Double.parseDouble(pesoText.getText().toString());
                double altura = Double.parseDouble(alturaText.getText().toString());
                nome = nomeText.getText().toString();
                double imc = (peso)/(altura*altura);

                imcText.setText("Nome: "+ nome + " IMC: " + imc);
            }
        }).setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert = aBuilder.create();
        alert.show();
    }




}
