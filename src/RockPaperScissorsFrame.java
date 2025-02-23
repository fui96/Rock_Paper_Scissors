import javax.swing.*;
import java.awt.*;
public class RockPaperScissorsFrame extends JFrame {
    Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension screenSize = tk.getScreenSize();

    //Panels
    //Title Panel
    JPanel TitlePanel;
    //Main Panel
    JPanel MainPanel;
    //Game Window
    JPanel GamePanel;
    JPanel ComputerPanel;
    JPanel PlayerPanel;
    JLabel ComputerLabel;
    JLabel PlayerLabel;
    //Stat Panel
    JPanel StatPanel;
    //Win/Loss Console
    JPanel GameConsole;


    public RockPaperScissorsFrame() {
        int Width = (int) (screenSize.width * .85);
        int Height = (int) (screenSize.height * .85);
        MainPanel = new JPanel();
        setSize(Width, Height);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Rock Paper Scissors");
        setLayout(new BorderLayout());
        setBackground(Color.BLACK);

        add(MainPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    //Methods
    public void CreateGamePanel() {

    }
    public void CreateGameConsole() {

    }

    public void CreateStatPanel() {

    }

    public String GameLogic() {
    }
    public String MoveChoice(){

    }


}
