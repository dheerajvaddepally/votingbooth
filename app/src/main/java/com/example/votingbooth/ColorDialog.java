package com.example.votingbooth;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class ColorDialog extends DialogFragment {
    final CharSequence[] items = {"Red", "Yellow", "Blue", "White"};
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Choose a color").setItems(items, (dialog, which) -> {
            ColorCallBack colorCallBack = (ColorCallBack) getActivity();
            colorCallBack.changeBackgroundColor(which);
            this.dismiss();
        });
        return builder.create();
    }
}
