package facci.pm.ta2.poo.pra1;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import facci.pm.ta2.poo.datalevel.DataException;
import facci.pm.ta2.poo.datalevel.DataObject;
import facci.pm.ta2.poo.datalevel.DataQuery;
import facci.pm.ta2.poo.datalevel.FindCallback;
import facci.pm.ta2.poo.datalevel.GetCallback;

import java.util.ArrayList;

public class ResultsActivity extends AppCompatActivity implements  ListView.OnItemClickListener{

    private View mProgressView;
    private ListView mListView;
    public ResultListAdapter m_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        String user_email = getIntent().getStringExtra("user_email");

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("PR1 :: Results");

        mListView = (ListView) findViewById(R.id.listView);
        mProgressView = findViewById(R.id.progress);
        mListView.setOnItemClickListener(this);

        showProgress(true);

        // ************************************************************************
        // INICIO - CODE3
        DataQuery query = DataQuery.get("item");
        query.findInBackground("", "", DataQuery.OPERATOR_ALL, new FindCallback<DataObject>() {
            @Override
            public void done(ArrayList<DataObject> dataObjects, DataException e) {
                if (e == null) {
                    if (dataObjects.size() != 0) {
                        m_adapter = new ResultListAdapter(ResultsActivity.this, null);

                        m_adapter.m_array = dataObjects;
                        m_adapter.mActivity = ResultsActivity.this;

                        showProgress(false);
                        mListView.setAdapter(m_adapter);
                    }
                } else {
                    // Error
                }
            }
        });
        // FIN - CODE3
        // ************************************************************************


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {

        // INICIO - CODE5
        // EJERCICIO 2 PREGUNTA 2.2
        //Creando una instancia de la activity aqui ya hemos agregados los detalles
        // al pasar a la otra actividad como el nombre, descripcion, precio y ademas de la imagen
        DataObject object = (DataObject) m_adapter.m_array.get(position);
        Intent data= new Intent(getApplicationContext(), DetailActivity.class);
        data.putExtra ("id", object.get("price").toString());
        data.putExtra ("id1", object.get("description").toString());
        data.putExtra ("id2", object.get("name").toString());
        data.putExtra("img", (Bitmap) object.get("image"));
        startActivity(data);
        }
    //  FIN - CODE5
    private void showProgress(final boolean show) {
        mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
        mListView.setVisibility(show ? View.GONE : View.VISIBLE);
    }
}
