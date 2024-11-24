import javax.swing.JButton;
import javax.swing.JFrame;

public class Launcher extends JFrame {

    Launcher(){
        this.setTitle("Info-AG");
        this.setSize(512, 512);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Launcher();
    }
}