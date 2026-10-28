package org.example.controller;

import org.example.model.FillBehavior;
import org.example.model.Model;
import org.example.model.MyShape;
import org.example.view.MyFrame;
import org.example.view.MyPanel;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;
import java.util.ArrayList;

public class Controller {
    MyPanel myPanel;
    MyFrame myFrame;
    Model model;
    Point2D[] points;
    MyShape currentShape;

    public Controller() {
        points = new Point2D[2];
        myPanel = new MyPanel(this);
        myFrame = new MyFrame(myPanel);
        currentShape = new MyShape(Color.RED, new Rectangle2D.Double());
        model = new Model(currentShape);
    }

    public void setFrame() {
        if (points[0] != null && points[1] != null) {
            currentShape.setFrame(points);
        }
    }

    public void mousePressed(Point point) {
        points[0] = point;
        model.addShape();
    }

    public void mouseDragged(Point point) {
        points[1] = point;
        model.stretch(points);
    }


    public void draw(Graphics2D g2) {
        if (points[0] != null) {
            currentShape.draw(g2);
        }
    }

    public ArrayList<MyShape> translate() {
        return model.getList();
    }
}

