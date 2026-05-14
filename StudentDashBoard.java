package View;
import Model.Student;

import javax.swing.*;

public class StudentDashBoard extends Commonui{
    public StudentDashBoard(Student st){
        super("Student DashBoard");
        JLabel show = new JLabel("Student Dashboard"+" "+st.getName());
        show.setBounds(100,20,300,40);
        add(show);

        JLabel info = new JLabel(
                "<html>ID: " + st.getId() +
                        "<br>Dept: " + st.getDept() +
                        "<br>Semester: " + st.getSemester() +
                        "</html>"
        );
        info.setBounds(100, 100, 300, 100);
        add(info);
    }
}
