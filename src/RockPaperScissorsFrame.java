import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;

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
    JTextArea PlayerWinsArea;
    JLabel PWinLabel;
    JTextArea ComputerWinsArea;
    JLabel CWinLabel;
    JTextArea TieGames;
    JLabel TieLabel;
    //Win/Loss Console
    JPanel GameConsole;
    JTextArea GameConsoleArea;
    JScrollPane GameConsoleScrollPane;
    //Images
    ImageIcon Rock;
    ImageIcon Paper;
    ImageIcon Scissors;
    ImageIcon Blank;


    public RockPaperScissorsFrame() {

        //Creating the Window
        Rock = new ImageIcon("src/Asset 1.png");
        Paper = new ImageIcon("src/Asset 2.png");
        Scissors = new ImageIcon("src/Asset 3.png");
        Blank = new ImageIcon("src/Asset 4.png");

        Border BlackLine = BorderFactory.createLineBorder(Color.BLACK);
        int Width = (int) (screenSize.width * .85);
        int Height = (int) (screenSize.height * .85);
        MainPanel = new JPanel();
        MainPanel.setLayout(new BoxLayout(MainPanel, BoxLayout.X_AXIS));
        setSize(Width, Height);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Rock Paper Scissors");
        CreateGameConsole();
        add(GameConsole, BorderLayout.SOUTH);
        add(MainPanel, BorderLayout.CENTER);
        CreateTitlePanel();
        add(TitlePanel, BorderLayout.NORTH);
        CreateStatPanel();
        MainPanel.add(StatPanel);
        StatPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        CreateGamePanel();
        MainPanel.add(GamePanel);
        GamePanel.setAlignmentX(Component.RIGHT_ALIGNMENT);
        setVisible(true);

        //Button Actions
        RockButton.addActionListener((ActionEvent ae) -> GameConsoleArea.append(GameLogic("Rock")));
        PaperButton.addActionListener((ActionEvent ae) -> GameConsoleArea.append(GameLogic("Paper")));
        ScissorsButton.addActionListener((ActionEvent ae) -> GameConsoleArea.append(GameLogic("Scissors")));

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
        GamePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        GamePanel.setLayout(new BorderLayout());
        ComputerPanel = new JPanel();
        ComputerLabel = new JLabel("Computer",Blank,JLabel.CENTER);
        ComputerLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
        ComputerLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        ComputerPanel.add(ComputerLabel);
        GamePanel.add(ComputerPanel, BorderLayout.WEST);
        PlayerPanel = new JPanel();
        PlayerLabel = new JLabel("Player",Blank,JLabel.CENTER);
        PlayerLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
        PlayerLabel.setHorizontalTextPosition(SwingConstants.CENTER);
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
        GameConsole = new JPanel();
        GameConsole.setLayout(new BorderLayout());
        GameConsoleArea = new JTextArea(10,10);
        GameConsoleArea.setEditable(false);
        GameConsoleScrollPane = new JScrollPane(GameConsoleArea);
        GameConsole.add(GameConsoleScrollPane, BorderLayout.CENTER);
    }

    public void CreateStatPanel() {
        StatPanel = new JPanel();
        StatPanel.setLayout(new GridLayout(6, 1));
        PlayerWinsArea = new JTextArea(5,5);
        ComputerWinsArea = new JTextArea(5,5);
        TieGames = new JTextArea(5,5);
        PWinLabel = new JLabel("Player Wins",JLabel.CENTER);
        CWinLabel = new JLabel("Computer Wins",JLabel.CENTER);
        TieLabel = new JLabel("Tie Games",JLabel.CENTER);
        StatPanel.add(PWinLabel);
        StatPanel.add(PlayerWinsArea);
        StatPanel.add(CWinLabel);
        StatPanel.add(ComputerWinsArea);
        StatPanel.add(TieLabel);
        StatPanel.add(TieGames);
    }
    public String GameLogic(String PlayerMove) {
        String ComputerMove = GetComputerMove();
        ComputerIconChanger(ComputerMove);
        PlayerIconChanger(PlayerMove);
        if(PlayerMove.equals(ComputerMove)) {
            return (PlayerMove + " is the same as " + ComputerMove + ", Tie Game!");
        }
        //Player Wins
        if(
        (PlayerMove.equals("Rock") && ComputerMove.equals("Scissors")) ||
        (PlayerMove.equals("Scissors") && ComputerMove.equals("Paper")) ||
        (PlayerMove.equals("Paper") && ComputerMove.equals("Rock"))
        )
        {
            return (PlayerMove + " Beats " + ComputerMove + ", Player Wins!");
        }
        //ComputerWins
        else if(
        (PlayerMove.equals("Rock") && ComputerMove.equals("Paper")) ||
        (PlayerMove.equals("Paper") && ComputerMove.equals("Scissors")) ||
        (PlayerMove.equals("Scissors") && ComputerMove.equals("Rock"))
        ){
            return (ComputerMove + " Beats " + PlayerMove + ", Computer Wins!");

        }
        else{
            return ("Something went wrong!");
        }

    }
    public String GetComputerMove(){
        String ComputerMove = "";
        String[] Moves = {"Rock", "Paper", "Scissors"};
        Random Rand = new Random();
        ComputerMove = Moves[Rand.nextInt(Moves.length)];
        return ComputerMove;
    }
    public void PlayerIconChanger(String PlayerMove){
        switch (PlayerMove) {
            case "Rock" -> PlayerLabel.setIcon(Rock);
            case "Paper" -> PlayerLabel.setIcon(Paper);
            case "Scissors" -> PlayerLabel.setIcon(Scissors);
        }
    }
    public void ComputerIconChanger(String ComputerMove){
        switch (ComputerMove) {
            case "Rock" -> ComputerLabel.setIcon(Rock);
            case "Paper" -> ComputerLabel.setIcon(Paper);
            case "Scissors" -> ComputerLabel.setIcon(Scissors);
        }
    }

}
