package View;

import Dao.StudentDao;

import javax.swing.*;

public class DeleteSView extends Commonui{
    public DeleteSView(){
        super("Student Delete Page");
        JLabel id = new JLabel("Enter The Student ID : ");
        id.setBounds(100,150,500,50);
        add(id);
        JTextField show = new JTextField();
        show.setBounds(400,150,200,50);
        add(show);

        JButton DeleteStudent = new JButton("Delete");
        DeleteStudent.setBounds(500,500,100,40);
        add(DeleteStudent);

        DeleteStudent.addActionListener(e->{
            StudentDao s = new StudentDao();
            boolean res = s.deleteStudent(show.getText());
            if(res){
                JOptionPane.showMessageDialog(null,"Student Deleted");
                this.dispose();
            }
            else{
                JOptionPane.showMessageDialog(null,"Please Try Again");
                this.dispose();
            }
        });
    }
}

