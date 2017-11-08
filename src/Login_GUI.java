import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login_GUI {
    //Declare a frame from the window.
    private JFrame frame;
    //Declare a textfield for username
    private JTextField userNameField;
    //Declare a textfield for password
    private JPasswordField passwordField;
    //Declare label for username;
    private JLabel userNameLbl;
    //Declare label for password
    private JLabel passwordLbl;
    //Declare a jbutton to connect.
    private JButton btnConnect;

    //Constructor
    public Login_GUI() {
    initialize();
    }
    //the initialize method that builds the window
    private void initialize(){
        //creates the frame/window
        frame = new JFrame("Login");
        frame.setBounds(500,500,450, 300);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        //Create userfield
        userNameField = new JTextField();
        userNameField.setBounds(156,56,203,26);
        frame.getContentPane().add(userNameField);
        userNameField.setColumns(10);

        //Create password field
        passwordField = new JPasswordField();
        passwordField.setEchoChar('*');
        passwordField.setBounds(156,107,203,26);
        frame.getContentPane().add(passwordField);

        //Create user label
        userNameLbl = new JLabel("Username");
        userNameLbl.setBounds(57,61,87,16);
        frame.getContentPane().add(userNameLbl);

        //Create password label
        passwordLbl = new JLabel("Password");
        passwordLbl.setBounds(63,112,87,16);
        frame.getContentPane().add(passwordLbl);

        //Create connect button
        btnConnect = new JButton("Connect");
        btnConnect.setBounds(148, 172,117,29);
        frame.getContentPane().add(btnConnect);

        //Create button action
        btnConnect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DB_Statements stat = new DB_Statements();
                try {
                    String username = userNameField.getText();
                    String password = new String(passwordField.getPassword());
                    if (stat.checkLogin(username, password)) {
                        JOptionPane.showMessageDialog(null,"User found\n Access granted.");
                        frame.setVisible(false);
                    }else {JOptionPane.showMessageDialog(null,"User not found. \n Git gud scrub, Access Denied."); }
                }
                catch (Exception ex){
                JOptionPane.showMessageDialog(null,ex);
                }
            }
        });
        frame.setVisible(true);
    }













}
