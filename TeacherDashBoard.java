package View;
import Model.Teacher;

import javax.swing.*;

public class TeacherDashBoard extends Commonui {
    public TeacherDashBoard(Teacher t1){
        super("Teacher Dashboard");
        JLabel show = new JLabel("Welcome" +" "+ t1.gettName() );
        show.setBounds(100,20,500,40);
        add(show);

        JTextArea info = new JTextArea(
                "ID : "+" "+t1.gettID()+"\n"+
                        "Department"+" "+t1.gettdept()
        );
        info.setBounds(200,50,500,100);
        add(info);
        info.setEditable(false);
    }
}
