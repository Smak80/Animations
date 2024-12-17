package ru.smak.animation.animations;

import ru.smak.animation.graphics_objects.Ball;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class ScenePainter implements Runnable {

    private Dimension fullSize;
    private final ArrayList<Ball> objects;
    private Graphics mainGraphics = null;
    private BufferedImage img;
    private Graphics imgGr;

    public ScenePainter(Dimension size, ArrayList<Ball> objects){
        fullSize = size;
        this.objects = objects;
        img = new BufferedImage(fullSize.width, fullSize.height, BufferedImage.TYPE_INT_RGB);
        imgGr = img.createGraphics();
    }

    public void setMainGraphics(Graphics g){
        this.mainGraphics = g;
    }

    @Override
    public void run() {
        while (true) {
            imgGr.setColor(Color.WHITE);
            imgGr.fillRect(0, 0, fullSize.width, fullSize.height);

            for (int i = 0; i < objects.size(); i++) {
                objects.get(i).paint(imgGr);
            }

            if (mainGraphics!=null) {
                mainGraphics.drawImage(img, 0, 0, null);
            }
            try {
                Thread.sleep(30);
            } catch (InterruptedException _) {
                break;
            }
        }
    }

    public Dimension getSize(){
        return fullSize;
    }

    public void setSize(Dimension newSize) {
        fullSize = newSize;
        img = new BufferedImage(fullSize.width, fullSize.height, BufferedImage.TYPE_INT_RGB);
        imgGr = img.createGraphics();
    }
}
