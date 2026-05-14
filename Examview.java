package View;
import Model.Exam;
import Dao.ExamDao;
import javax.swing.*;

public class Examview extends Commonui{
    JTextField nameField,dateField,timeField;
    public Examview() {
        super("Exam Insertion Page");
        JLabel show = new JLabel("Input All The Exam Data");
        show.setBounds(100,20,500,40);
        add(show);

        JLabel name = new JLabel("Enter Exam Name");
        name.setBounds(100,50,200,40);
        add(name);
        nameField = new JTextField();
        nameField.setBounds(500,50,300,40);
        add(nameField);

        JLabel date = new JLabel("Enter Exam date");
        date.setBounds(100,150,200,40);
        add(date);
        dateField = new JTextField();
        dateField.setBounds(500,150,300,40);
        add(dateField);

        JLabel time = new JLabel("Enter Exam Time :");
        time.setBounds(100,250,200,40);
        add(time);
        timeField = new JTextField();
        timeField.setBounds(500,250,300,40);
        add(timeField);

        JButton submit = new JButton("Submit");
        submit.setBounds(500,450,80,40);
        add(submit);

        JButton back = new JButton("Back");
        back.setBounds(400,450,80,40);
        add(back);

        back.addActionListener(e->{
            this.dispose();
        });

        submit.addActionListener(e->{
            Exam e1 = new Exam(
                    nameField.getText(),
                    dateField.getText(),
                    timeField.getText()
            );
            ExamDao d1 = new ExamDao();
            boolean res = d1.insertEaxm(e1);
            if(res){
                JOptionPane.showMessageDialog(null,"Exam Insertion Complete");
                this.dispose();
            }
            else{
                JOptionPane.showMessageDialog(null,"Try Again");
                this.dispose();
            }
        });

    }
}
//
//    public Exam insertRoutine(){
//        System.out.println("Insert Exam Routine");
//        System.out.print("Enter Exam Name : ");
//        String name = sc.nextLine();
//        System.out.print("Enter Exam Date : ");
//        String date = sc.nextLine();
//        System.out.print("Enter Exam Time : ");
//        String time = sc.nextLine();
//        return new Exam(name,date,time);
//    }
//}
