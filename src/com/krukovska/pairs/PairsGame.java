package com.krukovska.pairs;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PairsGame extends JFrame {

    public final static int FRAME_WIDTH = 800;
    public final static int FRAME_HEIGHT = 500;
    public final static int TOP_PANEL_HEIGHT = FRAME_HEIGHT / 5;
    public final static int PANEL_HEIGHT = FRAME_HEIGHT - TOP_PANEL_HEIGHT;
    private final MenuPanel menuPanel;
    private BoardPanel gameBoard;
    private int levelCount = 0;


    public PairsGame() {

        setTitle("Pairs");
        setSize(FRAME_WIDTH + 8, FRAME_HEIGHT + 30);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);

        menuPanel = new MenuPanel();
        menuPanel.setBounds(0, 0, FRAME_WIDTH, TOP_PANEL_HEIGHT);


        gameBoard = new BoardPanel(menuPanel);
        gameBoard.setBounds(0, TOP_PANEL_HEIGHT, FRAME_WIDTH, PANEL_HEIGHT);

        menuPanel.getOkayButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == menuPanel.getOkayButton()) {

                    menuPanel.removeAll();
                    menuPanel.repaint();
                    menuPanel.generateMenu(++levelCount);
                    gameBoard.updateBoard(levelCount);

                    gameBoard.setBounds(0, TOP_PANEL_HEIGHT, FRAME_WIDTH, PANEL_HEIGHT);
                }
            }
        });


        add(menuPanel);
        add(gameBoard);
        setVisible(true);
    }


}
