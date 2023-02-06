package gui;

//  imports
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.UIManager;

public class StartMenu implements Runnable {
    
    public void run() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            //  do nothing for now
        }

        JFrame startMenu = new JFrame("Setup Chess Game");
        setupMenu(startMenu);

        Box components = Box.createVerticalBox();
        startMenu.add(components);

        //  game title
        JPanel titlePanel = new JPanel();
        components.add(titlePanel);
        JLabel titleLbl = new JLabel("Players");
        titlePanel.add(titleLbl);

        /* white player selections */
        JPanel whitePlayerPanel = new JPanel();
        components.add(whitePlayerPanel);

        //  the white king image
        JLabel whitePiece = new JLabel();
        ImageIcon whiteKing = new ImageIcon("resources/images/wking.png");
        whitePiece.setIcon(whiteKing);
        whitePlayerPanel.add(whitePiece);

        //  white player name
        JTextField whiteName = new JTextField("White", 10);
        whitePlayerPanel.add(whiteName);

        /* black player selections */
        JPanel blackPlayerPanel = new JPanel();
        components.add(blackPlayerPanel);

        //  the black king image
        JLabel blackPiece = new JLabel();
        ImageIcon blackKing = new ImageIcon("resources/images/bking.png");
        blackPiece.setIcon(blackKing);
        blackPlayerPanel.add(blackPiece);

        //  black player name
        JTextField blackName = new JTextField("Black", 10);
        blackPlayerPanel.add(blackName);

        /* time control */

        //  filling an array with the numbers 0 to 60
        final String[] minSecOpts = new String[60];
        for (int i = 0; i < minSecOpts.length; i++) 
            minSecOpts[i] = i < 10 ? "0" + i : "" + i;
        
        JComboBox<String> seconds = new JComboBox<>(minSecOpts);  //  seconds
        JComboBox<String> minutes = new JComboBox<>(minSecOpts);  //  minutes
        JComboBox<String> hours = new JComboBox<>(new String[] {"0", "1", "2", "3", "4", "5"});  //  hours

        Box timeControl = Box.createHorizontalBox();
        
        //  adding the combo boxes
        timeControl.add(hours);
        timeControl.add(Box.createHorizontalStrut(10));
        timeControl.add(minutes);
        timeControl.add(Box.createHorizontalStrut(10));
        timeControl.add(seconds);

        timeControl.add(Box.createVerticalGlue());
        components.add(timeControl);

        //  start button
        JButton start = new JButton("Start");
        start.addActionListener(e -> {
            String whitePlayerName = whiteName.getText();
            String blackPlayerName = blackName.getText();
            int numHours = Integer.parseInt((String) hours.getSelectedItem());
            int numMins = Integer.parseInt((String) minutes.getSelectedItem());
            int numSecs = Integer.parseInt((String) seconds.getSelectedItem());

            //  new GameFrame(whitePlayerName, blackPlayerName, numHours, numMins, numSecs);
            startMenu.dispose();
        });

        Box startButton = Box.createHorizontalBox();
        startButton.add(start);
        components.add(startButton);
    }

    //  setupMenu method sets the properties of the StartMenu JFrame
    private void setupMenu(JFrame frame) {
        frame.setResizable(false);
        frame.setSize(260, 240);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
