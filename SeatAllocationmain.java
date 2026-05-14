package Controller;
import Dao.*;
import Model.*;
import java . util.*;
import java.util.Collections;
import java.util.List;
public class SeatAllocationmain {
    StudentDao s1 = new StudentDao();
    List<Student> students = s1.getStudent();
    TeacherDao t1 = new TeacherDao();
    List<Teacher>teachers = t1.getTeacher();
    public int allocationLogic() {
        seatAllocationDao saDao = new seatAllocationDao();
        roomDao r1 = new roomDao();
        ExamDao e1 = new ExamDao();
        Collections.shuffle(students);
        List<Room> rooms = r1.getRoom();
        List<Exam> exam = e1.getExam();
        int successcount = 0;
        int failcount = 0;
        int eindex = 0;
        Exam e = exam.get(eindex);
        int index = 0;
        for(Room r : rooms){
            int seat_no = 1,count = 0;
            while(index < students.size() && count<r.getCap()){
                Student prev = students.get(index);
                boolean found = false;
                for(int i = index+1 ; i < students.size() ; i++){
                    Student temp = students.get(i);
                    if(!temp.getDept().equals(prev.getDept())){
                        Collections.swap(students,i,index+1);
                        found = true;
                        break;
                    }
                }
                if(!found){
                    for(int j = index+1 ; j < students.size() ; j++){
                        Student temp2 = students.get(j);
                        if(!temp2.getSemester().equals(prev.getSemester())){
                            Collections.swap(students,j,index+1);
                            break;
                        }
                    }
                }
                Student s = students.get(index);
                SeatAllocation sa = new SeatAllocation(seat_no,s.getId(),e.getExamId(),r.getRno());
                index++;count++;seat_no++;
                boolean check = saDao.insertSeat(sa);
                if(check) successcount++;
                else failcount++;
            }
        }
        return successcount;

    }
    public int teacherAllocation(){
        roomDao r1 = new roomDao();
        ExamDao e1 = new ExamDao();
        seatAllocationDao sa = new seatAllocationDao();
        List<Exam>exams = e1.getExam();
        //Collections.shuffle(teachers);
        List<Room> rooms = r1.getRoom();
        int possible = teachers.size()/rooms.size();
        int eid = 0;
        Exam e = exams.get(eid);
        int successcount = 0;
        int failcount = 0;
        int i = 0,count = 0;
        for(Room r : rooms){
            count = 0;
            while(i < teachers.size() && count<possible){
                Teacher t = teachers.get(i);
                TeacherAllocation ta = new TeacherAllocation(t.gettID(), r.getRno() ,e.getExamId());
                boolean check = sa.insertTeacher(ta);
                i++;count++;
                if(check)successcount++;
                else failcount++;
            }
        }
        return successcount;
    }
    public int student_count(){
        return students.size();
    }
}
