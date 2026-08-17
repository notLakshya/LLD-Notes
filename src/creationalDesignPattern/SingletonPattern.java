package creationalDesignPattern;

public class SingletonPattern {
    private static SingletonPattern instance;

    private SingletonPattern() {
        // Private constructor to prevent instantiation
    }

    public static SingletonPattern getInstance() {
        if (instance == null) {
            instance = new SingletonPattern();
        }
        return instance;
    }

    public void showMessage() {
        System.out.println("Hello from Singleton!");
    }

    public static void main(String[] args) {
        SingletonPattern singleton = SingletonPattern.getInstance();
        singleton.showMessage();
    }
}
