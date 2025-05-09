import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class findMenu extends JFrame implements ActionListener {

    private JButton find;
    private JTextField textField;
    private JLabel instructionLabel;

    public findMenu() {
        setTitle("🔍 Find a Book");
        setSize(400, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null); // center on screen

        // Main layout
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(252, 238, 238));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        Font font = new Font("SansSerif", Font.PLAIN, 14);

        // Label
        instructionLabel = new JLabel("Enter the title of the book you'd like to find:");
        instructionLabel.setFont(font);
        instructionLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        // TextField
        textField = new JTextField();
        textField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        textField.setFont(font);

        // Button
        find = new JButton("Find Book");
        find.setActionCommand("FIND_BOOK");
        find.addActionListener(this);
        styleButton(find);

        // Add components
        panel.add(instructionLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(textField);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(find);

        add(panel);
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
        String bookToFind = textField.getText().toLowerCase();
        boolean found = false;

        for (books book : BookManager.bookList) {
            if (book.getTitle().equalsIgnoreCase(bookToFind)) {
                JOptionPane.showMessageDialog(this,
                        "✅ Book Found!\n\nTitle: " + book.getTitle() +
                        "\nAuthor: " + book.getAuthor() +
                        "\nStatus: " + book.getStatus());
                found = true;
                break;
            }
        }

        if (!found) {
            JOptionPane.showMessageDialog(this, "❌ Book not found. Please check the title and try again.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new findMenu().setVisible(true);
        });
    }
}
