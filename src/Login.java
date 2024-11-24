import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Login extends JFrame implements ActionListener, KeyListener{
    JPanel loginPanel = new JPanel();
    JPanel loginInputPanel = new JPanel();
    JPanel loginButtonPanel = new JPanel();
    JLabel usernameLabel = new JLabel("Benutzername:");
    JLabel passwordLabel = new JLabel("Passwort:");
    JTextField usernameField = new JTextField(20);
    JPasswordField passwordField = new JPasswordField(20);
    JButton loginButton = new JButton("Login");
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    GridLayout grid = new GridLayout(3,3);
    Color backgroundColor = new Color(79,79,79);
    Color fontColor = Color.white;

    Login() {
        this.setTitle("Bitte einloggen");

        double width = screenSize.getWidth()*0.3;
        double height = width*9/16;
        this.setSize((int) width, (int) height);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        loginPanel.setLayout(new BorderLayout());
        loginPanel.setBorder(BorderFactory.createLineBorder(backgroundColor, 20));

        loginInputPanel.setLayout(grid);
        loginInputPanel.setBackground(backgroundColor);
        usernameLabel.setForeground(fontColor);
        passwordLabel.setForeground(fontColor);
        loginInputPanel.add(usernameLabel);
        loginInputPanel.add(usernameField);
        loginInputPanel.add(passwordLabel);
        loginInputPanel.add(passwordField);

        loginButton.addActionListener(this);

        loginButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        loginButtonPanel.setBackground(backgroundColor);
        loginButtonPanel.add(loginButton);

        loginPanel.add(loginInputPanel, BorderLayout.CENTER);
        loginPanel.add(loginButtonPanel, BorderLayout.SOUTH);

        this.add(loginPanel);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Login();
    }

    public void actionPerformed(ActionEvent event) {

    }

    public void keyPressed(KeyEvent event) {
    
    }

    public void keyReleased(KeyEvent event) {

    }

    public void keyTyped(KeyEvent event) {

    }
}