package com.edu.ntou.smartcampus.Theme;


import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ArrowKeyMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.edu.ntou.smartcampus.R;
import com.edu.ntou.smartcampus.WorkoutPlan.AddStudentDialog;
import com.edu.ntou.smartcampus.WorkoutPlan.DBHandler;
import com.edu.ntou.smartcampus.WorkoutPlan.DeleteStudentDialog;
import com.edu.ntou.smartcampus.WorkoutPlan.UpdateStudentDialog;
import com.edu.ntou.smartcampus.WorkoutPlan.Student;


import java.util.List;


public class WorkoutPlanActivity extends AppCompatActivity implements AddStudentDialog.AddStudentDialogListener,
        UpdateStudentDialog.UpdateStudentDialogListener, DeleteStudentDialog.DeleteStudentDialogListener {
    Button btnAddStudent, btnUpdateInfo, btnDeleteInfo, btnShow;
    TextView tvStdInfo;
    private String TAG = "StudInfo";
    DBHandler db;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_plan);

        db = new DBHandler(this);
        tvStdInfo = (TextView) findViewById(R.id.tvStdList);
        btnAddStudent = (Button) findViewById(R.id.btnAppend);
        btnUpdateInfo = (Button) findViewById(R.id.btnEdit);
        btnDeleteInfo = (Button) findViewById(R.id.btnDelete);
        btnShow = (Button) findViewById(R.id.btnShow);

        btnAddStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddStudentDialog dialog = new AddStudentDialog();
                dialog.show(getFragmentManager(), TAG);
            }
        });

        btnUpdateInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UpdateStudentDialog updateDialog = new UpdateStudentDialog();
                updateDialog.show(getFragmentManager(), TAG);
            }
        });

        btnDeleteInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DeleteStudentDialog deleteDialog = new DeleteStudentDialog();
                deleteDialog.show(getFragmentManager(), TAG);
            }
        });

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tvStdInfo = (TextView) findViewById(R.id.tvStdList);
                tvStdInfo.setMovementMethod(ArrowKeyMovementMethod.getInstance());
                tvStdInfo.setText("");

                List<Student> studentsList = db.getAllStudentList();
                for (Student std : studentsList) {
                    String stdDetail = "ID:" + std.get_id() + "\n運動日期:" + std.get_student_id() + "\n運動項目:" + std.get_name() + "\n運動時間:" + std.get_phone_number();
                    tvStdInfo.append("\n" + stdDetail);
                }
            }
        });

    }

    @Override
    public void onSaveButtonClick(DialogFragment dialog) {

        EditText entStudentId = (EditText) dialog.getDialog().findViewById(R.id.edtStudentId);
        String studentId = entStudentId.getText().toString();

        int int_studentId = Integer.parseInt(entStudentId.getText().toString());

        EditText entName = (EditText) dialog.getDialog().findViewById(R.id.edtName);
        String name = entName.getText().toString();

        EditText entPhnNo = (EditText) dialog.getDialog().findViewById(R.id.edtPhoneNo);
        String phnNo = entPhnNo.getText().toString();

        if (int_studentId >= 0){
            db.addNewStudent(new Student(int_studentId, name, phnNo));
            Toast.makeText(getApplicationContext(), "項目已增加成功 ", Toast.LENGTH_LONG).show();
        }
        Toast.makeText(getApplicationContext(), "\n運動日期 :" + studentId + "\n運動項目: " + name + "\n運動時間:" + phnNo, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onUpdateButtonClick(DialogFragment dialog) {


        EditText entId = (EditText) dialog.getDialog().findViewById(R.id.edt_UpdateId);
        int int_idNo = Integer.parseInt(entId.getText().toString());

        EditText entStudentId = (EditText) dialog.getDialog().findViewById(R.id.edt_UpdateStudentId);
        int int_StudentId = Integer.parseInt(entStudentId.getText().toString());


        EditText entName = (EditText) dialog.getDialog().findViewById(R.id.edt_UpdateName);
        String name = entName.getText().toString();

        EditText entPhnNo = (EditText) dialog.getDialog().findViewById(R.id.edt_UpdatePhoneNo);
        String phnNo = entPhnNo.getText().toString();


        if (db.updateStudentInfo(int_idNo, int_StudentId, name, phnNo)) {
            db.updateStudentInfo(int_idNo, int_StudentId, name, phnNo);
            Toast.makeText(getApplicationContext(), "項目已增加成功 ", Toast.LENGTH_LONG).show();
        }

    }
    @Override
    public void onDeleteButtonClick(DialogFragment dialog) {

        EditText entId = (EditText) dialog.getDialog().findViewById(R.id.edt_deleteID);
        int int_idNo = Integer.parseInt(entId.getText().toString());


        if (db.deleteStudent(int_idNo)) {
            Toast.makeText(getApplicationContext(), "已刪除 ", Toast.LENGTH_LONG).show();

            db.deleteStudent(int_idNo);
        }

    }



}

