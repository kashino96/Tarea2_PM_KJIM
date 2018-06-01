package facci.pm.ta2.poo.pra1;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import facci.pm.ta2.poo.datalevel.DataException;
import facci.pm.ta2.poo.datalevel.DataObject;
import facci.pm.ta2.poo.datalevel.DataQuery;
import facci.pm.ta2.poo.datalevel.GetCallback;



public class DetailActivity extends AppCompatActivity{

    TextView precio;
    ImageView imagen;
    TextView descripcion1;
    TextView Nombre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("PR1 :: Detail");

        // INICIO - CODE6
        //Pregunta 3.1.
        // Accediendo al object_id recibido como parámetro en la actividad
        //Nombre
        Nombre = findViewById(R.id.nom);
        String c = getIntent().getExtras().getString("id2");
        Nombre.setText(c);
        //Imagen
        imagen = findViewById(R.id.thumbnail);
        Intent intent = getIntent();
        Bitmap bitmap = intent.getParcelableExtra("img");
        imagen.setImageBitmap(bitmap);
        //Descripcion
        descripcion1 = findViewById(R.id.des);
        String b = getIntent().getExtras().getString("id1");
        descripcion1.setText(b);
        // Precio.
        precio = findViewById(R.id.pre);
        String a = getIntent().getExtras().getString("id");
        precio.setText(a);
        // FIN - CODE6
    }

}
