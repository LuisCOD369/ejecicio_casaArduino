package controller;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class logic_view_casa {
    private List<Circle> circles;

    public logic_view_casa() {
        circles = new ArrayList<>();
        // Añadir círculos en posiciones específicas
        circles.add(new Circle(450, 250, 30));
        circles.add(new Circle(350, 100, 30));
        circles.add(new Circle(275, 250, 30));
        circles.add(new Circle(450, 400, 30));
        circles.add(new Circle(230, 400, 30));
    }

    public void toggleCircleColor(int x, int y) {
        for (Circle circle : circles) {
            if (circle.contains(x, y)) {
                circle.toggleColor();
                break;
            }
        }
    }

    public void drawCircles(Graphics g) {
        for (Circle circle : circles) {
            g.setColor(circle.getColor());
            g.fillOval(circle.getX() - circle.getRadius(), circle.getY() - circle.getRadius(), circle.getDiameter(), circle.getDiameter());
        }
    }

    class Circle {
        private int x, y, radius;
        private Color color;

        public Circle(int x, int y, int radius) {
            this.x = x;
            this.y = y;
            this.radius = radius;
            this.color = Color.RED;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getRadius() {
            return radius;
        }

        public int getDiameter() {
            return radius * 2;
        }

        public Color getColor() {
            return color;
        }

        public void toggleColor() {
            if (color == Color.RED) {
                color = Color.YELLOW;
            } else {
                color = Color.RED;
            }
        }

        public boolean contains(int px, int py) {
            return Math.pow(px - x, 2) + Math.pow(py - y, 2) <= Math.pow(radius, 2);
        }
    }
}
