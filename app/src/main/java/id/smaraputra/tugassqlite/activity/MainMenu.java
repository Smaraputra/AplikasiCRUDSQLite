package id.smaraputra.tugassqlite.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import id.smaraputra.tugassqlite.R;

public class MainMenu extends AppCompatActivity {

    Button lihatdata, tambahdata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        lihatdata = findViewById(R.id.seeData);
        lihatdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainMenu.this, ShowData.class);
                startActivity(intent);
            }
        });

        tambahdata = findViewById(R.id.addData);
        tambahdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainMenu.this, FormMahasiswa.class);
                startActivity(intent);
            }
        });
    }
}