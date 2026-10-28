package org.example.model;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Collection;

public class Model {
    MyShape pattern;
    MyShape currentShape;
    ArrayList<MyShape> list;

    public Model() {
        list = new ArrayList<>();
    }

    public Model(MyShape s) {
        this.pattern = s;
        list = new ArrayList<>();
    }

    public void setCurrentShape(MyShape currentShape) { this.pattern = currentShape; }

    public MyShape getCurrentShape() { return currentShape; }

    public ArrayList<MyShape> getList() { return list; }

    public void addShape() {
        currentShape = pattern.clone();
        list.add(currentShape);
    }

    public void stretch(Point2D[] p) {
        currentShape.shape.setFrameFromDiagonal(p[0], p[1]);
    }
}
