import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PairsGame extends JFrame {

    public final static int FRAME_WIDTH = 800;
    public final static int FRAME_HEIGHT = 500;
    public final static int TOP_PANEL_HEIGHT = FRAME_HEIGHT / 5;
    public final static int PANEL_HEIGHT = FRAME_HEIGHT - TOP_PANEL_HEIGHT;
    public JButton okayButton;
    private int levelCount = 0;


    public PairsGame() {

        setTitle("Pairs");
        setSize(FRAME_WIDTH + 15, FRAME_HEIGHT + 40);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        setLayout(null);
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(null);
        menuPanel.setBackground(Color.BLUE);
        JTextField loginField = setStartComponents(menuPanel);
        menuPanel.setBounds(0, 0, getWidth(), getHeight() / 5);


        BoardPanel gameBoard = new BoardPanel();
        gameBoard.setBounds(0, TOP_PANEL_HEIGHT, FRAME_WIDTH, PANEL_HEIGHT);

        okayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == okayButton) {
                    String username = loginField.getText();

                    menuPanel.removeAll();
                    menuPanel.repaint();
                    JLabel usernameLabel = new JLabel("User: " + username);
                    JLabel level = new JLabel("Level: " + ++levelCount);
                    usernameLabel.setFont(new Font("Serif", Font.BOLD, 16));
                    level.setFont(new Font("Serif", Font.BOLD, 16));

                    menuPanel.add(usernameLabel).setBounds(10, 20, 100, 20);
                    menuPanel.add(level).setBounds(110, 20, 100, 20);
                    menuPanel.revalidate();
                    gameBoard.updateBoard(levelCount);
                    gameBoard.setBounds(0, TOP_PANEL_HEIGHT, FRAME_WIDTH, PANEL_HEIGHT);
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
