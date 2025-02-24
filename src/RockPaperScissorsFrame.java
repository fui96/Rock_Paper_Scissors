import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;

public class RockPaperScissorsFrame extends JFrame {
    Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension screenSize = tk.getScreenSize();

    //Panels

    JPanel MainPanel,TitlePanel, MiddlePanel,GameContainer,ComputerPanel,PlayerPanel,ButtonPanel,StatPanel,GameConsole;
    //Labels
    JLabel TitleLabel,ComputerLabel,PlayerLabel, PWinLabel, CWinLabel, TieLabel;
    //Buttons
    JButton RockButton,PaperButton,ScissorsButton,QuitButton;
    //TextAreas
    JTextArea GameConsoleArea;
    JScrollPane GameConsoleScrollPane;
    //Images
    ImageIcon Rock,Paper,Scissors,Blank;

    int ComputerScore,PlayerScore,Ties = 0;

    /**
     * Main constructor for the frame and contains button events
     */
    public RockPaperScissorsFrame() {



        //Images
        Rock = new ImageIcon("src/Asset 1.png");
        Paper = new ImageIcon("src/Asset 2.png");
        Scissors = new ImageIcon("src/Asset 3.png");
        Blank = new ImageIcon("src/Asset 4.png");

        //Create Window
        setLayout(new BorderLayout());
        setTitle("Rock Paper Scissors");
        int Width = (int) (screenSize.width * .75);
        int Height = (int) (screenSize.height * .75);
        setSize(Width,Height);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        //Create Panels
        CreateTitlePanel();
        CreateMiddlePanel();
        CreateStatPanel();
        CreateGameConsole();


        MainPanel = new JPanel();
        add(MainPanel);
        MainPanel.setLayout(new BorderLayout());
        MainPanel.add(TitlePanel,BorderLayout.NORTH);
        MainPanel.add(MiddlePanel,BorderLayout.CENTER);
        MainPanel.add(GameConsole,BorderLayout.SOUTH);
        GameContainer.add(GameConsole);


        setVisible(true);

        //Button Actions
        RockButton.addActionListener((ActionEvent ae) -> GameConsoleArea.append(GameLogic("Rock")));
        PaperButton.addActionListener((ActionEvent ae) -> GameConsoleArea.append(GameLogic("Paper")));
        ScissorsButton.addActionListener((ActionEvent ae) -> GameConsoleArea.append(GameLogic("Scissors")));

    }

    //Methods

    /**
     * Creates and structures the title for the window
     */
    public void CreateTitlePanel(){
        TitlePanel = new JPanel();
        TitleLabel = new JLabel("Rock Paper Scissors");
        TitleLabel.setFont(new Font("Serif", Font.BOLD, 28));
        TitlePanel.add(TitleLabel);

    }

    /**
     * Creates and structures the GameArea nested in the Middle pane
     */
    public void CreateMiddlePanel() {
        MiddlePanel = new JPanel();
        MiddlePanel.setLayout(new BorderLayout());


        GameContainer = new JPanel();
        GameContainer.setLayout(new GridLayout(2,2));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);
        //Computer Panel
        ComputerPanel = new JPanel();
        ComputerLabel = new JLabel("Computer",Blank,JLabel.CENTER);
        ComputerLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
        ComputerLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        ComputerPanel.add(ComputerLabel);


        //Player Panel
        PlayerPanel = new JPanel();
        PlayerLabel = new JLabel("Player",Blank,JLabel.CENTER);
        PlayerLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
        PlayerLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        PlayerPanel.add(PlayerLabel);


        //Button Panel
        ButtonPanel = new JPanel();
        ButtonPanel.setLayout(new GridLayout(1, 3));
        RockButton = new JButton("Rock");
        PaperButton = new JButton("Paper");
        ScissorsButton = new JButton("Scissors");
        ButtonPanel.add(RockButton);
        ButtonPanel.add(PaperButton);
        ButtonPanel.add(ScissorsButton);


        gbc.gridx = 0;
        GameContainer.add(ComputerPanel,gbc);

        GameContainer.add(PlayerPanel,gbc.gridx = 2, gbc.gridy = 0);
        GameContainer.add(ButtonPanel,gbc.gridx = -1,gbc.gridy = 2);


        MiddlePanel.add(GameContainer,BorderLayout.CENTER);
    }

    /**
     * Creates and structures the GameConsole pane
     */
    public void CreateGameConsole() {
        GameConsole = new JPanel();
        GameConsole.setLayout(new BorderLayout());
        GameConsoleArea = new JTextArea(5,5);
        GameConsoleArea.setEditable(false);
        GameConsoleScrollPane = new JScrollPane(GameConsoleArea);
        GameConsole.add(GameConsoleScrollPane, BorderLayout.CENTER);
        GameConsoleScrollPane.setBorder(BorderFactory.createLineBorder(Color.black));
    }

    /**
     * Creates and structures the Stats Panel
     */
    public void CreateStatPanel() {
        StatPanel = new JPanel();
        StatPanel.setLayout(new GridLayout(4, 1));
        PWinLabel = new JLabel(("Player Wins: " + PlayerScore),JLabel.CENTER);
        CWinLabel = new JLabel(("Computer Wins: " + ComputerScore),JLabel.CENTER);
        TieLabel = new JLabel(("Tie Games: " + Ties),JLabel.CENTER);
        PWinLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        CWinLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        TieLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        QuitButton = new JButton("Quit");
        QuitButton.addActionListener((ActionEvent ae) -> System.exit(0));
        StatPanel.add(PWinLabel);
        StatPanel.add(CWinLabel);
        StatPanel.add(TieLabel);
        StatPanel.add(QuitButton);
        MiddlePanel.add(StatPanel,BorderLayout.WEST);
    }

    /**
     * Determines the winner of the game based on the players move
     * @param PlayerMove the move selected by the user
     * @return a string to append the GameConsoleScrollArea
     */
    public String GameLogic(String PlayerMove) {
        String ComputerMove = GetComputerMove();
        ComputerIconChanger(ComputerMove);
        PlayerIconChanger(PlayerMove);
        if(PlayerMove.equals(ComputerMove)) {
            Ties++;
            TieLabel.setText("Ties: " + Ties);
            return (PlayerMove + " is the same as " + ComputerMove + ", Tie Game!\n");
        }
        //Player Wins
        if(
        (PlayerMove.equals("Rock") && ComputerMove.equals("Scissors")) ||
        (PlayerMove.equals("Scissors") && ComputerMove.equals("Paper")) ||
        (PlayerMove.equals("Paper") && ComputerMove.equals("Rock"))
        )
        {
            PlayerScore++;
            PWinLabel.setText("Player Wins: " + PlayerScore);
            return (PlayerMove + " Beats " + ComputerMove + ", Player Wins!\n");
        }
        //ComputerWins
        else if(
        (PlayerMove.equals("Rock") && ComputerMove.equals("Paper")) ||
        (PlayerMove.equals("Paper") && ComputerMove.equals("Scissors")) ||
        (PlayerMove.equals("Scissors") && ComputerMove.equals("Rock"))
        ){
            ComputerScore++;
            CWinLabel.setText("Computer Wins: " + ComputerScore);
            return (ComputerMove + " Beats " + PlayerMove + ", Computer Wins!\n");

        }
        else{
            return ("Something went wrong!");
        }

    }

    /**
     * randomly selects the computers move
     * @return a string that is the random computer move
     */
    public String GetComputerMove(){
        String ComputerMove = "";
        String[] Moves = {"Rock", "Paper", "Scissors"};
        Random Rand = new Random();
        ComputerMove = Moves[Rand.nextInt(Moves.length)];
        return ComputerMove;
    }

    /**
     * changes the icon in the player label
     * @param PlayerMove uses the player move to decide which icon to change it to
     */
    public void PlayerIconChanger(String PlayerMove){
        switch (PlayerMove) {
            case "Rock" -> PlayerLabel.setIcon(Rock);
            case "Paper" -> PlayerLabel.setIcon(Paper);
            case "Scissors" -> PlayerLabel.setIcon(Scissors);
        }
    }

    /**
     * changes the icon for the computer label
     * @param ComputerMove uses the computers move to decide the icon to change it to
     */
    public void ComputerIconChanger(String ComputerMove){
        switch (ComputerMove) {
            case "Rock" -> ComputerLabel.setIcon(Rock);
            case "Paper" -> ComputerLabel.setIcon(Paper);
            case "Scissors" -> ComputerLabel.setIcon(Scissors);
        }
    }

}
