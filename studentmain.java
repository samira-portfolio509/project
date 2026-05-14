package Controller;
import View.Studentview;
import Model.Student;
import Dao.StudentDao;
import View.StudentDashBoard;
import javax.swing.*;
import View.StudentLogin;
public class studentmain {
    public static void main(String[] args){
        SwingUtilities.invokeLater(() -> {
            new StudentLogin();
        });

    }
}
