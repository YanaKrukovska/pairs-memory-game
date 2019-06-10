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
            ImageIcon level1Icon1 = new ImageIcon("C:\\Users\\Марія\\Documents\\Лабораторна_Синельник\\Memory Game\\cake1.jpg");
            ImageIcon level1Icon2 = new ImageIcon("C:\\Users\\Марія\\Documents\\Лабораторна_Синельник\\Memory Game\\cake2.jpg");
            ImageIcon level1Icon3 = new ImageIcon("C:\\Users\\Марія\\Documents\\Лабораторна_Синельник\\Memory Game\\cake1.jpg");
            ImageIcon level1Icon4 = new ImageIcon("C:\\Users\\Марія\\Documents\\Лабораторна_Синельник\\Memory Game\\cake2.jpg");

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

        if (level == 2) {
            setBounds(0, PairsGame.TOP_PANEL_HEIGHT + 2, PairsGame.FRAME_WIDTH, PairsGame.PANEL_HEIGHT);

            setLayout(new GridLayout(3, 3));
            ImageIcon cardBack = new ImageIcon("C:\\IdeaProjects\\pairs-memory-game\\src\\images\\backCard.jpg");
            ImageIcon level2Icon1 = new ImageIcon("C:\\Users\\Марія\\Documents\\Лабораторна_Синельник\\Memory Game\\espresso.jpg");
            ImageIcon level2Icon2 = new ImageIcon("C:\\Users\\Марія\\Documents\\Лабораторна_Синельник\\Memory Game\\kakao.jpg");
            ImageIcon level2Icon3 = new ImageIcon("C:\\Users\\Марія\\Documents\\Лабораторна_Синельник\\Memory Game\\latte1.jpg");
            ImageIcon level2Icon4 = new ImageIcon("C:\\Users\\Марія\\Documents\\Лабораторна_Синельник\\Memory Game\\espresso.jpg");
            ImageIcon level2Icon5 = new ImageIcon("C:\\Users\\Марія\\Documents\\Лабораторна_Синельник\\Memory Game\\kakao.jpg");
            ImageIcon level2Icon6 = new ImageIcon("C:\\Users\\Марія\\Documents\\Лабораторна_Синельник\\Memory Game\\latte1.jpg");

            Image image1 = level2Icon1.getImage();
            Image image2 = level2Icon2.getImage();
            Image image3 = level2Icon3.getImage();
            Image image4 = level2Icon4.getImage();
            Image image5 = level2Icon5.getImage();
            Image image6 = level2Icon6.getImage();

            level2Icon1 = new ImageIcon(image1);
            level2Icon2 = new ImageIcon(image2);
            level2Icon3 = new ImageIcon(image3);
            level2Icon4 = new ImageIcon(image4);
            level2Icon5 = new ImageIcon(image5);
            level2Icon6 = new ImageIcon(image6);

            JLabel level2Label1 = new JLabel(level2Icon1);
            JLabel level2Label2 = new JLabel(level2Icon2);
            JLabel level2Label3 = new JLabel(level2Icon3);
            JLabel level2Label4 = new JLabel(level2Icon4);
            JLabel level2Label5 = new JLabel(level2Icon5);
            JLabel level2Label6 = new JLabel(level2Icon6);

            Timer showCardsTimer = new Timer(1500, new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    level2Label1.setIcon(cardBack);
                    level2Label2.setIcon(cardBack);
                    level2Label3.setIcon(cardBack);
                    level2Label4.setIcon(cardBack);
                    level2Label5.setIcon(cardBack);
                    level2Label6.setIcon(cardBack);
                }
            });
            showCardsTimer.setRepeats(false);
            showCardsTimer.start();


            add(level2Label1);
            add(level2Label2);
            add(level2Label3);
            add(level2Label4);
            add(level2Label5);
            add(level2Label6);

            revalidate();




        }

    }

}
