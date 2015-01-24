package com.example.jorge.pruebasdialog;

import android.app.Activity;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Jorge on 24/01/2015.
 */
public class Popup extends DialogFragment {

    private String mensaje=null;

    public Popup()
    {
        this.mensaje="Sin mensaje";
    }

    public Popup(String m)
    {
        this.mensaje=m;
    }

    /**
     * Creamos una interfaz para indicarle a la actividad que llamo a este dialogo sepa cuando
     * se dio clic en algun boton en especifico
     */
    public interface PopupListener {
        public void onClickAceptar(DialogFragment dialog);
        public void onClickCancelar(DialogFragment dialog);
    }
    PopupListener mListener;

    /**
     * En esta funcion editamos el mensaje que se mostrara en el popup, y tambien
     * cambiamos el layout con el cual se mostrara el popup
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //Indicamos cual sera el layout que se mostrara en el mensaje
        View view = inflater.inflate(R.layout.popup, container);

        //Editamos le mensaje que se mostrara
        TextView dialogo_txtMensaje = (TextView) view.findViewById(R.id.popup_txtMensaje);
        dialogo_txtMensaje.setText(mensaje);

        //Identificamos le boton aceptar y luego escuchamos el evento clic de ese boton
        Button btnAceptar=(Button) view.findViewById(R.id.popup_btnAceptar);
        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mListener.onClickAceptar(Popup.this);
            }
        });

        //Identificamo le boton cancelar y luego escuchamos el evento clic de ese boton
        Button btnCancelar=(Button) view.findViewById(R.id.popup_btnCancelar);
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onClickCancelar(Popup.this);
            }
        });

        return view;
    }
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        // Verify that the host activity implements the callback interface
        try {
            // Instantiate the NoticeDialogListener so we can send events to the host
            mListener = (PopupListener) activity;
        } catch (ClassCastException e) {
            // The activity doesn't implement the interface, throw exception
            throw new ClassCastException(activity.toString()
                    + " must implement NoticeDialogListener");
        }
    }
}
