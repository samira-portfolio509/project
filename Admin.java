package Controller;
import View.Commonview;
import javax.swing.SwingUtilities;
public class Admin {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->{
            new Commonview();
        });
    }
}
