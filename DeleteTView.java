package View;

import Dao.StudentDao;
import Dao.TeacherDao;

import javax.swing.*;

public class DeleteTView extends Commonui{
    public DeleteTView(){
        super("Teacher Delete Page");
        JLabel id = new JLabel("Enter The Teacher ID : ");
        id.setBounds(100,150,500,50);
        add(id);
        JTextField show = new JTextField();
        show.setBounds(400,150,200,50);
        add(show);

        JButton DeleteTeacher = new JButton("Delete");
        DeleteTeacher.setBounds(500,500,100,40);
        add(DeleteTeacher);

        DeleteTeacher.addActionListener(e->{
            TeacherDao t = new TeacherDao();
            boolean res = t.teacherDelete(Integer.parseInt(show.getText()));
            if(res){
                JOptionPane.showMessageDialog(null,"Teacher Deleted");
                this.dispose();
            }
            else{
                JOptionPane.showMessageDialog(null,"Please Try Again");
                this.dispose();
            }
        });
    }
}
