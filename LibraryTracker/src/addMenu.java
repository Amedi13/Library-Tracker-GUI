import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

class addMenu extends JFrame implements ActionListener {

    // labels and textfields
    private JLabel authorLabel;
    private JTextField authField;
    private JLabel titleLabel;
    private JTextField titleField;
    private JLabel statusLabel;
    private JTextField statusField;

    // buttons
    private JButton submit;
    private JButton addAnother;

    public addMenu() {
        setTitle("📘 Add a New Book");
        setSize(400, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null); // center the window

        // Set layout
        setLayout(new GridBagLayout());
        getContentPane().setBackground(new Color(252, 238, 238)); // light background
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        Font labelFont = new Font("SansSerif", Font.BOLD, 14);
        Font inputFont = new Font("SansSerif", Font.PLAIN, 14);

        // Author
        authorLabel = new JLabel("Author:");
        authorLabel.setFont(labelFont);
        authField = new JTextField(20);
        authField.setFont(inputFont);

        // Title
        titleLabel = new JLabel("Title:");
        titleLabel.setFont(labelFont);
        titleField = new JTextField(20);
        titleField.setFont(inputFont);

        // Status
        statusLabel = new JLabel("Status:");
        statusLabel.setFont(labelFont);
        statusField = new JTextField(20);
        statusField.setFont(inputFont);

        // Buttons
        submit = new JButton("Submit");
        submit.setActionCommand("SUBMIT");
        submit.addActionListener(this);
        styleButton(submit);

        addAnother = new JButton("Add Another Book");
        addAnother.setActionCommand("ADD_ANOTHER");
        addAnother.addActionListener(this);
        styleButton(addAnother);

        // Layout components
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(authorLabel, gbc);
        gbc.gridx = 1;
        add(authField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(titleLabel, gbc);
        gbc.gridx = 1;
        add(titleField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(statusLabel, gbc);
        gbc.gridx = 1;
        add(statusField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        add(submit, gbc);

        gbc.gridy = 4;
        add(addAnother, gbc);
    }

    private void styleButton(JButton button) {
        button.setBackground(new Color(103, 138, 194));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setFont(new Font("SansSerif", Font.BOLD, 14));
        button.setPreferredSize(new Dimension(200, 35));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String authorInput = authField.getText();
        String titleInput = titleField.getText();
        String statusInput = statusField.getText();

        books book = new books(authorInput, titleInput, statusInput);
        BookManager.bookList.add(book);

        JOptionPane.showMessageDialog(this, "✅ Book added successfully!");

        if (e.getActionCommand().equals("ADD_ANOTHER")) {
            addMenu newForm = new addMenu();
            newForm.setVisible(true);
            this.dispose();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new addMenu().setVisible(true);
        });
    }
}
