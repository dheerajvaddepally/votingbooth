package com.example.votingbooth;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;


public class ConfirmationDialog extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle("Reset Votes")
                .setMessage("Are you sure want to reset votes")
                .setPositiveButton("Reset Votes", (dialog, which) -> {
                    ConfirmationCallBack confirmationCallBack = (ConfirmationCallBack) getActivity();
                    confirmationCallBack.clearVotes();
                    this.dismiss();

        }).setNegativeButton("Cancel", (dialog, which) -> dismiss());
        return builder.create();
    }
}
