package View;
import Dao.StudentDao;
import Model.Student;

import javax.swing.*;

public class StudentLogin extends Commonui{
   JTextField IDField,PassField;
    public  StudentLogin(){
        super("Student Login Page");
        JLabel tittle = new JLabel("Student Login Page");
        tittle.setBounds(100,20,500,30);
        add(tittle);

        JLabel ID = new JLabel("Enter Your ID");
        ID.setBounds(150,50,200,40);
        add(ID);
        IDField = new JTextField();
        IDField.setBounds(250,50,200,40);
        add(IDField);

        JLabel pass = new JLabel("Enter Your Pass ");
        pass.setBounds(150,150,200,40);
        add(pass);
        PassField = new JTextField();
        PassField.setBounds(250,150,200,40);
        add(PassField);

        JButton login = new JButton("Login");
        login.setBounds(500,250,100,40);
        add(login);

        login.addActionListener(e ->{
            StudentDao s = new StudentDao();
            Student st = s.login(IDField.getText(),PassField.getText());
            if(st != null){
                JOptionPane.showMessageDialog(null,"Login Successful");
                new StudentDashBoard(st);
            }
            else{
                JOptionPane.showMessageDialog(null,"Please Enter Valid ID And Password");
            }
        });


    }

}
