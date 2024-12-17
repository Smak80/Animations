package ru.smak.animation.graphics_objects;

import java.awt.*;
import java.util.Random;

/**
 * Класс, представляющий объекты в виде кружков, для отображения на экране.
 * @see AnimatableObject
 */
public class Ball implements AnimatableObject {

    private int x;
    private int y;
    private Dimension size;
    private Color color;
    public static final int SIZE = 75;

    /**
     * Величина смещения шарика (в пикселях) по оси x за один шаг
     */
    private int dx;
    /**
     * Величина смещения шарика (в пикселях) по оси y за один шаг
     */
    private int dy;

    public int getDx() {
        return dx;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public int getDy() {
        return dy;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

    public Ball(int x, int y){
        this.x = x;
        this.y = y;

        dx = (int)(Math.random() * 11) - 5;
        dy = (int)(Math.random() * 11) - 5;

        color = new Color(
                (float)Math.random(),
                (float)Math.random(),
                (float)Math.random()
        );
        size = new Dimension(SIZE, SIZE);
    }

    public Dimension getSize(){
        return new Dimension(size);
    }

    public void setPosition(int x, int y){
        this.x = x;
        this.y = y;
    }

    /**
     * Получает позицию по горизонтали для объекта
     * @return значение верхнего левого угла описанного вокруг объекта прямоугольника
     */
    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    public void setSize(Dimension size){
        this.size = new Dimension(size);
    }

    /**
     * Возвращает цвет, которым заполняется кружок
     * @return Цвет типа Color
     */
    public Color getColor(){
        return color;
    }

    /**
     * Устанавливает цвет для кружка
     * @param c Цвет, задаваемый объектном класса [Color], которым будет заполняться кружок
     */
    public void setColor(Color c){
        this.color = c;
    }

    @Override
    public void move(){
        x += dx;
        y += dy;
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, size.width, size.height);
    }

}
