package com.example.votingbooth;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;

import com.example.votingbooth.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements ColorCallBack, ConfirmationCallBack {
    private ActivityMainBinding mBinding;
    int bettyCounter = 0;
    int veronicaCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        initListeners();
    }

    private void initListeners() {
        mBinding.voteBetty.setOnClickListener(v -> {
            bettyCounter ++;
            mBinding.bettyCount.setText("has " + bettyCounter + " votes");
        });

        mBinding.voteVeronica.setOnClickListener(v -> {
            veronicaCounter ++;
            mBinding.veronicaCount.setText("has " + veronicaCounter + " votes");
        });

        mBinding.changeColor.setOnClickListener(v -> {
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            Fragment prev = getFragmentManager().findFragmentByTag("colordialog");
            if (prev != null) {
                ft.remove(prev);
            }
            ft.addToBackStack(null);
            DialogFragment dialogFragment = new ColorDialog();
            dialogFragment.show(ft, "colordialog");
        });

        mBinding.resetVotes.setOnClickListener(v -> {
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            Fragment prev = getFragmentManager().findFragmentByTag("confirmationdialog");
            if (prev != null) {
                ft.remove(prev);
            }
            ft.addToBackStack(null);
            DialogFragment dialogFragment = new ConfirmationDialog();
            dialogFragment.show(ft, "confirmationdialog");
        });
    }

    @Override
    public void changeBackgroundColor(int index) {
        switch (index) {
            case 0: mBinding.background.setBackgroundColor(getResources().getColor(R.color.red));
                break;
            case 1: mBinding.background.setBackgroundColor(getResources().getColor(R.color.yellow));
                break;
            case 2: mBinding.background.setBackgroundColor(getResources().getColor(R.color.blue));
                break;
            default: mBinding.background.setBackgroundColor(getResources().getColor(R.color.white));
        }
    }

    @Override
    public void clearVotes() {
        mBinding.bettyCount.setText(getString(R.string.has_0_votes));
        bettyCounter = 0;
        mBinding.veronicaCount.setText(getString(R.string.has_0_votes));
        veronicaCounter = 0;
    }
}
