package Controller;
import Model.Teacher;
import java.util.Collections;
import java.util.List;
import View.TeacherLogin;

import javax.swing.*;

public class Teachermain {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(()->{
            new TeacherLogin();
        });
    }
}
