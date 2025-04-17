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
import java.awt.print.Book;
import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.GridLayout;


public class displayMenu extends JFrame implements ActionListener {

   // private JButton display; 
    private ArrayList<books> books;

    // frame constructor 
    public displayMenu(ArrayList<books> books) {
        this.books = books; 
        
        setTitle("Display Books");
        setLayout(new FlowLayout());
        setSize(500,500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);


       if(BookManager.bookList.isEmpty()){
        add(new JLabel("No books to display"));
       } else {
        for (books book : BookManager.bookList) {
            JLabel bookLabel = new JLabel("Title: " + book.getTitle() + ", Author: " + book.getAuthor() + ", Status: " + book.getStatus());
            add(bookLabel);
        }
       }

    }

    

    @Override
    public void actionPerformed(ActionEvent e) {
       
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setVisible(true); 
       
    }
    
}
