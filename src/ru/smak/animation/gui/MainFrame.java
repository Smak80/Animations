package ru.smak.animation.gui;

import ru.smak.animation.animations.Animator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainFrame extends JFrame {
    JPanel mainPanel = new JPanel();

    public MainFrame(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(800, 600));
        mainPanel.setBackground(Color.WHITE);
        add(mainPanel);
        pack();
        Animator a = new Animator(mainPanel.getSize());
        mainPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                a.setMainGraphics(mainPanel.getGraphics());
                new Thread(a).start();
            }
        });
    }
}
