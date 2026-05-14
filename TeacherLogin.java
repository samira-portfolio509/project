package View;
import Model.Teacher;
import javax.swing.*;
import Dao.TeacherDao;
public class TeacherLogin extends Commonui{
    JTextField IDField,passField;
    public TeacherLogin (){
        super("Teacher Login Page");
        JLabel label = new JLabel("Please Enter The Info's To Login");
        label.setBounds(100, 20, 500, 30);
        add(label);

        JLabel id = new JLabel("Enter Teacher ID ");
        id.setBounds(100,150,200,40);
        add(id);
        IDField = new JTextField();
        IDField.setBounds(500,150,200,40);
        add(IDField);

        JLabel pass = new JLabel("Enter A Password");
        pass.setBounds(100,350,200,40);
        add(pass);
        passField = new JTextField();
        passField.setBounds(500,350,200,40);
        add(passField);

        JButton submit = new JButton("Login");
        submit.setBounds(500,450,100,40);
        add(submit);

        submit.addActionListener(e->{
            int idp = Integer.parseInt(IDField.getText());
            String passo = passField.getText();
            TeacherDao t = new TeacherDao();
            Teacher res = t.teacherLogin(idp,passo);
            if(res != null){
                JOptionPane.showMessageDialog(null,"Login Successful");
                new TeacherDashBoard(res);
            }
            else{
                JOptionPane.showMessageDialog(null,"Login Is Not Successfull.Try Again");
                this.dispose();
            }
        });
    }
}
