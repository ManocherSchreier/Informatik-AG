import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
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
import java.awt.Font;


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
    Color backgroundColor = new Color(60,60,60);
    Color fieldColor = new Color(79, 79, 79);
    Color fontColor = new Color(227, 227, 227);
    Font labelFont = new Font("Arial", Font.BOLD, 15);
    Font buttonFont = new Font("Arial", Font.BOLD, 13);
    Font fieldFont = new Font("Arial", Font.PLAIN, 15); 
    String checkUsername = System.getenv("LOGIN_USERNAME");
    String checkPassword = System.getenv("LOGIN_PASSWORD");
    String appIconPath = System.getenv("PATH_APPICON");
    ImageIcon appIcon = new ImageIcon(appIconPath);
    Login() {
        this.setTitle("Bitte einloggen");
        double width = screenSize.getWidth()*0.3;
        double height = width*9/16;
        this.setSize((int) width, (int) height);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setIconImage(appIcon.getImage());

        loginPanel.setLayout(new BorderLayout());
        loginPanel.setBorder(BorderFactory.createLineBorder(backgroundColor, 20));

        usernameLabel.setForeground(fontColor);
        usernameLabel.setFont(labelFont);

        passwordLabel.setForeground(fontColor);
        passwordLabel.setFont(labelFont);
        
        loginInputPanel.setBackground(backgroundColor);
        loginInputPanel.setLayout(grid);
        loginInputPanel.add(usernameLabel);
        loginInputPanel.add(usernameField);
        loginInputPanel.add(passwordLabel);
        loginInputPanel.add(passwordField);

        usernameField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, fontColor));
        usernameField.setFont(fieldFont);
        usernameField.setBackground(fieldColor);
        usernameField.setForeground(fontColor);
        usernameField.setCaretColor(fontColor);;

        passwordField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, fontColor));
        passwordField.addKeyListener(this);
        passwordField.setFont(fieldFont);
        passwordField.setBackground(fieldColor);
        passwordField.setForeground(fontColor);
        passwordField.setCaretColor(fontColor);

        loginButton.setPreferredSize(new Dimension(190, 45));
        loginButton.setBackground(fieldColor);
        loginButton.setForeground(new Color(220,220,220));
        loginButton.addActionListener(this);
        loginButton.setFont(buttonFont);
        loginButton.setFocusable(false);
        loginButton.setRolloverEnabled(false);

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
        
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        
        if (username.equals("") || password.equals("")) {
            JOptionPane.showMessageDialog(null, "Bitte füllen sie alle Felder aus!", "Bitte ausfüllen", JOptionPane.ERROR_MESSAGE);
        }
        else if(username.equals(checkUsername) && password.equals(checkPassword)){
            JOptionPane.showMessageDialog(null, "Erfolgreich eingeloggt", "Erfolgreiche Anmeldung", JOptionPane.INFORMATION_MESSAGE);
            Launcher launcher = new Launcher();
            launcher.setVisible(true);
            this.dispose();
        }
        else {
            JOptionPane.showMessageDialog(null, "Falscher Benutzername oder falsches Passwort!", "Fehler", JOptionPane.ERROR_MESSAGE);
            usernameField.setText("");
            passwordField.setText("");
        }
    }

    public void keyPressed(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.VK_ENTER){
            loginButton.doClick();
        }

    }

    public void keyReleased(KeyEvent event) {

    }

    public void keyTyped(KeyEvent event) {

    }
}