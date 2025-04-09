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

 

/**
 * Main Class
 * */
public class Main extends JFrame implements ActionListener {


   // buttons 
   private JButton add; 
   private JButton display; 
   private JButton find; 
   private JButton remove; 

   /**
    * Main frame
    */
   public Main(){
    
    setTitle("Welcome to your Library"); 

    add = new JButton("Add new Book"); 
    add.addActionListener(this);
    add.setActionCommand("ADD");

    display = new JButton("Display Books");
    display.addActionListener(this);
    display.setActionCommand("DISPLAY");

    find = new JButton("Find a book");
    find.addActionListener(this);
    find.setActionCommand("FIND");

    remove = new JButton("Remove a Book"); 
    remove.addActionListener(this);
    remove.setActionCommand("REMOVE");

    //add buttons to the frame
    add(add); 
    add(display);
    add(find); 
    add(remove); 

    setLayout(new FlowLayout()); 
    setDefaultCloseOperation(EXIT_ON_CLOSE);


   }

    /**
     * Action performed method
     * @param e event 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        
        // create a empty Array of objects
        ArrayList<books> list = new ArrayList<>();

        String command = e.getActionCommand();

        switch(command){
            case "ADD":
            addMenu addBookMenu = new addMenu(); 
            addBookMenu.setVisible(true);
            break; 

            case "DISPLAY": 
            displayMenu display = new displayMenu(); 
            display.setVisible(true); 
            break;

            case "FIND": 
            findMenu findBook = new findMenu(); 
            findBook.setVisible(true); 
            break;

            case "REMOVE": 
            removeMenu removeBook = new removeMenu();
            removeBook.setVisible(true); 
            break; 

        }
    }

    /**
     * Main Method
     * @param args
     */
    public static void main(String[] args) {

        

    // create a new jframe
    Main frame = new Main(); 
    frame.setSize(400, 300);
    frame.setVisible(true );
    
        
    }    

}

