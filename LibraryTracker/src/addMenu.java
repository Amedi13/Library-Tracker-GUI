import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

/**
 * Add Book Menu Class
 */
 class addMenu extends JFrame implements ActionListener{

    //array list to hold the books objects
     ArrayList<books> bookList = new ArrayList<books>();


    // labels and textfields
    private JLabel author; 
    private JTextField authArea;
    private JLabel title;
    private JTextField titleArea; 
    private JLabel status; 
    private JTextField statusArea;

    //submit button
    private JButton submit;
    private JButton addAnother; 

    public addMenu() {

        setTitle("Add a new Book");
        setLayout(new FlowLayout()); 
        setSize(800, 800);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        author = new JLabel("Enter author"); 
        authArea = new JTextField(20); 
        title = new JLabel("Enter title");
        titleArea = new JTextField(20);
        status = new JLabel("Enter status");
        statusArea = new JTextField(20);

        submit = new JButton("Submit");
        submit.addActionListener(this);
        submit.setActionCommand("SUBMIT");

        addAnother = new JButton("Add another book");
        addAnother.addActionListener(this);
        addAnother.setActionCommand("ADD_ANOTHER");


        //add to  the frame
       add(author); 
       add(authArea);
       add(title); 
       add(titleArea); 
       add(status);
       add(statusArea); 
       add(submit);
       add(addAnother); 
    

    }

    @Override
    public void actionPerformed(ActionEvent e) {


        if(e.getActionCommand().equals("SUBMIT")){
            String authorInput = authArea.getText(); 
            String titleInput = titleArea.getText(); 
            String statusInput = statusArea.getText(); 

            books book = new books(authorInput, titleInput, statusInput);
            BookManager.bookList.add(book); 

            JOptionPane.showMessageDialog(this, "Book added successfully!"); 
        }

        if(e.getActionCommand().equals("ADD_ANOTHER")){
            String authorInput = authArea.getText(); 
            String titleINput = titleArea.getText(); 
            String statusInput = statusArea.getText(); 

            books book = new books(authorInput, titleINput, statusInput);
            BookManager.bookList.add(book);
            JOptionPane.showMessageDialog(this, "Book added successfully!");
            
            //add another book
            addMenu addBookMenu = new addMenu(); 
            addBookMenu.setVisible(true);
            this.dispose(); // close the current frame
        }
        
    }

    public static void main(String[] args) {

         //add menu frame
         JFrame frame = new JFrame("Add Menu");
         frame.setVisible(true);
    }
    
}
