package com.example.covid_projet_final;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends menu {
    private ListView listView;
    private static final int MENU_ITEM_VIEW = 111;
    private static final int MENU_ITEM_EDIT = 222;
    private static final int MENU_ITEM_CREATE = 333;
    private static final int MENU_ITEM_DELETE = 444;

    private static final int MY_REQUEST_CODE = 1000;

    private final List<Note> noteList = new ArrayList<Note>();
    private ArrayAdapter<Note> listViewAdapter;

    private Button presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = (Button) findViewById(R.id.btn_se_presenter);

        presenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), presentation.class);
                startActivity(intent);
            }
        });

    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_de_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.itm_apropos:
                Toast.makeText(this, "a propos selected", Toast.LENGTH_LONG).show();
                Intent i = new Intent(getApplicationContext(), A_propos.class);
                startActivity(i);
                return true;
            case R.id.itm_contact:
                Toast.makeText(this, "contact selected", Toast.LENGTH_LONG).show();
                Intent in= new Intent(getApplicationContext(), Contact.class);
                startActivity(in);
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }*/

}