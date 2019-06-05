import javax.swing.*;
import java.awt.*;


public class BoardPanel extends JPanel {

    private JLabel card1 = new JLabel("Card 1");
    private JLabel card2 = new JLabel("Card 2");
    private JLabel card3 = new JLabel("Card 3");
    private JLabel card4 = new JLabel("Card 4");


    public BoardPanel() {

        setSize(PairsGame.FRAME_WIDTH, PairsGame.FRAME_HEIGHT);

    }


    public void updateBoard(int level) {
        if (level == 1){


        this.setLayout(new GridLayout(2,2));
            this.add(card1);
            this.add(card2);
            this.add(card3);
            this.add(card4);
            System.out.println("level 1");
            revalidate();

        }

    }



}
