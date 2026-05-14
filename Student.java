package Model;
public class Student {
    private String student_name;
    private String student_department,semester;
    private String student_id,spass;
    public Student(){}
    public Student (String snm,String sid,String sdp , String ssm , String pass){
        student_name = snm;
        student_id = sid;
        student_department = sdp;
        semester = ssm;
        spass = pass;
    }
    public String getName(){
        return student_name;
    }
    public String getId(){
        return student_id;
    }
    public String getDept(){
        return student_department;
    }
    public String getSemester(){
        return semester;
    }
    public String getPass(){
        return spass;
    }

    public void setName(String name){
         student_name = name;
    }
    public void setId(String id){
         student_id = id;
    }
    public void setDept(String dept){
         student_department = dept;
    }
    public void setSemester(String sem){
         semester = sem;
    }

}
