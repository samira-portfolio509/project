package Model;

public class SeatAllocation {
    int seat_no;
    String student_id;
    int exam_id;
    int room_no;
    public SeatAllocation(int sn,String si , int ei , int rn){
        seat_no = sn;
        student_id = si;
        exam_id = ei;
        room_no = rn;
    }
    public int getSeatno(){
        return seat_no;
    }
    public String getId(){
        return student_id;
    }
    public int getExamid(){
        return exam_id;
    }
    public int getroomNo(){
        return room_no;
    }
}
