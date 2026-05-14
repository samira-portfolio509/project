package Model;

public class Teacher {
    private int teacher_id;
    private String teacher_name,teacher_department;
    private String teacher_password;
    public Teacher(){}
    public Teacher (String tnm ,int tid , String tdp , String tpass){
        teacher_id = tid;
        teacher_name = tnm;
        teacher_department = tdp;
        teacher_password = tpass;
    }
    public int gettID(){
        return teacher_id;
    }
    public String gettName(){
        return teacher_name;
    }
    public String gettdept(){
        return teacher_department;
    }
    public String gettpass(){
        return teacher_password;
    }
    public void settID(int id){
        teacher_id = id;
    }
    public void settName(String name){
        teacher_name = name;
    }
    public void settDept(String dept){
        teacher_department = dept;
    }
}
