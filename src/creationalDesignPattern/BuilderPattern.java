package creationalDesignPattern;

import java.util.List;

public class BuilderPattern {
    class BurgerMeal {
        private final String bunType;
        private final String patty;

        private final boolean hasCheese;
        private final List<String> toppings;
        private final String sides;
        private final String drink;

        public BurgerMeal(BurgerMealBuilder builder) {
            this.bunType = builder.bunType;
            this.patty = builder.patty;
            this.hasCheese = builder.hasCheese;
            this.toppings = builder.toppings;
            this.sides = builder.sides;
            this.drink = builder.drink;
        }
    }
    public static class BurgerMealBuilder {
        private String bunType;
        private String patty;
        private boolean hasCheese;
        private List<String> toppings;
        private String sides;
        private String drink;

        public BurgerMealBuilder(String bunType, String patty) {
            this.bunType = bunType;
            this.patty = patty;
        }

        public BurgerMealBuilder setHasCheese(boolean hasCheese) {
            this.hasCheese = hasCheese;
            return this;
        }

        public BurgerMealBuilder setToppings(List<String> toppings) {
            this.toppings = toppings;
            return this;
        }

        public BurgerMealBuilder setSides(String sides) {
            this.sides = sides;
            return this;
        }

        public BurgerMealBuilder setDrink(String drink) {
            this.drink = drink;
            return this;
        }

        public BurgerMeal build() {
            return new BuilderPattern().new BurgerMeal(this);
        }
    }

    public static void main(String[] args) {
        BurgerMeal burgerMeal = new BurgerMealBuilder("Sesame", "Beef")
                .setHasCheese(true)
                .setToppings(List.of("Lettuce", "Tomato", "Onion"))
                .setSides("Fries")
                .setDrink("Coke")
                .build();

        System.out.println("Burger Meal created with bun type: " + burgerMeal.bunType + ", patty: " + burgerMeal.patty);
    }
}
