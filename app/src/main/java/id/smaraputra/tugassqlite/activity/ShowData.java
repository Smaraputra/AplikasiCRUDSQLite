package id.smaraputra.tugassqlite.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import id.smaraputra.tugassqlite.DBHandler;
import id.smaraputra.tugassqlite.R;
import id.smaraputra.tugassqlite.adapter.MahasiswaAdapter;
import id.smaraputra.tugassqlite.model.MahasiswaModel;

public class ShowData extends AppCompatActivity {

    private DBHandler dbHandler;
    private ArrayList<MahasiswaModel> user=new ArrayList<>();

    private MahasiswaAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);

        RecyclerView userView = (RecyclerView) findViewById(R.id.recylerMahasiswa);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        userView.setLayoutManager(linearLayoutManager);
        userView.setHasFixedSize(true);

        dbHandler = new DBHandler(ShowData.this);
        user = dbHandler.listMahasiswa();

        mAdapter = new MahasiswaAdapter(ShowData.this, user);
        userView.setAdapter(mAdapter);
    }
}