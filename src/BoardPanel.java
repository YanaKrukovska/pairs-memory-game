import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;


public class BoardPanel extends JPanel {


    private Card[] cardsLevel1 = new Card[]{new Card("cake1.jpg"), new Card("cake2.jpg"),
            new Card("cake1.jpg"), new Card("cake2.jpg")};
    private Card[] cardsLevel2 = new Card[]{new Card("espresso.jpg"), new Card("kakao.jpg"),
            new Card("latte1.jpg"), new Card("kakao.jpg"), new Card("latte1.jpg"),
            new Card("espresso.jpg")
    };

    private Card[] cardsLevel3 = new Card[]{new Card("doll1.jpg"), new Card("doll2.jpg"),
            new Card("doll3.jpg"), new Card("doll4.jpg"), new Card("doll1.jpg"),
            new Card("doll2.jpg"), new Card("doll3.jpg"), new Card("doll4.jpg")
    };

    private Card[] cardsLevel4 = new Card[]{new Card("bieber.jpg"), new Card("vynnyk.jpg"),
            new Card("zibrov.jpg"), new Card("poplavskyi.jpg"), new Card("kirkorov.jpg"),
            new Card("bieber.jpg"), new Card("vynnyk.jpg"),
            new Card("zibrov.jpg"), new Card("poplavskyi.jpg"), new Card("kirkorov.jpg")
    };

    private Card[] cardsLevel5 = new Card[]{new Card("teteriv.jpg"), new Card("rogan.jpg"),
            new Card("lvivske.jpg"), new Card("zhyguli.jpg"), new Card("chernigivske.jpg"),
            new Card("teteriv.jpg"), new Card("rogan.jpg"), new Card("lvivske.jpg"),
            new Card("zhyguli.jpg"), new Card("chernigivske.jpg"), new Card("opilla.jpg"),
            new Card("opilla.jpg")
    };
    private int cardsDeleted = 0;

    private int currentLevel = 0;
    private MenuPanel menuPanel;

    public BoardPanel(MenuPanel menuPanel) {
        this.menuPanel = menuPanel;
        setBackground(Color.WHITE);

    }


    public void updateBoard(int level) {
        currentLevel = level;
        setBounds(0, PairsGame.TOP_PANEL_HEIGHT + 2, PairsGame.FRAME_WIDTH, PairsGame.PANEL_HEIGHT);

        if (level == 1) {
            setLayout(new GridLayout(2, 2));
            showCards(cardsLevel1, 4);
            addCards(cardsLevel1, 4);
        } else if (level == 2) {
            setLayout(new GridLayout(2, 3));
            showCards(cardsLevel2, 6);
            addCards(cardsLevel2, 6);
        } else if (level == 3) {
            setLayout(new GridLayout(2, 4));
            showCards(cardsLevel3, 8);
            addCards(cardsLevel3, 8);
        } else if (level == 4) {
            setLayout(new GridLayout(2, 5));
            showCards(cardsLevel4, 10);
            addCards(cardsLevel4, 10);
        } else if (level == 5) {
            setLayout(new GridLayout(3, 4));
            showCards(cardsLevel5,12);
            addCards(cardsLevel5, 12);
        }

        revalidate();

    }

    private void showCards(Card[] cards, int amountOfCards) {
        Timer showCardsTimer = new Timer(1500, new ActionListener() {
            int cardsSelected = 0;
            int card1Number;
            int card2Number;

            @Override
            public void actionPerformed(ActionEvent e) {

                for (int i = 0; i < cards.length; i++) {
                    cards[i].getImageLabel().setIcon(cards[i].getCardBack());
                    int finalI = i;
                    cards[i].getImageLabel().addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            super.mouseClicked(e);

                            if (cardsSelected == 0) {
                                cards[finalI].getImageLabel().setIcon(cards[finalI].getFrontIcon());
                                card1Number = finalI;
                                cardsSelected++;
                            } else if (cardsSelected == 1) {
                                cards[finalI].getImageLabel().setIcon(cards[finalI].getFrontIcon());
                                card2Number = finalI;


                                Timer timeBeforeHiding = new Timer(1000, new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {

                                        if ((cards[card1Number].getFileName().equals(cards[card2Number].getFileName()))) {
                                            remove(cards[card1Number].getImageLabel());
                                            remove(cards[card2Number].getImageLabel());

                                            cardsDeleted += 2;

                                            if (currentLevel == 5 && cardsDeleted == amountOfCards) {
                                                gameFinishedUpdate();
                                                menuPanel.finalUpdate();
                                            } else if (cardsDeleted == amountOfCards) {
                                                updateBoard(++currentLevel);
                                                menuPanel.updateMenu(currentLevel);
                                                cardsDeleted = 0;
                                            }

                                            revalidate();

                                        } else {
                                            cards[card1Number].getImageLabel().setIcon(cards[card1Number].getCardBack());
                                            cards[card2Number].getImageLabel().setIcon(cards[card2Number].getCardBack());
                                        }
                                        cardsSelected = 0;
                                    }
                                });
                                timeBeforeHiding.setRepeats(false);
                                timeBeforeHiding.start();
                            }
                        }
                    })
                    ;
                }

            }
        });
        showCardsTimer.setRepeats(false);
        showCardsTimer.start();
    }

    private void gameFinishedUpdate() {
        removeAll();
        repaint();
        setLayout(null);
        System.out.println("finale");
        JLabel finalMessage = new JLabel("Congratulations!");
        finalMessage.setFont(new Font("Serif", Font.BOLD, 36));
        finalMessage.setBounds(PairsGame.FRAME_WIDTH / 2 - 100, PairsGame.FRAME_HEIGHT / 2 - 150, 400, 100);
        add(finalMessage);
    }


    private void addCards(Card[] cards, int amountOfCards) {
        while (amountOfCards != 0) {

            Random generator = new Random();
            int randomIndex = generator.nextInt(cards.length);
            if (!cards[randomIndex].isOnBoard()) {
                amountOfCards--;
                cards[randomIndex].setOnBoard(true);
                add(cards[randomIndex].getImageLabel());
            }
        }
    }


}
