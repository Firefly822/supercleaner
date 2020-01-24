package com.zz.supercleaner.ui.common;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

import com.zz.supercleaner.R;
import com.zz.supercleaner.ui.RefreshView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProgressDialog extends DialogFragment {

    @BindView(R.id.refreshview)
    RefreshView refreshView;

    public static ProgressDialog show(FragmentManager manager) {
        ProgressDialog dialog = new ProgressDialog();
        dialog.show(manager, "pp");
        return dialog;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.view_loading_progress, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        refreshView.refreshing();
    }

    @Override
    public void show(FragmentManager manager, String tag) {
        super.show(manager, tag);
    }

    @Override
    public void dismiss() {
        super.dismiss();
        refreshView.complete();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
