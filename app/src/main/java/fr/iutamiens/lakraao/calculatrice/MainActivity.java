package fr.iutamiens.lakraao.calculatrice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView num_1;
    private TextView num_2;

    private Button bt_plus;
    private Button bt_moins;
    private Button bt_div;
    private Button bt_fois;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Bouton
        bt_plus = findViewById(R.id.bt_plus);
        bt_moins = findViewById(R.id.bt_moins);
        bt_div = findViewById(R.id.bt_div);
        bt_fois = findViewById(R.id.bt_fois);

        num_1 = findViewById(R.id.txt_1);
        num_2 = findViewById(R.id.txt_2);

        //Addition
        bt_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Double res = 0.0;
                    res = Double.parseDouble(num_1.getText().toString()) + Double.parseDouble(num_2.getText().toString());
                    resultat(res.toString(), "+");
                    Log.d("TAG", "Addition");
                }catch (Exception e){
                    resultat("impossible", "+");
                    Log.d("TAG", "Erreur");
                }
            }
        });

        //Soustraction
        bt_moins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Double res = 0.0;
                    res = Double.parseDouble(num_1.getText().toString()) - Double.parseDouble(num_2.getText().toString());
                    resultat(res.toString(), "-");
                    Log.d("TAG", "Soustraction");
                }catch (Exception e){
                    resultat("impossible", "-");
                    Log.d("TAG", "Erreur");
                }

            }
        });

        //Division
        bt_div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Double res = 0.0;
                    res = Double.parseDouble(num_1.getText().toString()) / Double.parseDouble(num_2.getText().toString());
                    resultat(res.toString(), "/");
                    Log.d("TAG", "Division");
                }catch (Exception e){
                    resultat("impossible", "/");
                    Log.d("TAG", "Erreur");
                }
            }
        });

        //Multiplication
        bt_fois.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Double res = 0.0;
                    res = Double.parseDouble(num_1.getText().toString()) * Double.parseDouble(num_2.getText().toString());
                    resultat(res.toString(), "*");
                    Log.d("TAG", "Multiplication");
                }catch (Exception e){
                    resultat("impossible", "*");
                    Log.d("TAG", "Erreur");
                }
            }
        });
    }

    private void resultat(String resultat, String operateur){
        ArrayList<String> donnees = new ArrayList<String>();
        donnees.add(num_1.getText().toString());
        donnees.add(num_2.getText().toString());
        donnees.add(operateur);
        donnees.add(resultat);
        Intent intent = new Intent(this, ResultatActivity.class);
        intent.putExtra("array_list", donnees);
        startActivity(intent);
    }
}
