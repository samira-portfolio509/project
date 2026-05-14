package View;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Dao.seatAllocationDao;
public class Seatallocationview extends Commonui{
    public Seatallocationview(){
        super("Delete Seat Allocation ");
        JLabel show = new JLabel("Delete All The Previous Allocation");
        show.setBounds(100,20,500,40);
        add(show);

        JLabel id = new JLabel("Enter The Exam ID To delete Previous SeatAllocation");
        id.setBounds(50,50,500,40);
        add(id);
        JTextField idField = new JTextField();
        idField.setBounds(600,50,100,40);
        add(idField);

        JButton submit = new JButton("Delete");
        submit.setBounds(500,150,80,40);
        add(submit);

        submit.addActionListener(e->{
            seatAllocationDao sa = new seatAllocationDao();
            int id2 = Integer.parseInt(idField.getText());
            boolean res = sa.clearAllocation(id2);
            if(res){
                JOptionPane.showMessageDialog(null,"Deletion Successful");
                this.dispose();
            }
            else{
                JOptionPane.showMessageDialog(null,"Try Again");
                this.dispose();
            }
        });
    }
}

//    Scanner sc;
//    public Seatallocationview(Scanner sc){
//        this.sc = sc;
//    }
//    public int deleteAllocation(){
//        System.out.print("Enter The Exam ID To Delete Seat Allocation : ");
//        int id = Integer.parseInt(sc.nextLine());
//        return id;
//    }
//    public void insertSeat(){
//        System.out.println("Click here To Place Seats ");
//    }
//    public void insertTeacher(){
//        System.out.println("Click here To Place Teachers ");
//    }
//}

