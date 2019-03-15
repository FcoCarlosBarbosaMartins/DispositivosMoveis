package com.example.alunoti.myimc;

package estacio.br.aula05;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.view.MenuItem;


public class MainActivity extends Activity implements View.OnClickListener {
    private EditText edtPeso;
    private EditText edtAltura;
    private EditText edtResultado;
    private Button btnCalcular;
    private Button btnLimpar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //REFERENCIAR OS CONTROLES
        edtPeso = (EditText)findViewById(R.id.edtPeso);
        edtAltura = (EditText)findViewById(R.id.edtAltura);
        edtResultado = (EditText)findViewById(R.id.edtResultado);
        btnCalcular = (Button)findViewById(R.id.btnCalcular);
        btnLimpar = (Button)findViewById(R.id.btnLimpar);
        //ASSOCIAR TRATADOR DE EVENTOS
        btnCalcular.setOnClickListener(this);
        btnLimpar.setOnClickListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.btnCalcular) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    // TRATATOR DE EVENTOS
    @Override
    public void onClick(View v) {
            if ( v.getId() == R.id.btnCalcular){
                double peso = Double.parseDouble(edtPeso.getText().toString());
                double altura = Double.parseDouble(edtAltura.getText().toString());
                double resultado = (peso/Math.pow(altura,2));
                edtResultado.setText(String.format("%.2f",resultado));
            }else if ( v.getId() == R.id.btnLimpar){
                edtPeso.setText("");
                edtAltura.setText("");
                edtResultado.setText("");
                edtPeso.requestFocus();
            }
        }
    }
