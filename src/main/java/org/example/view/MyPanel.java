package org.example.view;

import org.example.controller.Controller;
import org.example.model.MyShape;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class MyPanel extends JPanel {
    Controller controller;

    public MyPanel(Controller controller) {
        this.controller = controller;

        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                controller.mousePressed(e.getPoint());
            }
        });
        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
                controller.mouseDragged(e.getPoint());
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        ArrayList<MyShape> list = controller.translate();
        if (list != null) {
            for (MyShape s : list) {
                s.draw(g2);
            }
        }
    }
}