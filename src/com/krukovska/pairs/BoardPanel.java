package com.krukovska.pairs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;


public class BoardPanel extends JPanel {

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

        setLayout(new GridLayout(level < 5 ? 2 : 3, level < 5 ? level + 1 : 4));
        showCards(GameLevels.getLevels()[level - 1], level * 2 + 2);
        addCards(GameLevels.getLevels()[level - 1], level * 2 + 2);

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

                                        openClickedCards();
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

            private void openClickedCards() {
                if ((cards[card1Number].getFileName().equals(cards[card2Number].getFileName()))) {
                    remove(cards[card1Number].getImageLabel());
                    remove(cards[card2Number].getImageLabel());

                    cardsDeleted += 2;

                    if (lastLevelFinished(amountOfCards)) {
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
            }
        });
        showCardsTimer.setRepeats(false);
        showCardsTimer.start();
    }

    private boolean lastLevelFinished(int amountOfCards) {
        return currentLevel == 5 && cardsDeleted == amountOfCards;
    }

    private void gameFinishedUpdate() {
        removeAll();
        repaint();
        setLayout(null);
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
