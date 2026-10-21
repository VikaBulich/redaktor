package view;

import control.Controller;
import model.Cat;
import model.SpeakBehavior;

import javax.swing.*;
import java.awt. *;
import java.awt.event.*;

public class MyPanel extends JPanel {
        JTextField t1;
        JTextField t2;

        JTextField d1;
        JButton d2;
        JButton button;
        JButton cat;
        JButton dog;

       Controller controller;

       //JButton button;
        public MyPanel (Controller controller) {
            this.controller = controller;
            t1 = new JTextField("           ");
            t2 = new JTextField("           ");
            button = new JButton("BUTTON");
            d2 = new JButton("speak");
            // button = new JButton("submit");
             cat = new JButton("switchCat");
            dog = new JButton("switchDog");
            add(t1);
            add(t2);
            add(button);
            add(d2);
            add(cat);
            add(dog);

            button.addActionListener(e -> t2.setText(t1.getText().trim()));
            d2.addActionListener(e->t1.setText(controller.enimalSpeak()));
            cat.addActionListener(e->controller.setCat());
            dog.addActionListener(e->controller.setDog());
            addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    super.mousePressed(e);
                    controller.mousePressed(e.getPoint());
                }
            });

            addMouseMotionListener(new MouseMotionAdapter() {
                @Override
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
        controller.draw(g2);
    }
}
