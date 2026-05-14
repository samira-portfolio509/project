package View;
import Controller.SeatAllocationmain;
import javax.swing.*;

public class ImplementTaView {
   public ImplementTaView(){
       SeatAllocationmain s1 = new SeatAllocationmain();
       int success = s1.teacherAllocation();
       if(success >= 1){
           JOptionPane.showMessageDialog(null,success+" "+"Teachers Assigned");
       }
       else{
           JOptionPane.showMessageDialog(null,"Please Try Again");
       }
   }
}
