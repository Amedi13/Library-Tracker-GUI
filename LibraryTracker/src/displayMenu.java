import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.GridLayout;


public class displayMenu extends JFrame implements ActionListener {

    // frame constructor 
    public displayMenu() {

        
        setTitle("Display Books");
        setLayout(new FlowLayout());
        setSize(500,500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setVisible(true); 
    }
    
}
