package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton exitBtn = new JButton("Exit");
    JButton loadBtn = new JButton("Load");
    JButton saveBtn = new JButton("Save");

    public ControlPanel(MainFrame frame) {

        this.frame = frame;
        init();
    }
    private void init() {
        //change the default layout manager(jff)
        setLayout(new GridLayout(1, 4));
        //add all buttons ...TO DO
        add(exitBtn);
        add(loadBtn);
        add(saveBtn);
        //configure listeners for all buttons
        exitBtn.addActionListener(this::exitGame);

    }
    private void exitGame(ActionEvent E){
        frame.dispose();
    }

}
