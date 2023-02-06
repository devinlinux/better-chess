package pieces;

//  imports
import javax.swing.ImageIcon;

public abstract class Piece {
    
    //  fields
    private static ImageIcon image;
    private boolean isWhite;
    private boolean hasMoved;

    //  constructor
    public Piece(boolean isWhite, String name) {
        this.isWhite = isWhite;
        String imageName = this.isWhite ? "w" + name + ".png": "b" + name + ".png";
        image = new ImageIcon("resources/images/" + imageName);
    }
}
