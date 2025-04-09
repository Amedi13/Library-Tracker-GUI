import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * Add Book Menu Class
 */
 class addMenu extends JFrame implements ActionListener{

    private JTextArea message; 

    public addMenu() {
        setTitle("Add a new Book");
        setLayout(new FlowLayout()); 
        setSize(500, 500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }

    public static void main(String[] args) {

         //add menu frame
         JFrame frame = new JFrame("Add Menu");
         frame.setVisible(true);
    }
    
}
