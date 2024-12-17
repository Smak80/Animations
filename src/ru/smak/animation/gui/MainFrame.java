package ru.smak.animation.gui;

import ru.smak.animation.animations.Animator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
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
        new Thread(a).start();

        mainPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                a.setMainGraphics(mainPanel.getGraphics());
                a.addObject();
            }
        });

        mainPanel.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                a.setSize(mainPanel.getSize());
                a.setMainGraphics(mainPanel.getGraphics());
            }
        });
    }
}
