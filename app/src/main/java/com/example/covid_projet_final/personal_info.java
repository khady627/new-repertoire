package com.example.covid_projet_final;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class personal_info extends menu {

    private static final int MODE_CREATE = 1;
    private static final int MODE_EDIT = 2;

    private EditText txt_prenom;
    private EditText txt_nom;
    //private TextView txt_adresse;
    private EditText txt_email;
    private EditText txt_telephone;
    private Button save;
    private TextView location;
    private Button buttonSave;
    //private Button buttonCancel;

    private Note note;
    private boolean needRefresh;
    private int mode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_info);

        this.txt_prenom = (EditText) findViewById(R.id.txt_prenom);
        this.txt_nom = (EditText) findViewById(R.id.txt_nom);
        this.location = (TextView) findViewById(R.id.btn_location);
        this.txt_email = (EditText) findViewById(R.id.txt_email);
        this.txt_telephone = (EditText) findViewById(R.id.txt_telephone);


        this.buttonSave = (Button)findViewById(R.id.btn_save);
        //this.buttonCancel = (Button)findViewById(R.id.button_cancel);

        this.buttonSave.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)  {
                buttonSaveClicked();
            }
        });
        /*location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), testLocalisation.class);
                startActivity(i);

            }
        });*/

        /*this.buttonCancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)  {
                buttonCancelClicked();
            }
        });*/

        Intent intent = this.getIntent();
        this.note = (Note) intent.getSerializableExtra("note");
        if(note== null)  {
            this.mode = MODE_CREATE;
        } else  {
            this.mode = MODE_EDIT;
            this.txt_prenom.setText(note.getPrenom());
            this.txt_nom.setText(note.getNom());
            this.location.setText(note.getAdresse());
            this.txt_email.setText(note.getEmail());
            this.txt_telephone.setText(note.getTelephone());
        }
    }

    // Utilisateur Cliquez sur le bouton Enregistrer.
    public void buttonSaveClicked()  {
        MyDatabaseHelper db = new MyDatabaseHelper(this);

        Intent i = new Intent(getApplicationContext(), Questionnaire.class);


        String prenom = this.txt_prenom.getText().toString();
        String nom = this.txt_nom.getText().toString();
        String adresse = this.location.getText().toString();

        String email = this.txt_email.getText().toString();
        String telephone = this.txt_telephone.getText().toString();

        /*if(title.equals("") || content.equals("")) {
            Toast.makeText(getApplicationContext(),
                    "Veuillez saisir le titre et le contenu", Toast.LENGTH_LONG).show();
            return;
        }*/

        if(mode == MODE_CREATE ) {
            this.note= new Note(prenom,nom,adresse,email,telephone);
            db.addNote(note);
        }
        startActivity(i);

        /*else  {
            this.note.setPrenom(prenom);
            this.note.setNom(nom);
            this.note.setAdresse(adresse);
            this.note.setEmail(email);
            this.note.setTelephone(telephone);
            db.updateNote(note);
        }*/

       this.needRefresh = true;

        // Retour à MainActivity.
        this.onBackPressed();
    }

    // Utilisateur Cliquez sur le bouton Annuler.
    /*public void buttonCancelClicked()  {
        // Ne rien faire, retour MainActivity.
        this.onBackPressed();
    }*/

    // Une fois cette activité terminée,
    // Envoyez des commentaires à l'activité appelée.
    /* @Override
   public void finish() {

        // Créer une intention
        Intent data = new Intent();

        // Demandez à MainActivity d'actualiser sa ListView (ou non).
        data.putExtra("needRefresh", needRefresh);

        // Set Result
        this.setResult(Activity.RESULT_OK, data);
        super.finish();
    }*/

}

/*
public class personal_info extends AppCompatActivity  {
    private EditText txt_prenom;
    private EditText txt_nom;
    //private TextView txt_adresse;
    private EditText txt_email;
    private EditText txt_telephone;
    private Button save;
    private TextView location;
    String prenom, nom, adresse, email,telephone;

    public String getPrenom() {
        return prenom;
    }

    public String getNom() {
        return nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephone() {
        return telephone;
    }

    public personal_info() {
        this.prenom = prenom;
        this.nom = nom;
        this.adresse = adresse;
        this.email = email;
        this.telephone = telephone;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_info);


        location = (TextView) findViewById(R.id.btn_location);
        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i  = new Intent(getApplicationContext(), testLocalisation.class);
                startActivity(i);
            }
        });

        LocationManager locationManager = null;
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        this.txt_prenom = (EditText) findViewById(R.id.txt_prenom);
        this.txt_nom = (EditText) findViewById(R.id.txt_nom);
        //this.txt_adresse = (TextView) findViewById(R.id.btn_location);
        this.txt_email = (EditText) findViewById(R.id.txt_email);
        this.txt_telephone = (EditText) findViewById(R.id.txt_telephone);

        prenom = this.txt_prenom.getText().toString();
        nom = this.txt_nom.getText().toString();
        adresse = this.location.getText().toString();

        email = this.txt_email.getText().toString();
        telephone = this.txt_telephone.getText().toString();

        save = (Button) findViewById(R.id.btn_save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent other = new Intent(getApplicationContext(), Questionnaire.class);
                */
/*Mydb mydb = new Mydb(personal_info.this);
                personal_info p1 = new personal_info();
                mydb.addNote(p1);*//*

                startActivity(other);

            }
        });
      */
/*  latitude = (TextView) findViewById(R.id.textViewLatitude);
        longitude = (TextView) findViewById(R.id.textViewLongitude);*//*


    }
}

*/
