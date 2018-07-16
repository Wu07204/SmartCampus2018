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




public class DeleteStudentDialog extends DialogFragment {
    public interface DeleteStudentDialogListener{

        void onDeleteButtonClick(DialogFragment dialog);

    }

    DeleteStudentDialogListener deleteStudentListener;
    Context context;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            deleteStudentListener = (DeleteStudentDialogListener) context;
        } catch (Exception e) {

            Toast.makeText(getContext(), "錯誤", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();

        builder.setView(inflater.inflate(R.layout.delete_student_dialog, null))

                .setPositiveButton("刪除", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        deleteStudentListener.onDeleteButtonClick(DeleteStudentDialog.this);
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        DeleteStudentDialog.this.getDialog().cancel();
                    }
                });
        return builder.create();

    }
}


