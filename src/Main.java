//  imports
import javax.swing.SwingUtilities;

import gui.StartMenu;

public class Game implements Runnable {

    public void run() {
        SwingUtilities.invokeLater(new StartMenu());
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Game());
    }
}