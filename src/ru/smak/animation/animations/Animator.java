package ru.smak.animation.animations;

import ru.smak.animation.graphics_objects.Ball;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Animator implements Runnable {
    private Graphics mainGraphics;
    private Ball ball;
    private Dimension fullSize;

    public Animator(Dimension size){
        ball = new Ball();
        ball.setColor(Color.GREEN);
        fullSize = size;
    }



    public void setMainGraphics(Graphics g){
        this.mainGraphics = g;
    }

    @Override
    public void run() {
        BufferedImage img = new BufferedImage(fullSize.width, fullSize.height, BufferedImage.TYPE_INT_RGB);
        while (ball.getX() < fullSize.width- ball.getSize().width){
            var imgGr = img.createGraphics();
            imgGr.setColor(Color.WHITE);
            imgGr.fillRect(0, 0, fullSize.width, fullSize.height);
            ball.paint(imgGr);
            mainGraphics.drawImage(img, 0, 0, null);
            try {
                Thread.sleep(30);
            } catch (InterruptedException _) {
                break;
            }

            ball.move(3, 0);
        }
    }
}
