package com.expiate.kaizasks.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

import com.expiate.kaizasks.R;

public class LoadOrPlayDialog extends DialogFragment {

    private LoadOrPlayDialogInterface listener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = requireActivity().getLayoutInflater();

        builder.setView(inflater.inflate(R.layout.load_or_play_dialog, null))
                .setPositiveButton(R.string.new_game, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Start New Game
                        listener.getChoice(1);
                    }
                })
                .setNegativeButton(R.string.load, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Load Last Game
                    }
                });
        return builder.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try{
            listener = (LoadOrPlayDialogInterface) context;
        } catch (Error e) {
            Log.i("Message", "Must implement the interface");
        }
    }

    public interface LoadOrPlayDialogInterface {
        void getChoice(int r);
    }
}


