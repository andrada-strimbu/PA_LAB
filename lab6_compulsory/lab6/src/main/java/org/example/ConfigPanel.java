package org.example;

import org.example.MainFrame;

import javax.swing.*;
import javax.swing.event.ListDataListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel dotsLabel, linesLabel;
    JSpinner dotsSpinner;
    JComboBox linesCombo;
    JButton newBtn;
    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
        newBtn.addActionListener(e -> {
            // get the new values from the spinner and combo box
            int numVertices = (int) dotsSpinner.getValue();
            double edgeProbability = (double) linesCombo.getSelectedItem();
            // repaint the graph with the new values
            frame.getDrawingPanel().repaint();
        });
    }

    private void init() {
        //create the label and the spinner
        dotsLabel = new JLabel("Number of dots:");
        dotsSpinner = new JSpinner(new SpinnerNumberModel(6, 3, 100, 1));
        //create the rest of the components

                linesLabel = new JLabel("Line probability:");
        linesCombo = new JComboBox(new ComboBoxModel<Double>() {
            private final Double[] values = new Double[11];
            {
                for (int i = 0; i < values.length; i++) {
                    values[i] = i / 10.0;
                }
            }
            private Double selectedValue = values[0];

            @Override
            public void setSelectedItem(Object anItem) {
                selectedValue = (Double) anItem;
            }

            @Override
            public Object getSelectedItem() {
                return selectedValue;
            }

            @Override
            public int getSize() {
                return values.length;
            }

            @Override
            public Double getElementAt(int index) {
                return values[index];
            }

            @Override
            public void addListDataListener(ListDataListener l) {
            }

            @Override
            public void removeListDataListener(ListDataListener l) {
            }
        });
        //add the combo box to the panel

        newBtn=new JButton("New Game");
        add(dotsLabel); //JPanel uses FlowLayout by default
        add(dotsSpinner);
        add(linesLabel);
        add(linesCombo);
        add(newBtn);

    } }
