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



public class AddStudentDialog extends DialogFragment {
    public interface AddStudentDialogListener{

        void onSaveButtonClick(DialogFragment dialog);

    }

    AddStudentDialogListener addStudentListener;
    Context context;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            addStudentListener = (AddStudentDialogListener) context;
        } catch (Exception e) {
            Toast.makeText(getContext(), "錯誤", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {


        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();

        builder.setView(inflater.inflate(R.layout.add_student_dialog, null))

                .setPositiveButton("新增", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        addStudentListener.onSaveButtonClick(AddStudentDialog.this);
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        AddStudentDialog.this.getDialog().cancel();
                    }
                });
        return builder.create();
    }
}

