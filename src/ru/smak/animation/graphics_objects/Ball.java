package ru.smak.animation.graphics_objects;

import java.awt.*;

/**
 * Класс, представляющий объекты в виде кружков, для отображения на экране.
 * @see AnimatableObject
 */
public class Ball implements AnimatableObject {

    private int x;
    private int y;
    private Dimension size;
    private Color color;

    public Ball(){
        x = y = 0;
        color = Color.BLACK;
        size = new Dimension(75, 75);
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
    public void move(int dx, int dy){
        x += dx;
        y += dy;
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, size.width, size.height);
    }

}
