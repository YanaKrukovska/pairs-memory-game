import javax.swing.*;
import java.awt.*;


public class BoardPanel extends JPanel {

    private JLabel card1 = new JLabel("Card 1");
    private JLabel card2 = new JLabel("Card 2");
    private JLabel card3 = new JLabel("Card 3");
    private JLabel card4 = new JLabel("Card 4");


    public BoardPanel() {

        setBackground(Color.WHITE);

    }


    public void updateBoard(int level) {
        if (level == 1) {

            setLayout(new GridLayout(2, 3));
            ImageIcon level1Icon1 = new ImageIcon("C:\\IdeaProjects\\pairs-memory-game\\src\\images\\cake1.jpg");
            ImageIcon level1Icon2 = new ImageIcon("C:\\IdeaProjects\\pairs-memory-game\\src\\images\\cake2.jpg");
            Image image1 = level1Icon1.getImage();
            Image image2 = level1Icon2.getImage();
            level1Icon1 = new ImageIcon(image1);
            level1Icon2 = new ImageIcon(image2);
            JLabel level1Label1 = new JLabel(level1Icon1);
            JLabel level1Label2 = new JLabel(level1Icon2);


            add(level1Label1);
            add(level1Label2);
            add(card3);
            add(card4);


        }

    }


}
