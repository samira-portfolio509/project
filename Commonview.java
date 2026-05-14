package View;
import javax.swing.*;
import Dao.ExamDao;
public class Commonview extends Commonui {

    public Commonview() {
        super("Admin panel");
        JLabel label = new JLabel("Welcome To Student Seating Management");
        label.setBounds(120,10,300,30);
        add(label);
        JButton btn1 = new JButton("Student Signup");
        btn1.setBounds(100, 50, 200, 30);
        add(btn1);

        JButton btn2 = new JButton("Student Login");
        btn2.setBounds(100, 100, 200, 30);
        add(btn2);

        JButton btn3 = new JButton("Delete Student");
        btn3.setBounds(100, 150, 200, 30);
        add(btn3);

        JButton btn4 = new JButton("Teacher Signup");
        btn4.setBounds(100, 200, 200, 30);
        add(btn4);

        JButton btn5 = new JButton("Teacher Login");
        btn5.setBounds(100, 250, 200, 30);
        add(btn5);

        JButton btn6 = new JButton("Delete Teacher");
        btn6.setBounds(100, 300, 200, 30);
        add(btn6);

        JButton btn7 = new JButton("Insert Routine");
        btn7.setBounds(100, 350, 200, 30);
        add(btn7);

        JButton btn8 = new JButton("See Routine");
        btn8.setBounds(100, 400, 200, 30);
        add(btn8);

        JButton btn9 = new JButton("Add Room Number And Capacity");
        btn9.setBounds(100, 450, 300, 30);
        add(btn9);

        JButton btn10 = new JButton("Delete All The Previous Seat Allocation");
        btn10.setBounds(100, 500, 300, 30);
        add(btn10);

        JButton btn11 = new JButton("Implement Seat Allocation ");
        btn11.setBounds(100, 550, 300, 30);
        add(btn11);

        JButton btn12 = new JButton("Implement Teacher Allocation");
        btn12.setBounds(100, 600, 300, 30);
        add(btn12);

        JButton btn14 = new JButton("Delete Previous Teacher Allocation");
        btn14.setBounds(100,650,300,30);
        add(btn14);

        JButton btn13 = new JButton("Delete Routine");
        btn13.setBounds(100, 700, 200, 30);
        add(btn13);

        btn1.addActionListener(e ->{
            new Studentview();
        });

        btn2.addActionListener(e->{
            new StudentLogin();
        });

        btn3.addActionListener(e ->{
            new DeleteSView();
        });

        btn4.addActionListener(e ->{
           new Teacherview();
        });

        btn5.addActionListener(e->{
            new TeacherLogin();
        });

        btn6.addActionListener(e->{
           new DeleteTView();
        });

        btn7.addActionListener(e->{
            new Examview();
        });

        btn8.addActionListener(e->{
            new ExamRoutineView();
        });

        btn9.addActionListener(e->{
           new Roomview();
        });

        btn10.addActionListener(e->{
           new Seatallocationview();
        });

        btn11.addActionListener(e->{
            new ImplementSaView();
        });

        btn12.addActionListener(e->{
            new ImplementTaView();
        });

        btn13.addActionListener(e->{
            ExamDao e1 = new ExamDao();
            boolean res = e1.deleteExam();
            if(res){
                JOptionPane.showMessageDialog(null,"Exam Routines Are Deleted");
            }
            else{
                JOptionPane.showMessageDialog(null,"Try Again");
            }
        });

        btn14.addActionListener(e ->{
            new TadeleteView();
        });
    }
}
