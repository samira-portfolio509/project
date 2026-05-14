package View;
import Dao.ExamDao;
import Model.Exam;
import java.awt.*;
import java .util.List;
import java.util.ArrayList;
import javax.swing.*;
public class ExamRoutineView extends Commonui{
    public ExamRoutineView() {
        super("Exam Rountine Page");
        ExamDao e1 = new ExamDao();
        List<Exam>exams = new ArrayList<>();
                exams = e1.getExam();
        StringBuilder sb = new StringBuilder();
        for(Exam e : exams){
            sb.append("Exam ID : ").append(e.getExamId()).append("\n");
            sb.append("Exam Subject : ").append(e.getEsub()).append("\n");
            sb.append("Exam Date : ").append(e.getEdate()).append("\n");
            sb.append("Exam Time : ").append(e.getEtime()).append("\n");
            sb.append("-----------------").append("\n");
        }
        JTextArea info = new JTextArea(sb.toString());
        JScrollPane scroll = new JScrollPane(info);
        scroll.setBounds(100,20,500,500);
        add(scroll);
        info.setEditable(false);
        setVisible(true);
    }
}
//public ExamRoutineView() {
//    super("Exam Routine Page");
//
//    ExamDao dao = new ExamDao();
//    List<Exam> exams = dao.getExam();
//
//    String[] columns = {"Exam ID", "Subject", "Date", "Time"};
//    String[][] data = new String[exams.size()][4];
//
//    for (int i = 0; i < exams.size(); i++) {
//        Exam e = exams.get(i);
//
//        data[i][0] = String.valueOf(e.getExamId());
//        data[i][1] = e.getEsub();
//        data[i][2] = e.getEdate();
//        data[i][3] = e.getEtime();
//    }
//
//    JTable table = new JTable(data, columns);
//
//    JScrollPane scroll = new JScrollPane(table);
//    scroll.setBounds(50, 50, 600, 300);
//
//    add(scroll);
//
//    setVisible(true);
//}
