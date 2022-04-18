package lesson20;

import java.io.File;

public class Application {
    public static void main(String[] args) {
        Point a = new Point(45,67);
        Point b = new Point(67,12);
        Point c = new Point(89,-8);

        BinHandler binHandler = new BinHandler(new File("dsds.bin"));
        binHandler.writeToFile(a);

        Point aFromFile = binHandler.readFromFile();
        System.out.println(aFromFile);

        Figure figure = new Figure(3);
        binHandler.writeToFile(a);
        binHandler.writeToFile(b);
        binHandler.writeToFile(c);

        binHandler.writeToFile(figure);

        Figure figureFromFile = binHandler.readFromFile();
        System.out.println(figureFromFile);

    }
}
