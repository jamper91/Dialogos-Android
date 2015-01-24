package com.example.jorge.pruebasdialog;

import android.app.DialogFragment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class Inicio extends ActionBarActivity implements Popup.PopupListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        initGui();
    }



    public void initGui(){
        Button btnAbrirPopup= (Button) findViewById(R.id.btnAbrirVentana);

        btnAbrirPopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Aqui abrimos el popup
                Popup p= new Popup("Mensaje que se mostrara al usuario final");
                p.show(getFragmentManager(),"codigoUnico");
            }
        });

    }

    @Override
    public void onClickAceptar(DialogFragment dialog) {
        dialog.dismiss();

        Log.d("onClickAceptar","dio clic en aceptar");

    }

    @Override
    public void onClickCancelar(DialogFragment dialog) {
        dialog.dismiss();
        Log.d("onClickCancelar","Dio click en el boton cancelar");
    }
}
