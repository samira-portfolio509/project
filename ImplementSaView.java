package View;
import Controller.SeatAllocationmain;
import javax.swing.*;
public class ImplementSaView{
    public ImplementSaView(){
        //super("Seat Planning page");
        SeatAllocationmain s1 = new SeatAllocationmain();
        int success = s1.allocationLogic();
        int student = s1.student_count();
        if(success == student){
            JOptionPane.showMessageDialog(null,success+" "+"Student Implemented Successfully");
            //this.dispose();
        }
        else{
            JOptionPane.showMessageDialog(null,"Please Try Again");
            //this.dispose();
        }
    }
}
