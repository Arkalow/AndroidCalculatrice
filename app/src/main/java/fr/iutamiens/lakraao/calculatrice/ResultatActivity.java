package fr.iutamiens.lakraao.calculatrice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;

public class ResultatActivity extends AppCompatActivity {

    private TextView text;
    private String msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultat);

        text= findViewById(R.id.textView);

        Bundle b = getIntent().getExtras();
        if (null != b) {
            ArrayList<String> donnees = b.getStringArrayList("array_list");
            msg = donnees.get(0) + " " + donnees.get(2) + " " + donnees.get(1) + " = " + donnees.get(3);
            text.setText(msg);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.share){
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, msg);
            sendIntent.setType("text/plain");
            startActivity(sendIntent);
        }
        return super.onOptionsItemSelected(item);
    }
}
