package org.example.model;


import java.awt. *;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;

public class MyShape {
    RectangularShape shape;
    Color color;
    public MyShape(RectangularShape shape) {this.shape = shape; }

    public void setShape(RectangularShape shape) {
        this.shape = shape;
    }
    public void draw(Graphics2D g2) {g2.draw(shape);}

    public void setFrameFromDiagonal(Point2D point,Point2D point1 ){shape.setFrameFromDiagonal(point,point1);}

    public MyShape setRectangle2D() {
        shape = new Rectangle2D.Double();
        return this;
    }

    public void setEllipse2D(){
        shape = new Ellipse2D.Double();
        return this;
    }
}