# LLD Practice

Personal scratchpad for practicing Low-Level Design (LLD) concepts in Java — mainly design patterns implemented as small, self-contained, runnable examples.

## Structure

```
src/
├── Main.java                      # IntelliJ scratch entry point
├── SingletonPattern.java          # Creational: Singleton
├── FactoryPattern.java            # Creational: Factory Method
├── AbstractFactoryPattern.java    # Creational: Abstract Factory
├── BuilderPattern.java            # Creational: Builder
└── structuralDesignPattern/
    └── DecoratorPattern.java      # Structural: Decorator
```

Each file is a standalone `public class` with its own `main` method, so patterns can be run and understood independently.

## Patterns covered so far

| Pattern | File | What it demonstrates |
|---|---|---|
| Singleton | `SingletonPattern.java` | Lazy-initialized single instance via a private constructor + static accessor |
| Factory Method | `FactoryPattern.java` | A `ShapeFactory` that creates `Circle`/`Square` objects without exposing instantiation logic |
| Abstract Factory | `AbstractFactoryPattern.java` | Country-specific `PaymentGateway` + `Invoice` families (India/US) produced by a `CountryFactory` |
| Builder | `BuilderPattern.java` | Step-by-step, chainable construction of an immutable `BurgerMeal` object |
| Decorator | `structuralDesignPattern/DecoratorPattern.java` | Wrapping a `Coffee` with `ExtraMilk`/`Hazelnut` decorators to add cost/description dynamically |

## Running an example

Each class has its own `main` method — run any file directly from your IDE (this repo has an `.iml`, so it's set up for IntelliJ IDEA), or via `javac`/`java`:

```bash
javac -d out src/SingletonPattern.java
java -cp out SingletonPattern
```

For the package-scoped example:

```bash
javac -d out src/structuralDesignPattern/DecoratorPattern.java
java -cp out structuralDesignPattern.DecoratorPattern
```

## Purpose

This is a learning repo, not a library — code favors clarity over completeness (no build tool, no tests). Expect it to grow as more LLD patterns and exercises (behavioral patterns, SOLID drills, mini system-design problems) are added over time.
