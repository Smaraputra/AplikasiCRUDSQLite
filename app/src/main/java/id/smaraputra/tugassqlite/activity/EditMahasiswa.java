package id.smaraputra.tugassqlite.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import id.smaraputra.tugassqlite.DBHandler;
import id.smaraputra.tugassqlite.R;
import id.smaraputra.tugassqlite.model.MahasiswaModel;

public class EditMahasiswa extends AppCompatActivity {

    EditText nameedit, nimedit;
    Button canceled, saveed;

    private DBHandler dbHandler;
    private ArrayList<MahasiswaModel> mahasiswaData=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_mahasiswa);

        nameedit = (EditText) findViewById(R.id.namaEdit);
        nimedit = (EditText) findViewById(R.id.nimEdit);

        canceled = findViewById(R.id.tombolbataled);
        saveed = findViewById(R.id.tombolkirimed);

        Intent intent = getIntent();
        int iduser = intent.getIntExtra("idu", 1);

        dbHandler = new DBHandler(getApplicationContext());
        mahasiswaData = dbHandler.listMahasiswaOne(iduser);

        nameedit.setText(mahasiswaData.get(0).getName());
        nimedit.setText(mahasiswaData.get(0).getNim());

        canceled.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EditMahasiswa.this, ShowData.class);
                startActivity(intent);
            }
        });

        saveed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String namabaru = nameedit.getText().toString();
                String nimbaru = nimedit.getText().toString();
                dbHandler.updateMahasiswa(iduser, namabaru, nimbaru);
                Intent intent = new Intent(EditMahasiswa.this,
                        ShowData.class);
                startActivity(intent);
            }
        });
    }
}