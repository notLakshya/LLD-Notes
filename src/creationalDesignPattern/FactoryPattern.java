package creationalDesignPattern;

public class FactoryPattern {
    interface Shape {
        void draw();
    }
    class Circle implements Shape {
        @Override
        public void draw() {
            System.out.println("Drawing Circle");
        }
    }
    class Square implements Shape {
        @Override
        public void draw() {
            System.out.println("Drawing Square");
        }
    }
    class ShapeFactory {
        public Shape getShape(String shapeName) {
            if (shapeName.equals("Circle")) {
                return new Circle();
            } else if (shapeName.equals("Square")) {
                return new Square();
            }
            return null;
        }
    }

    public static void main(String[] args) {
        FactoryPattern factoryPattern = new FactoryPattern();
        ShapeFactory shapeFactory = factoryPattern.new ShapeFactory();

        Shape circle = shapeFactory.getShape("Circle");
        circle.draw();

        Shape square = shapeFactory.getShape("Square");
        square.draw();
    }
}
