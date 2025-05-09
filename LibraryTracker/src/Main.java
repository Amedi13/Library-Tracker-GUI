import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Main extends JFrame implements ActionListener {

    // Buttons
    private JButton add, display, find, remove;

    public Main() {
        setTitle("📚 Welcome to Your Library 📚");
        setSize(400, 400);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window
        setLayout(new BorderLayout());

        // Panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 1, 15, 15)); // 4 rows, 1 column, spacing
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        buttonPanel.setBackground(new Color(245, 245, 245));

        Font buttonFont = new Font("SansSerif", Font.BOLD, 16);

        add = createStyledButton("Add New Book", "ADD", buttonFont);
        display = createStyledButton("Display Books", "DISPLAY", buttonFont);
        find = createStyledButton("Find a Book", "FIND", buttonFont);
        remove = createStyledButton("Remove a Book", "REMOVE", buttonFont);

        buttonPanel.add(add);
        buttonPanel.add(display);
        buttonPanel.add(find);
        buttonPanel.add(remove);

        add(buttonPanel, BorderLayout.CENTER);
    }

    private JButton createStyledButton(String text, String command, Font font) {
        JButton button = new JButton(text);
        button.setFont(font);
        button.setBackground(new Color(103, 138, 194));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setActionCommand(command);
        button.addActionListener(this);
        return button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ArrayList<books> list = new ArrayList<>();
        String command = e.getActionCommand();

        switch (command) {
            case "ADD":
                new addMenu().setVisible(true);
                break;
            case "DISPLAY":
                new displayMenu(list).setVisible(true);
                break;
            case "FIND":
                new findMenu().setVisible(true);
                break;
            case "REMOVE":
                new removeMenu().setVisible(true);
                break;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Main frame = new Main();
            frame.setVisible(true);
        });
    }
}
