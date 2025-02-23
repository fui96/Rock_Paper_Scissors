import javax.swing.*;
import java.awt.*;
public class RockPaperScissorsFrame extends JFrame {
    Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension screenSize = tk.getScreenSize();

    //Panels
    //Title Panel
    JPanel TitlePanel;
    JLabel TitleLabel;
    //Main Panel
    JPanel MainPanel;
    //Game Window
    JPanel GamePanel;
    JPanel ComputerPanel;
    JPanel PlayerPanel;
    JPanel ButtonPanel;
    JLabel ComputerLabel;
    JLabel PlayerLabel;
    JButton RockButton;
    JButton PaperButton;
    JButton ScissorsButton;
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
        CreateTitlePanel();
        add(TitlePanel, BorderLayout.NORTH);
        CreateGamePanel();
        MainPanel.add(GamePanel, BorderLayout.SOUTH);


        setVisible(true);
    }

    //Methods
    public void CreateTitlePanel(){
        TitlePanel = new JPanel();
        TitleLabel = new JLabel("Rock Paper Scissors");
        TitleLabel.setFont(new Font("Serif", Font.BOLD, 28));
        TitlePanel.add(TitleLabel);

    }
    public void CreateGamePanel() {
        GamePanel = new JPanel();
        GamePanel.setLayout(new BorderLayout());
        ComputerPanel = new JPanel();
        ComputerLabel = new JLabel("Computer");
        ComputerPanel.add(ComputerLabel);
        GamePanel.add(ComputerPanel, BorderLayout.WEST);
        PlayerPanel = new JPanel();
        PlayerLabel = new JLabel("Player");
        PlayerPanel.add(PlayerLabel);
        GamePanel.add(PlayerPanel, BorderLayout.EAST);
        ButtonPanel = new JPanel();
        ButtonPanel.setLayout(new GridLayout(1, 3));
        GamePanel.add(ButtonPanel, BorderLayout.SOUTH);
        RockButton = new JButton("Rock");
        PaperButton = new JButton("Paper");
        ScissorsButton = new JButton("Scissors");
        ButtonPanel.add(RockButton);
        ButtonPanel.add(PaperButton);
        ButtonPanel.add(ScissorsButton);

    }
    public void CreateGameConsole() {

    }

    public void CreateStatPanel() {

    }
    /*
    public String GameLogic() {

    }
    public String MoveChoice(){

    }
     */


}
