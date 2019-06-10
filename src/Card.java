import javax.swing.*;

public class Card {

    private final String FILE_PATH = "C:\\IdeaProjects\\pairs-memory-game\\src\\images\\";
    private String fileName;
    private ImageIcon imageIcon;
    private JLabel imageLabel;
    private boolean isOnBoard;


    public Card(String fileName) {
        this.fileName = fileName;
        this.imageIcon = new ImageIcon(FILE_PATH + fileName);
        this.imageLabel = new JLabel(new ImageIcon(imageIcon.getImage()));
        this.isOnBoard = false;
    }


    public ImageIcon getImageIcon() {
        return imageIcon;
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
}
