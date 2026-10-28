package org.example.control;

import org.example.model.MyShape;
import org.example.view.MyFrame;
import org.example.view.MyPanel;

import java.awt. *;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;


public class Controller {
    MyPanel myPanel;
    MyFrame myFrame;
    Point2D[] points;
    Rectangle2D rectangle2D;
    MyShape currentShape;
    Ellipse2D ellipse2D;
    private boolean isRectangle = true;
    public Controller() {
        points = new Point2D[2];
        rectangle2D = new Rectangle2D.Double();
        ellipse2D = new Ellipse2D.Double();
        myPanel = new MyPanel(this);
        myFrame = new MyFrame(myPanel);
        currentShape = new MyShape(rectangle2D);
    }


    public void mousePressed(Point point) {
        points[0] = point;
    }


    public void mouseDragged(Point point) {
        points[1] = point;

    }

    public void toggleShape() {
        isRectangle = !isRectangle;
        currentShape = isRectangle?currentShape.setRectangle2D():currentShape.setEllipse2D();
        points[0] = null;
        points[1] = null;

        }

    public void draw(Graphics2D g2) {
        if(points[0]!=null) {
            currentShape.setFrameFromDiagonal(points[0], points[1]);
            currentShape.draw(g2);
        }
    }
}

