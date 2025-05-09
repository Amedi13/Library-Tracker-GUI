import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class displayMenu extends JFrame implements ActionListener {

    private ArrayList<books> books;

    public displayMenu(ArrayList<books> books) {
        this.books = books;

        setTitle("📖 Book List");
        setSize(500, 500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Main panel with vertical box layout
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBackground(new Color(252, 238, 238));
        contentPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        Font labelFont = new Font("SansSerif", Font.PLAIN, 14);

        if (BookManager.bookList.isEmpty()) {
            JLabel emptyLabel = new JLabel("No books to display.");
            emptyLabel.setFont(labelFont);
            emptyLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            contentPanel.add(emptyLabel);
        } else {
            for (books book : BookManager.bookList) {
                JLabel bookLabel = new JLabel(
                    "📚 Title: " + book.getTitle() + 
                    " | ✍️ Author: " + book.getAuthor() + 
                    " | 📌 Status: " + book.getStatus()
                );
                bookLabel.setFont(labelFont);
                bookLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
                bookLabel.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
                contentPanel.add(bookLabel);
            }
        }

        // Make scrollable if too many books
        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(null);

        add(scrollPane);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // No action needed
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new displayMenu(new ArrayList<>()).setVisible(true);
        });
    }
}
