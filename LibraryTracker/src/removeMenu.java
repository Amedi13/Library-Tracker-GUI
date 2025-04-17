import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.FlowLayout;

public class removeMenu extends JFrame implements ActionListener {

    private JButton remove;
    private JButton removeAnother;
    private JLabel label;
    private JTextField textField;

    public removeMenu() {
        setTitle("Remove a Book");
        setLayout(new FlowLayout());
        setSize(500, 500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        label = new JLabel("Enter the Index of the Book you would like to remove");
        textField = new JTextField(20);

        remove = new JButton("Remove Book");
        remove.addActionListener(this);
        remove.setActionCommand("REMOVE_BOOK");

        removeAnother = new JButton("Remove another book");
        removeAnother.addActionListener(this);
        removeAnother.setActionCommand("REMOVE_ANOTHER_BOOK");

        // Display the indices of the books in the bookList
        for (int i = 0; i < BookManager.bookList.size(); i++) {
            books book = BookManager.bookList.get(i);
            JLabel bookLabel = new JLabel(i + ": Title: " + book.getTitle() + ", Author: " + book.getAuthor() + ", Status: " + book.getStatus());
            add(bookLabel);
        }

        add(label);
        add(textField);
        add(remove);
        add(removeAnother);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("REMOVE_BOOK")) {
            try {
                int index = Integer.parseInt(textField.getText());
                if (index >= 0 && index < BookManager.bookList.size()) {
                    BookManager.bookList.remove(index);
                    JOptionPane.showMessageDialog(this, "Book removed successfully");
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid index. Please try again.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid number.");
            }
        } else if (e.getActionCommand().equals("REMOVE_ANOTHER_BOOK")) {
            // Logic to remove another book
        }
    }

    public static void main(String[] args) {
        removeMenu frame = new removeMenu();
        frame.setVisible(true);
    }
}