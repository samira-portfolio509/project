package View;
import javax.swing.*;
import Dao.seatAllocationDao;
public class TadeleteView extends Commonui{
    public TadeleteView(){
        super("Previous Teacher Allocation Delete Page");
        JLabel show = new JLabel("Teacher Deletion Page");
        show.setBounds(100,20,300,40);
        add(show);

        JLabel id = new JLabel("Enter The Exam ID To Delete Previous Allocation");
        id.setBounds(100,50,500,40);
        add(id);
        JTextField idField = new JTextField();
        idField.setBounds(600,50,200,40);
        add(idField);

        JButton submit = new JButton("Delete");
        submit.setBounds(500,100,80,40);
        add(submit);

        submit.addActionListener(e->{
            seatAllocationDao s1 = new seatAllocationDao();
            boolean res = s1.deleteTeacher_Allocation(Integer.parseInt(idField.getText()));
            if(res){
                JOptionPane.showMessageDialog(null,"Previous Seat Allocation Deleted");
                this.dispose();
            }
            else{
                JOptionPane.showMessageDialog(null,"Try Again Later");
                this.dispose();
            }
        });
    }
}
