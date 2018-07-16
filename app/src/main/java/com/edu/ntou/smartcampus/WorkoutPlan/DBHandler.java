package com.edu.ntou.smartcampus.WorkoutPlan;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;


public class DBHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "student";

    private static final String TABLE_STUDENT_DETAIL = "studentDetails";

    private static final String KEY_ID = "id";
    private static final String KEY_運動日期 = "student_id";
    private static final String KEY_運動項目 = "name";
    private static final String KEY_PHONE_NO = "phone_number";

    public DBHandler(Context contex) {
        super(contex, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_STUDENT_DETAIL_TABLE = "CREATE TABLE " + TABLE_STUDENT_DETAIL + "("
                + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_運動日期 + " TEXT,"
                + KEY_運動項目 + " TEXT,"
                + KEY_PHONE_NO + " TEXT " + ")";

        db.execSQL(CREATE_STUDENT_DETAIL_TABLE);

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_STUDENT_DETAIL);

        onCreate(db);
    }


    public long addNewStudent(Student newStud) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(KEY_運動日期, newStud.get_student_id());
        values.put(KEY_運動項目, newStud.get_name());
        values.put(KEY_PHONE_NO, newStud.get_phone_number());


        return db.insert(TABLE_STUDENT_DETAIL, null, values);

    }


    public boolean updateStudentInfo(int updId, int updStudentId, String updName, String updPhoneNo) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues args = new ContentValues();

        args.put(KEY_運動日期, updStudentId);
        args.put(KEY_運動項目, updName);
        args.put(KEY_PHONE_NO, updPhoneNo);

        return db.update(TABLE_STUDENT_DETAIL, args, KEY_ID + "=" + updId, null) > 0;
    }


    public boolean deleteStudent(int delID) {

        SQLiteDatabase db = this.getWritableDatabase();

        return db.delete(TABLE_STUDENT_DETAIL, KEY_ID + "=" + delID, null) > 0;

    }


    public List<Student> getAllStudentList() {


        List<Student> studentList = new ArrayList<Student>();

        String selectQuery = "SELECT  * FROM " + TABLE_STUDENT_DETAIL;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {

                Student stdnt = new Student();
                stdnt.set_id(Integer.parseInt(cursor.getString(0)));
                stdnt.set_student_id(Integer.parseInt(cursor.getString(1)));
                stdnt.set_name(cursor.getString(2));
                stdnt.set_phone_number(cursor.getString(3));

                studentList.add(stdnt);

            } while (cursor.moveToNext());
        }

        return studentList;
    }

    public Student get(long id) {
        SQLiteDatabase db = this.getWritableDatabase();
        // 準備回傳結果用的物件
        Student item = null;
        // 使用編號為查詢條件
        String where = KEY_ID + "=" + id;
        // 執行查詢
        Cursor result = db.query(
                TABLE_STUDENT_DETAIL, null, where, null, null, null, null, null);

        // 如果有查詢結果
        if (result.moveToFirst()) {
            // 讀取包裝一筆資料的物件
            item = getRecord(result);
        }

        // 關閉Cursor物件
        result.close();
        // 回傳結果
        return item;
    }

    // 把Cursor目前的資料包裝為物件
    public Student getRecord(Cursor cursor) {
        // 準備回傳結果用的物件
        Student result = new Student();

        result.set_id(cursor.getInt(0));
        result.set_student_id(cursor.getInt(1));
        result.set_name(cursor.getString(cursor.getShort(2)));
        result.set_phone_number(cursor.getString(3));

        // 回傳結果
        return result;
    }


}


