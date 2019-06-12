import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {

    private JTextField loginField;
    private JButton okayButton;
    private JLabel levelLabel;
    private String username;

    public MenuPanel() {
        setLayout(null);
        loginField = setStartComponents();
    }

    private JTextField setStartComponents() {
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

        add(welcomeMessage);
        add(loginLabel);
        add(loginField);
        add(okayButton);
        return loginField;
    }


    public JButton getOkayButton() {
        return okayButton;
    }

    public void updateMenu(int currentLevel) {

        remove(levelLabel);
        repaint();
        levelLabel = new JLabel("Level: " + currentLevel);
        levelLabel.setFont(new Font("Serif", Font.PLAIN, 16));

        add(levelLabel).setBounds((username.length()*20) + 10, 20, 100, 20);

        repaint();
    }

    public void generateMenu(int currentLevel) {
        username = loginField.getText();

        JLabel usernameLabel = new JLabel("User: " + username);
        usernameLabel.setFont(new Font("Serif", Font.PLAIN, 16));
        levelLabel = new JLabel("Level: " + currentLevel);
        levelLabel.setFont(new Font("Serif", Font.PLAIN, 16));

        add(usernameLabel).setBounds(10, 20, username.length()*20, 20);
        add(levelLabel).setBounds((username.length()*20) + 10, 20, 100, 20);

        repaint();
        revalidate();
    }

    public void finalUpdate() {
        removeAll();
        repaint();
        revalidate();
    }
}
