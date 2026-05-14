package View;

import Model.Student;
import Dao.StudentDao;
import javax.swing.*;

public class Studentview extends Commonui {
    JTextField nameField, IDField, deptField, semField, passField;

    public Studentview() {
        super("Student Signup Form");
        JLabel label = new JLabel("Please Fill The Form Given Below");
        label.setBounds(100, 20, 500, 30);
        add(label);

        JLabel nameo = new JLabel("Enter Student Name : ");
        nameo.setBounds(100, 50, 200, 40);
        add(nameo);
        nameField = new JTextField();
        nameField.setBounds(500, 50, 100, 40);
        add(nameField);

        JLabel id = new JLabel("Enter Student ID ");
        id.setBounds(100, 150, 200, 40);
        add(id);
        IDField = new JTextField();
        IDField.setBounds(500, 150, 100, 40);
        add(IDField);

        JLabel dep = new JLabel("Enter Student Department ");
        dep.setBounds(100, 250, 200, 40);
        add(dep);
        deptField = new JTextField();
        deptField.setBounds(500, 250, 100, 40);
        add(deptField);

        JLabel sem = new JLabel("Enter Student Semester ");
        sem.setBounds(100, 350, 200, 40);
        add(sem);
        semField = new JTextField();
        semField.setBounds(500, 350, 200, 40);
        add(semField);

        JLabel pass = new JLabel("Enter Student Password ");
        pass.setBounds(100, 450, 200, 40);
        add(pass);
        passField = new JTextField();
        passField.setBounds(500, 450, 200, 40);
        add(passField);

        JButton submit = new JButton("Submit");
        submit.setBounds(350, 550, 100, 40);
        add(submit);

        submit.addActionListener(e -> {
            Student s = new Student(
                    nameField.getText(),
                    IDField.getText(),
                    deptField.getText(),
                    semField.getText(),
                    passField.getText()
            );
            StudentDao sdao = new StudentDao();
            boolean res = sdao.signup(s);
            if (res) {
                JOptionPane.showMessageDialog(null, "Student Signup Succesful");
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Student Signup Failed");
                this.dispose();
            }
        });
    }
}
//    public Student signup (){
//
//        System.out.println("Welcome To Student Signup Page. Please Enter All The Info's");
//        System.out.print("Enter Your Name : ");
//        String name = sc.nextLine();
//        System.out.print("Enter Your ID : ");
//        String id = sc.nextLine();
//        System.out.print("Enter Your Department(Short_form) : ");
//        String dep = sc.nextLine();
//        System.out.print("Enter Your Semester : ");
//        String sem = sc.nextLine();
//        System.out.print("Enter A Strong Password : ");
//        String pass = sc.nextLine();
//        return new Student (name,id,dep,sem,pass);
//    }
//    public String id(){
//        System.out.print("Enter Your ID : ");
//        return sc.nextLine();
//    }
//    public String pass(){
//        System.out.print("Enter Your password : ");
//        return sc.nextLine();
//    }
//}
