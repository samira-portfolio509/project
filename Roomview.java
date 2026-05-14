package View;

import Model.Room;
import Dao.roomDao;
import javax.swing.*;
public class Roomview extends Commonui {
    JTextField rnField,cpField,bdField;
    public Roomview (){
        super("Room Insertion Page");
        JLabel show = new JLabel("Isert Room Info");
        show.setBounds(100,20,300,40);
        add(show);

        JLabel rn = new JLabel("Room Number");
        rn.setBounds(100,50,300,40);
        add(rn);
        rnField = new JTextField();
        rnField.setBounds(400,50,200,40);
        add(rnField);

        JLabel cp = new JLabel("Enter The Room Capacity ");
        cp.setBounds(100,150,200,40);
        add(cp);
        cpField = new JTextField();
        cpField.setBounds(400,150,200,40);
        add(cpField);

        JLabel bd = new JLabel("Enter The  Building Number");
        bd.setBounds(100,250,300,40);
        add(bd);
        bdField = new JTextField();
        bdField.setBounds(400,250,200,40);
        add(bdField);

        JButton submit = new JButton("Insert");
        submit.setBounds(500,450,80,40);
        add(submit);

        submit.addActionListener(e->{
            roomDao r1 = new roomDao();
            Room r = new Room(
                    Integer.parseInt(rnField.getText()),
                    Integer.parseInt(cpField.getText()),
                    Integer.parseInt(bdField.getText())
            );
            boolean res = r1.insertRoom(r);
            if(res){
                JOptionPane.showMessageDialog(null,"Room Inserted");
                this.dispose();
            }
            else{
                JOptionPane.showMessageDialog(null,"Try Again");
                this.dispose();
            }
        });
    }
}
//    public Room addRoom(){
//        System.out.println("Enter Room Data's!!");
//        System.out.print("Room Number : ");
//        int no = Integer.parseInt(sc.nextLine());
//        System.out.print("Enter Room Capacity : ");
//        int cp = Integer.parseInt(sc.nextLine());
//        System.out.print("Enter Building ID : ");
//        int bd = Integer.parseInt(sc.nextLine());
//        return new Room(no,cp,bd);
//    }
//}
