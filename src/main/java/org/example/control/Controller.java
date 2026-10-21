package control;

import model.Cat;
import model.Dog;
import model.SpeakBehavior;
import view.MyFrame;
import view.MyPanel;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;

public class Controller {
    Cat cat;
    Dog dog;
    SpeakBehavior enimal;
    MyPanel myPanel;
    MyFrame myFrame;
    Point2D[] points;
    Rectangle2D rectangle2D;
    RectangularShape currentShape;
    Ellipse2D ellipse2D;
    public Controller() {
        points = new Point2D[2];
        rectangle2D = new Rectangle2D.Double();
        ellipse2D = new Ellipse2D.Double();
        cat = new Cat("Nusha");
        dog = new Dog();
        enimal = cat;
        myPanel = new MyPanel(this);
        myFrame = new MyFrame(myPanel);
        currentShape = rectangle2D;

    }

    public String enimalSpeak() {
        return enimal.speak();
    }

    public void setCat() {
        this.enimal = cat;
    }

    public void setDog() {
        this.enimal = dog;
    }

    public void mousePressed(Point point) {
        points[0] = point;
    }


    public void mouseDragged(Point point) {
        points[1] = point;
    }

    public void draw(Graphics2D g2) {
        if(points[0]!=null) {
          currentShape.setFrameFromDiagonal(points[0], points[1]);
          g2.draw(currentShape);

        }
    }
}
