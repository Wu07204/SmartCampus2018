package com.edu.ntou.smartcampus.WorkoutPlan;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.Toast;

import com.edu.ntou.smartcampus.R;

public class UpdateStudentDialog extends DialogFragment {
    public interface UpdateStudentDialogListener{

        void onUpdateButtonClick(DialogFragment dialog);
        //void onCancelButtonClick(DialogFragment dialog);

    }

    UpdateStudentDialogListener updateStudentListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            updateStudentListener = (UpdateStudentDialogListener) context;
        } catch (Exception e) {
            Toast.makeText(getContext(), "錯誤", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();

        builder.setView(inflater.inflate(R.layout.update_student_dialog, null))

                // Add action buttons
                .setPositiveButton("修改", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        updateStudentListener.onUpdateButtonClick(UpdateStudentDialog.this);
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        UpdateStudentDialog.this.getDialog().cancel();
                    }
                });
        return builder.create();

    }
}

