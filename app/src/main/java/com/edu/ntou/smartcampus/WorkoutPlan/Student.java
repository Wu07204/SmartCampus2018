package com.edu.ntou.smartcampus.WorkoutPlan;


public class Student {
    int _id;
    int _student_id;
    String _name;
    String _phone_number;

    public Student() {
    }

    public Student(int _id, String _name, int _student_id, String _phone_number) {
        this._id = _id;
        this._name = _name;
        this._student_id = _student_id;
        this._phone_number = _phone_number;
    }

    public Student(int _student_id, String _name, String _phone_number) {
        this._student_id = _student_id;
        this._name = _name;
        this._phone_number = _phone_number;
    }




    public int get_id() {
        return _id;
    }

    public String get_name() {
        return _name;
    }

    public int get_student_id() {
        return _student_id;
    }

    public String get_phone_number() {
        return _phone_number;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void set_student_id(int _student_id) {
        this._student_id = _student_id;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public void set_phone_number(String _phone_number) {
        this._phone_number = _phone_number;
    }
}


