package View;
import Model.Teacher;
import java.util.Scanner;
import javax.swing.*;
import Dao.TeacherDao;
public class Teacherview extends Commonui{
   JTextField nameField,IDField,deptField,passField;
    public Teacherview() {
        super("Teacher Signup");
        JLabel label = new JLabel("Please Fill The Form Given Below");
        label.setBounds(100, 20, 500, 30);
        add(label);

        JLabel name = new JLabel("Enter Teacher Name ");
        name.setBounds(100,50,200,40);
        add(name);
        nameField = new JTextField();
        nameField.setBounds(500,50,100,40);
        add(nameField);

        JLabel id = new JLabel("Enter Teacher ID ");
        id.setBounds(100,150,200,40);
        add(id);
        IDField = new JTextField();
        IDField.setBounds(500,150,200,40);
        add(IDField);

        JLabel dept = new JLabel("Enter Teacher Department ");
        dept.setBounds(100,250,200,40);
        add(dept);
        deptField = new JTextField();
        deptField.setBounds(500,250,200,40);
        add(deptField);

        JLabel pass = new JLabel("Enter A Password");
        pass.setBounds(100,350,200,40);
        add(pass);
        passField = new JTextField();
        passField.setBounds(500,350,200,40);
        add(passField);

        JButton submit = new JButton("Submit");
        submit.setBounds(500,450,100,40);
        add(submit);

        submit.addActionListener(e ->{
            Teacher t1 = new Teacher(
                    nameField.getText(),
                    Integer.parseInt(IDField.getText()),
                    deptField.getText(),
                    passField.getText()
            );
            TeacherDao t = new TeacherDao();
            boolean res = t.teacherSignup(t1);
            if(res){
                JOptionPane.showMessageDialog(null,"Teacher Signup Successful");
                this.dispose();
            }
            else{
                JOptionPane.showMessageDialog(null,"Signup Failed.Try Again");
                this.dispose();
            }
        });
    }
}
