import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PairsGame extends JFrame {

    public final static int FRAME_WIDTH = 800;
    public final static int FRAME_HEIGHT = 500;
    private final static int TOP_PANEL_HEIGHT = FRAME_HEIGHT / 5;
    public JButton okayButton;
    public boolean readyToPlay = false;
    private int levelCount = 0;


    public PairsGame() {

        setTitle("Pairs");
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(null);
        JTextField loginField = setStartComponents(menuPanel);
        menuPanel.setBounds(0, 0, getWidth(), TOP_PANEL_HEIGHT);


        BoardPanel gameBoard = new BoardPanel();
        gameBoard.setBounds(0, TOP_PANEL_HEIGHT, getWidth(), getHeight() - TOP_PANEL_HEIGHT);


        okayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == okayButton) {
                    String username = loginField.getText();
                    readyToPlay = true;

                    menuPanel.removeAll();
                    menuPanel.repaint();
                    JLabel usernameLabel = new JLabel("User: " + username);
                    JLabel level = new JLabel("Level: " + ++levelCount);
                    usernameLabel.setFont(new Font("Serif", Font.BOLD, 16));
                    level.setFont(new Font("Serif", Font.BOLD, 16));


                    menuPanel.add(usernameLabel).setBounds(10, 20, 100, 20);
                    menuPanel.add(level).setBounds(110, 20, 100, 20);
                    gameBoard.updateBoard(levelCount);
                }
            }
        });

        add(menuPanel);
        add(gameBoard);
        setVisible(true);
    }

    private JTextField setStartComponents(JPanel menuPanel) {
        JLabel welcomeMessage = new JLabel("Welcome to Pairs!");
        welcomeMessage.setFont(new Font("Serif", Font.BOLD, 20));

        JLabel loginLabel = new JLabel("Login");
        JTextField loginField = new JTextField();
        okayButton = new JButton("Ok");

        welcomeMessage.setBounds(325, 15, 200, 20);
        loginLabel.setFont(new Font("Serif", Font.BOLD, 16));
        loginLabel.setBounds(375, 45, 100, 20);
        loginField.setBounds(350, 65, 100, 20);
        okayButton.setBounds(350, 80, 100, 20);

        menuPanel.add(welcomeMessage);
        menuPanel.add(loginLabel);
        menuPanel.add(loginField);
        menuPanel.add(okayButton);
        return loginField;
    }

}
