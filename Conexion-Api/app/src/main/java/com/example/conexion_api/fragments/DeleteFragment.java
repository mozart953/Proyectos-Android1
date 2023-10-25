package com.example.conexion_api.fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;

import androidx.fragment.app.DialogFragment;

import com.example.conexion_api.interfaces.DeleteInterface;

public class DeleteFragment extends DialogFragment {
    private String mensaje;
    private int id;
    private DeleteInterface deleteInterface;

    public DeleteFragment(String mensaje, int id, DeleteInterface deleteInterface) {
        this.mensaje = mensaje;
        this.id = id;
        this.deleteInterface = deleteInterface;
    }

  
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(mensaje+id+"?")
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        deleteInterface.delete(id);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Log.i("Action","cancel");
                    }
                });
        return builder.create();
    }
}
