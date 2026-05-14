package Model;

public class TeacherAllocation {
    private int teacher_id ;
    private int room_no ;
    private int exam_id ;
    public TeacherAllocation(int id , int rn , int ei){
        teacher_id = id;
        room_no = rn;
        exam_id = ei;
    }
    public int getTeacher_id(){
        return teacher_id;
    }
    public int getRoom_no(){
        return room_no;
    }
    public int getExam_id(){
        return exam_id;
    }
}
