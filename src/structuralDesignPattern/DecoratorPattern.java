package structuralDesignPattern;

public class DecoratorPattern {
    interface Coffee {
        String getDescription();
        double getCost();
    }
    class Cappuccino implements Coffee {
        @Override
        public String getDescription() {
            return "Cappuccino";
        }
        @Override
        public double getCost() {
            return 100;
        }
    }
    class CoffeeDecorator implements Coffee {
        protected Coffee coffee;
        public CoffeeDecorator(Coffee coffee) {
            this.coffee = coffee;
        }
        @Override
        public String getDescription() {
            return this.coffee.getDescription();
        }
        @Override
        public double getCost() {
            return this.coffee.getCost();
        }
    }
    class ExtraMilk extends CoffeeDecorator {
        public ExtraMilk(Coffee coffee) {
            super(coffee);
        }
        @Override
        public String getDescription() {
            return coffee.getDescription() + "Extra milk";
        }
        @Override
        public double getCost() {
            return coffee.getCost() + 20;
        }
    }
    class Hazelnut extends CoffeeDecorator {
        public Hazelnut(Coffee coffee) {
            super(coffee);
        }
        @Override
        public String getDescription() {
            return coffee.getDescription() + "Hazelnut";
        }
        @Override
        public double getCost() {
            return coffee.getCost() + 20;
        }
    }

    public static void main(String[] args) {
        DecoratorPattern decoratorPattern = new DecoratorPattern();
        Coffee cappuccino = decoratorPattern.new Cappuccino();
        System.out.println(cappuccino.getDescription() + " $" + cappuccino.getCost());

        Coffee cappuccinoWithMilk = decoratorPattern.new ExtraMilk(cappuccino);
        System.out.println(cappuccinoWithMilk.getDescription() + " $" + cappuccinoWithMilk.getCost());

        Coffee cappuccinoWithMilkAndHazelnut = decoratorPattern.new Hazelnut(cappuccinoWithMilk);
        System.out.println(cappuccinoWithMilkAndHazelnut.getDescription() + " $" + cappuccinoWithMilkAndHazelnut.getCost());
    }
}
