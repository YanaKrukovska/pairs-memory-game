import javax.swing.*;

public class Card {

    private final String FILE_PATH = "C:\\IdeaProjects\\pairs-memory-game\\src\\images\\";
    private String fileName;
    private ImageIcon imageIcon;
    private ImageIcon frontIcon;
    private JLabel imageLabel;
    private boolean isOnBoard;
    private final ImageIcon cardBack = new ImageIcon("C:\\IdeaProjects\\pairs-memory-game\\src\\images\\backCard.jpg");


    public Card(String fileName) {
        this.fileName = fileName;
        this.imageIcon = new ImageIcon(FILE_PATH + fileName);
        this.frontIcon = imageIcon;
        this.imageLabel = new JLabel(new ImageIcon(imageIcon.getImage()));
        this.isOnBoard = false;
    }


    public JLabel getImageLabel() {
        return imageLabel;
    }

    public boolean isOnBoard() {
        return isOnBoard;
    }

    public void setOnBoard(boolean onBoard) {
        isOnBoard = onBoard;
    }

    public ImageIcon getCardBack() {
        return cardBack;
    }

    public String getFileName() {
        return fileName;
    }

    public ImageIcon getFrontIcon() {
        return frontIcon;
    }
}
