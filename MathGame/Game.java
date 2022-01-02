
import javax.swing.ImageIcon;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Desktop;
import javax.swing.*;

public class Game {

    private static int Points = 0;
    private static String reword;

    private static JTextArea ta, ta1;
    private static JTextArea name;
    private static JTextField enterName;

    private static JButton TRUE;
    private static JButton FALSE;

    private JFrame frameStart, frameGame;
    private Container conStart, conGame;
    private JPanel titleNamePanel, startButtonPanel, GamePanelFoot, GamePanelMain1, GamePanelMain2,
            GamePanelButtons;
    private JLabel titleNameLabel;
    private Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
    private Font normalFont = new Font("Times New Roman", Font.PLAIN, 28);
    private Font mainFont = new Font("Times New Roman", Font.PLAIN, 50);
    private JButton startButton, LinkinButton, GithubButton, WebsiteButton;
    private ImageIcon port1 = new ImageIcon("/img/port1.png");

    ScreenHandler StartButton = new ScreenHandler();
    GithubButtonAction GitButton = new GithubButtonAction();
    WebsiteButtonAction WebButton = new WebsiteButtonAction();
    LinkInButtonAction LinButton = new LinkInButtonAction();

    public class ScreenHandler implements ActionListener{
        public void actionPerformed(ActionEvent event){
            NodeMap map = new NodeMap();
            if(map.currentNode() == null) { return;}
            StartGame(map);
        }
    }


    public Game(){
        frameStart = new JFrame("Maliq 'UP962567' Dyrma");
        frameStart.setSize(800, 600);
        frameStart.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameStart.getContentPane().setBackground(Color.black);
        frameStart.setLayout(null);
        frameStart.setResizable(false);
        frameStart.setLocationRelativeTo(null);
        conStart = frameStart.getContentPane();

        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100, 100, 600, 150);
        titleNamePanel.setBackground(Color.black);
        titleNameLabel = new JLabel("Smart Games!");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titleFont);

        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300, 350, 200, 100);
        startButtonPanel.setLayout(new GridLayout(2,1));
        startButtonPanel.setBackground(Color.black);
        enterName = new JTextField("Player1");
        enterName.setBackground(Color.black);
        enterName.setForeground(Color.white);
        enterName.setFont(normalFont);

        startButton = new JButton("START");
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.white);
        startButton.setFont(normalFont);
        startButton.addActionListener(StartButton);
        startButton.setFocusPainted(false);

        titleNamePanel.add(titleNameLabel);
        startButtonPanel.add(enterName);
        startButtonPanel.add(startButton);

        conStart.add(titleNamePanel);
        conStart.add(startButtonPanel);

        frameStart.setVisible(true);
    }
    public Game(NodeMap map) {StartGame(map);nodeDisplay(map);}
    private void StartGame(NodeMap map) {

        frameStart.setVisible(false);
        // Frame
        frameGame = new JFrame("Maliq 'UP962567' Dyrma");
        frameGame.setSize(800, 600);
        frameGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameGame.getContentPane().setBackground(Color.black);
        frameGame.setLayout(null);
        frameGame.setResizable(false);
        frameGame.setLocationRelativeTo(null);

        conGame = frameGame.getContentPane();
        //
        createButtons(map);
//        createTextArea();
        // Foot Panel
        GamePanelFoot = new JPanel();
        GamePanelFoot.setBackground(Color.black);
        GamePanelFoot.setBounds(0, 500, 785, 40);
        GamePanelFoot.setLayout(new GridLayout(1,3));
        // Buttons Foot
        LinkinButton = new JButton("LinkIn");
        LinkinButton.setBackground(Color.black);
        LinkinButton.setForeground(Color.white);
        LinkinButton.setFont(normalFont);
        LinkinButton.addActionListener(LinButton);
        LinkinButton.setFocusPainted(false);
        GithubButton = new JButton("GitHub");
        GithubButton.setBackground(Color.black);
        GithubButton.setForeground(Color.white);
        GithubButton.setFont(normalFont);
        GithubButton.addActionListener(GitButton);
        GithubButton.setFocusPainted(false);
        WebsiteButton = new JButton("WebSite");
        WebsiteButton.setBackground(Color.black);
        WebsiteButton.setForeground(Color.white);
        WebsiteButton.setFont(normalFont);
        WebsiteButton.addActionListener(WebButton);
        WebsiteButton.setFocusPainted(false);
        GamePanelFoot.add(LinkinButton);
        GamePanelFoot.add(WebsiteButton);
        GamePanelFoot.add(GithubButton);


        // Main Panels
        GamePanelMain1 = new JPanel();
        GamePanelMain1.setBackground(Color.black);
        GamePanelMain1.setBounds(150,150,500,200);
        ta = new JTextArea("          Welcome!" +
                "\n I hope you are ready for this task!" +
                "\n To see that you understand how to use the game " +
                "\n Press anything to start it!");
        ta.setBounds(150,150,500,200);
        ta.setLineWrap(true);
        ta.setWrapStyleWord(true);
        ta.setEditable(false);
        ta.setFont(createFont(20));
        ta.setBackground(Color.BLACK);
        ta.setForeground(Color.white);
        GamePanelMain1.add(ta);

        GamePanelMain2 = new JPanel();
        GamePanelMain2.setBackground(Color.black);
        GamePanelMain2.setBounds(50,20,680,50);
        GamePanelMain2.setLayout(new GridLayout(1, 2));
        name = new JTextArea("Player name: " + enterName.getText());
        name.setLineWrap(true);
        name.setWrapStyleWord(true);
        name.setEditable(false);
        name.setFont(createFont(20));
        name.setBackground(Color.BLACK);
        name.setForeground(Color.green);
        GamePanelMain2.add(name);
        ta1 = new JTextArea("Your Points: 0");
        ta1.setLineWrap(true);
        ta1.setWrapStyleWord(true);
        ta1.setEditable(false);
        ta1.setFont(createFont(20));
        ta1.setBackground(Color.BLACK);
        ta1.setForeground(Color.red);
        GamePanelMain2.add(ta1);




        // Game Button Panel
        GamePanelButtons = new JPanel();
        GamePanelButtons.setBackground(Color.black);
        GamePanelButtons.setBounds(50,350,700,75);
        GamePanelButtons.setLayout(new GridLayout(2, 1));

        // Game Buttons
        GamePanelButtons.add(TRUE);
        GamePanelButtons.add(FALSE);

        // To add in Frame
        conGame.add(GamePanelButtons);
        conGame.add(GamePanelMain2);
        conGame.add(GamePanelMain1);
        conGame.add(GamePanelFoot);
        frameGame.setVisible(true);
    }
    // More Futures

    // Default
    private static void createButtons(NodeMap map){
        TRUE = new JButton("TRUE");
        TRUE.setFont(createFont(25));
        TRUE.setBackground(Color.black);
        TRUE.setForeground(Color.white);
        TRUE.addActionListener((ActionEvent e) -> {
            move(map,1);
            nodeDisplay(map);
        });;

        FALSE = new JButton("FALSE");
        FALSE.setFont(createFont(25));
        FALSE.setBackground(Color.black);
        FALSE.setForeground(Color.white);
        FALSE.addActionListener((ActionEvent e) -> {
            move(map,2);
            nodeDisplay(map);
        });
    }
/****************************************************/
/**************      NAVIGATE       *****************/
/****************************************************/
/*** @return
 * @return*****************************************/
    private static String PointRect(){
        if(Points < 5) {
            reword = "Your need to work more!";
        }
        if (Points >= 5){
            reword = "Your are good! But need some work!";
        }
        if(Points >= 10) {
            reword = "Your are Amazing!";
        }
        if(Points == 15) {
            reword = "Your are a MONSTER in this game!!!!";
        }
        return reword;
    }

    private static void move(NodeMap map, int direction){
        if (map.currentNode().getQuestion().equals("-")) {map.noDecision();}
        else {map.decision(direction);}
    }


    private static void nodeDisplay(NodeMap map){
        ta.setText( map.currentNode().getDescription() + "\n");
        ta.append(map.currentNode().getQuestion() + "\n");
        if (map.currentNode().getQuestion().equals("*") ){
            TRUE.setText("Continue");
            FALSE.setVisible(false);
        }
        else if (map.currentNode().getQuestion().equals("/") ){
            ta.setText( map.currentNode().getDescription()
                    + "\n" + "Your points are: " + Points
                    + "\n" + PointRect());
            TRUE.setVisible(false);
            FALSE.setVisible(false);
        }
        else {
            TRUE.setText("TRUE");
            TRUE.setVisible(true);
            FALSE.setText("FALSE");
            FALSE.setVisible(true);
        }

        if (map.currentNode().getActionID().equals("-")) {
            Points -= 1;
            System.out.println(Points);
            ta1.setText("Your Points: " + Points);
        }
        else if (map.currentNode().getActionID().equals("+")) {
            Points += 1;
            System.out.println(Points);
            ta1.setText("Your Points: " + Points);
        }
    }



    /***************************************************/
    /*                      HELPERS                    */
    /***************************************************/
    private static Font createFont(int size){
        return  new Font("Courier", Font.PLAIN,size);
        //return  new Font("Atlantis International", Font.PLAIN,size);
    }
    // Links

    class GithubButtonAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            try {
                String url = "https://github.com/UP962567/";
                Desktop.getDesktop().browse(java.net.URI.create(url));
            } catch (java.io.IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    class WebsiteButtonAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            try {
                String url = "https://www.ma-dy.com/";
                Desktop.getDesktop().browse(java.net.URI.create(url));
            } catch (java.io.IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    class LinkInButtonAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            try {
                String url = "https://www.linkedin.com/in/maliqdyrma";
                Desktop.getDesktop().browse(java.net.URI.create(url));
            } catch (java.io.IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }


}
