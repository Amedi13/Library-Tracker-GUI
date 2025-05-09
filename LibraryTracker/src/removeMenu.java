import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class removeMenu extends JFrame implements ActionListener {

    private JButton remove;
    private JButton removeAnother;
    private JLabel instructionLabel;
    private JTextField textField;

    public removeMenu() {
        setTitle("🗑️ Remove a Book");
        setSize(500, 500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(new Color(252, 238, 238));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        Font font = new Font("SansSerif", Font.PLAIN, 14);

        // Instruction
        instructionLabel = new JLabel("Enter the index of the book you'd like to remove:");
        instructionLabel.setFont(font);
        instructionLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        textField = new JTextField(10);
        textField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        textField.setFont(font);

        // Button: Remove Book
        remove = new JButton("Remove Book");
        remove.setActionCommand("REMOVE_BOOK");
        remove.addActionListener(this);
        styleButton(remove);

        // Button: Remove Another Book 
        removeAnother = new JButton("Remove Another Book");
        removeAnother.setActionCommand("REMOVE_ANOTHER_BOOK");
        removeAnother.addActionListener(this);
        styleButton(removeAnother);

        // Book List Panel
        JPanel listPanel = new JPanel();
        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));
        listPanel.setBackground(new Color(252, 238, 238));

        if (BookManager.bookList.isEmpty()) {
            JLabel emptyLabel = new JLabel("No books available.");
            emptyLabel.setFont(font);
            listPanel.add(emptyLabel);
        } else {
            for (int i = 0; i < BookManager.bookList.size(); i++) {
                books book = BookManager.bookList.get(i);
                JLabel bookLabel = new JLabel(i + ": 📘 " + book.getTitle() + " | ✍️ " + book.getAuthor() + " | 📌 " + book.getStatus());
                bookLabel.setFont(font);
                bookLabel.setBorder(BorderFactory.createEmptyBorder(4, 0, 4, 0));
                listPanel.add(bookLabel);
            }
        }

        JScrollPane scrollPane = new JScrollPane(listPanel);
        scrollPane.setPreferredSize(new Dimension(450, 200));
        scrollPane.setBorder(BorderFactory.createTitledBorder("Book List"));

        // Add components to main panel
        mainPanel.add(scrollPane);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 15)));
        mainPanel.add(instructionLabel);
        mainPanel.add(textField);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(remove);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(removeAnother);

        add(mainPanel);
    }

    private void styleButton(JButton button) {
        button.setBackground(new Color(103, 138, 194));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setFont(new Font("SansSerif", Font.BOLD, 14));
        button.setAlignmentX(Component.LEFT_ALIGNMENT);
        button.setMaximumSize(new Dimension(200, 35));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("REMOVE_BOOK")) {
            try {
                int index = Integer.parseInt(textField.getText());
                if (index >= 0 && index < BookManager.bookList.size()) {
                    BookManager.bookList.remove(index);
                    JOptionPane.showMessageDialog(this, "✅ Book removed successfully!");
                    this.dispose();
                    new removeMenu().setVisible(true); // refresh the list
                } else {
                    JOptionPane.showMessageDialog(this, "❌ Invalid index. Please try again.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "❌ Please enter a valid number.");
            }
        }
        // Future use
        if (e.getActionCommand().equals("REMOVE_ANOTHER_BOOK")) {
            this.dispose();
            new removeMenu().setVisible(true);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new removeMenu().setVisible(true);
        });
    }
}
