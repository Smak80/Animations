package ru.smak.animation.animations;

import ru.smak.animation.graphics_objects.Ball;

import java.awt.*;
import java.util.ArrayList;

public class Animator implements Runnable {
    private final ArrayList<Ball> objects = new ArrayList<>();
    private Dimension fullSize;
    private final ScenePainter scenePainter;

    public Animator(Dimension size){
        fullSize = size;
        scenePainter = new ScenePainter(size, objects);
        new Thread(scenePainter).start();
    }

    public Dimension getSize() {
        return fullSize;
    }

    public void setSize(Dimension newSize) {
        this.fullSize = newSize;
        scenePainter.setSize(newSize);
    }

    public void addObject(Ball object){
        objects.add(object);
    }

    public void setMainGraphics(Graphics g){
        scenePainter.setMainGraphics(g);
    }

    public void addObject(){

        var x = (int)(Math.random() * (fullSize.width - Ball.SIZE));
        var y = (int)(Math.random() * (fullSize.height - Ball.SIZE));
        Ball ball = new Ball(x, y);
        addObject(ball);
    }

    @Override
    public void run() {
        while (true) {
            for (int i = 0; i < objects.size(); i++) {
                checkFrames(objects.get(i));
                objects.get(i).move();
            }
            try {
                Thread.sleep(10);
            } catch (Exception _){

            }
        }
    }

    public void checkFrames(Ball b){
        var x = b.getX();
        var y = b.getY();
        if (x < 0) {
            b.setX(0);
            b.setDx(-b.getDx());
        }
        if (x > fullSize.width - Ball.SIZE){
            b.setX(fullSize.width - Ball.SIZE);
            b.setDx(-b.getDx());
        }
        if (y < 0){
            b.setY(0);
            b.setDy(-b.getDy());
        }
        if (y > fullSize.height - Ball.SIZE) {
            b.setY(fullSize.height - Ball.SIZE);
            b.setDy(-b.getDy());
        }
    }
}
