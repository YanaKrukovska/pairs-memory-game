import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class BoardPanel extends JPanel {


    public BoardPanel() {

        setBackground(Color.WHITE);

    }


    public void updateBoard(int level) {


        if (level == 1) {
            setBounds(0, PairsGame.TOP_PANEL_HEIGHT + 2, PairsGame.FRAME_WIDTH, PairsGame.PANEL_HEIGHT);

            setLayout(new GridLayout(2, 2));
            ImageIcon cardBack = new ImageIcon("C:\\IdeaProjects\\pairs-memory-game\\src\\images\\backCard.jpg");
            ImageIcon level1Icon1 = new ImageIcon("C:\\IdeaProjects\\pairs-memory-game\\src\\images\\cake1.jpg");
            ImageIcon level1Icon2 = new ImageIcon("C:\\IdeaProjects\\pairs-memory-game\\src\\images\\cake2.jpg");
            ImageIcon level1Icon3 = new ImageIcon("C:\\IdeaProjects\\pairs-memory-game\\src\\images\\cake1.jpg");
            ImageIcon level1Icon4 = new ImageIcon("C:\\IdeaProjects\\pairs-memory-game\\src\\images\\cake2.jpg");
            Image image1 = level1Icon1.getImage();
            Image image2 = level1Icon2.getImage();
            Image image3 = level1Icon3.getImage();
            Image image4 = level1Icon4.getImage();
            level1Icon1 = new ImageIcon(image1);
            level1Icon2 = new ImageIcon(image2);
            level1Icon3 = new ImageIcon(image3);
            level1Icon4 = new ImageIcon(image4);
            JLabel level1Label1 = new JLabel(level1Icon1);
            JLabel level1Label2 = new JLabel(level1Icon2);
            JLabel level1Label3 = new JLabel(level1Icon3);
            JLabel level1Label4 = new JLabel(level1Icon4);

            Timer showCardsTimer = new Timer(1500, new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    level1Label1.setIcon(cardBack);
                    level1Label2.setIcon(cardBack);
                    level1Label3.setIcon(cardBack);
                    level1Label4.setIcon(cardBack);
                }
            });
            showCardsTimer.setRepeats(false);
            showCardsTimer.start();


            add(level1Label1);
            add(level1Label2);
            add(level1Label3);
            add(level1Label4);

            revalidate();




        }

    }

}
