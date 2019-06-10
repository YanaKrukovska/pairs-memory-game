import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


public class BoardPanel extends JPanel {


    public Card[] cardsLevel1 = new Card[]{new Card("cake1.jpg"), new Card("cake2.jpg"),
            new Card("cake1.jpg"), new Card("cake2.jpg")};

    private int level1CardsAmount = 4;
    private ImageIcon cardBack = new ImageIcon("C:\\IdeaProjects\\pairs-memory-game\\src\\images\\backCard.jpg");



    public BoardPanel() {

        setBackground(Color.WHITE);

    }


    public void updateBoard(int level) {


        if (level == 1) {
            setBounds(0, PairsGame.TOP_PANEL_HEIGHT + 2, PairsGame.FRAME_WIDTH, PairsGame.PANEL_HEIGHT);

            setLayout(new GridLayout(2, 2));
            Timer showCardsTimer = new Timer(1500, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    for (int i = 0; i < cardsLevel1.length; i++) {
                        cardsLevel1[i].getImageLabel().setIcon(cardBack);
                    }

                }
            });
            showCardsTimer.setRepeats(false);
            showCardsTimer.start();

            while (level1CardsAmount != 0)
                addLevel1Cards();

        }


        revalidate();

    }


    private void addLevel1Cards() {
        Random generator = new Random();
        int randomIndex = generator.nextInt(cardsLevel1.length);
        if (!cardsLevel1[randomIndex].isOnBoard()) {
            level1CardsAmount--;
            cardsLevel1[randomIndex].setOnBoard(true);
            add(cardsLevel1[randomIndex].getImageLabel());
        }
    }

}
