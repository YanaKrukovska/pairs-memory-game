
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class MenuPanel extends JPanel {

    private JTextField loginField;
    private JButton okayButton;
    private JLabel levelLabel;
    private String username;

    Image fon = new ImageIcon("C:\\Users\\Марія\\Documents\\Лабораторна_Синельник\\Memory Game\\fon.jpg").getImage();


    public MenuPanel() {
        setLayout(null);
        loginField = setStartComponents();
    }

    private JTextField setStartComponents() {
        JLabel welcomeMessage = new JLabel("Welcome to Pairs!");
        welcomeMessage.setFont(new Font("Serif", Font.BOLD, 30));
        welcomeMessage.setForeground(Color.BLUE);

        JLabel loginLabel = new JLabel("Login");
        JTextField loginField = new JTextField();
        okayButton = new JButton("Ok");

        JButton buttonSound = new JButton("S");
        buttonSound.setBounds(700, 10, 50, 30);
        buttonSound.setFocusable(false);
        ActionListener actionListener = new ButtonPushActionListener();
        buttonSound.addActionListener(actionListener);


        welcomeMessage.setBounds(300, 15, 400, 20);
        loginLabel.setFont(new Font("Serif", Font.BOLD, 16));
        loginLabel.setBounds(375, 45, 100, 20);
        loginField.setBounds(350, 65, 100, 20);
        okayButton.setBounds(350, 80, 100, 20);

        add(welcomeMessage);
        add(loginLabel);
        add(loginField);
        add(buttonSound);
        return loginField;
    }

    private class ButtonPushActionListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            try
            {
                File soundFile = new File("C:\\Users\\Марія\\Documents\\Лабораторна_Синельник\\Memory Game\\sounds.wav");
                AudioInputStream inAudio = AudioSystem.getAudioInputStream(soundFile);
                Clip clip = AudioSystem.getClip();
                clip.open(inAudio);
                clip.setFramePosition(0);

                FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                gainControl.setValue((float) -20.0);
                clip.start();
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            }
            catch (Exception e1)
            {
                System.out.println("You have a problem with audio file!!");
            }
        }
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(fon != null){
            g.drawImage(fon, 0, 0, getWidth(), getHeight(), null);
        }
    }


    public JButton getOkayButton() {
        return okayButton;
    }

    public void updateMenu(int currentLevel) {

        remove(levelLabel);
        repaint();
        levelLabel = new JLabel("Level: " + currentLevel);
        levelLabel.setFont(new Font("Serif", Font.PLAIN, 16));

        add(levelLabel).setBounds((usernameLabelLength()) + 10, 20, 100, 20);

        repaint();
    }

    public void generateMenu(int currentLevel) {
        username = loginField.getText();

        JLabel usernameLabel = new JLabel("User: " + username);
        usernameLabel.setFont(new Font("Serif", Font.PLAIN, 16));
        levelLabel = new JLabel("Level: " + currentLevel);
        levelLabel.setFont(new Font("Serif", Font.PLAIN, 16));

        add(usernameLabel).setBounds(10, 20, usernameLabelLength(), 20);
        add(levelLabel).setBounds(usernameLabelLength() + 10, 20, 100, 20);

        repaint();
        revalidate();
    }

    private int usernameLabelLength() {
        return username.length() * 20;
    }

    public void finalUpdate() {
        removeAll();
        repaint();
        revalidate();
    }
}

