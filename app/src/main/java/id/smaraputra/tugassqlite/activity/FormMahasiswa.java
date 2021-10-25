package id.smaraputra.tugassqlite.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import id.smaraputra.tugassqlite.DBHandler;
import id.smaraputra.tugassqlite.R;

public class FormMahasiswa extends AppCompatActivity {

    String nama_in, nim_in;
    EditText nama, nim;
    Button cancel, save;
    DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        dbHandler = new DBHandler(FormMahasiswa.this);
        nama = (EditText) findViewById(R.id.inputnama);
        nim = (EditText) findViewById(R.id.inputnim);
        cancel = (Button) findViewById(R.id.tombolbatalbatal);
        save = (Button) findViewById(R.id.tombolkirimkirim);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FormMahasiswa.this, MainMenu.class);
                startActivity(intent);
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nama_in = nama.getText().toString();
                nim_in = nim.getText().toString();
                dbHandler.tambahMahasiswa(nama_in, nim_in);
                Intent intent = new Intent(FormMahasiswa.this,
                        MainMenu.class);
                startActivity(intent);
            }
        });
    }
}