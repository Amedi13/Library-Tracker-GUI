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


public class findMenu extends JFrame implements ActionListener {

    private JButton find;
    private JTextField textField;
    private JLabel label;

    //constructor 
    public findMenu() {

        setTitle("Find Book");
        setLayout(new FlowLayout());
        setSize(500, 500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        label = new JLabel("Enter the title of the book you would like to find");
        textField = new JTextField(20); 

        find = new JButton("Find Book");
        find.addActionListener(this);
        find.setActionCommand("FIND_BOOK");

        add(label); 
        add(textField);
        add(find);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String bookToFind = textField.getText().toLowerCase();
        boolean found = false;
        for (books book : BookManager.bookList) {
            if (book.getTitle().equalsIgnoreCase(bookToFind)) {
                JOptionPane.showMessageDialog(this, "Book found: " + book.getTitle() + ", Author: " + book.getAuthor() + ", Status: " + book.getStatus());
                found = true;
                break;
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame(); 
        frame.setVisible(true); 
    }
    
}
