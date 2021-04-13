package com.example.formactivity2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnSimpan,btnHapus;
    EditText etNama, etNim, etHP, etEmail;
    RadioButton rbPria, rbWanita;
    CheckBox amcc, himsi, koma;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //inisiasi
        btnSimpan = (Button) findViewById(R.id.btnSimpan);
        etNama = (EditText) findViewById(R.id.etNama);
        etNim = (EditText) findViewById(R.id.etNim);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etHP = (EditText) findViewById(R.id.etHP);
        rbPria = (RadioButton) findViewById(R.id.rbPria);
        rbWanita = (RadioButton) findViewById(R.id.rbWanita);
        spinner = (Spinner) findViewById(R.id.spinner);
        amcc = (CheckBox) findViewById(R.id.amcc);
        himsi = (CheckBox) findViewById(R.id.himsi);
        koma = (CheckBox) findViewById(R.id.koma);

        btnSimpan.setOnClickListener((View.OnClickListener) v -> {

            //Action Inputan
            String inputnama = String.valueOf(etNama.getText().toString());
            String inputnim = String.valueOf(etNim.getText().toString());
            String inputemail = String.valueOf(etEmail.getText().toString());
            String inputhp = String.valueOf(etHP.getText().toString());
            String inputprodi = String.valueOf(spinner.getSelectedItem().toString());
            String jk;
            if (rbPria.isChecked()) {
                jk = "Pria";
            } else {
                jk = "Wanita";
            }
            String UKM = "";
            if (amcc.isChecked()) {
                UKM += "AMCC \n";
            }
            if (himsi.isChecked()) {
                UKM += "HIMSI \n";
            }
            if (koma.isChecked()) {
                UKM += "KOMA";
            }
            //Proses pengiriman data ke FormActivity -> disesuaikan sama nama java kalian masing-masing
            Intent myIntent = new Intent(MainActivity.this, FormActivity.class);
            Bundle paket = new Bundle();
            paket.putString("nama", inputnama);
            paket.putString("nim", inputnim);
            paket.putString("email", inputemail);
            paket.putString("hp", inputhp);
            paket.putString("prodi", inputprodi);
            paket.putString("jenkel", jk);
            paket.putString("UKM", UKM);
            myIntent.putExtras(paket);
            startActivity(myIntent);

        });

        btnHapus = findViewById(R.id.btnHapus);
        btnHapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
                //title
                alertDialogBuilder.setTitle("Peringatan !! ");
                // message
                alertDialogBuilder.setMessage("Apakah Anda yakin Untuk Menghapus Data?")
                        .setIcon(R.mipmap.ic_launcher)
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getApplicationContext(), "Data Terhapus", Toast.LENGTH_SHORT).show();
                            }
                        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                //Create Dialog
                AlertDialog alertDialog = alertDialogBuilder.create();
                //show Dialog
                alertDialog.show();
            }
        });
    }
}