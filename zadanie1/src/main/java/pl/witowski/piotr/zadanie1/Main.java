package pl.witowski.piotr.zadanie1;

import java.util.Scanner;

public class Main {

    private void printMenu() {
        clearConsole();
        System.out.println("=======================");
        System.out.println("0 -> wyjdz z programu");
        System.out.println("1 -> dodaj drzewo liściaste");
        System.out.println("2 -> dodaj drzewo iglaste");
        System.out.println("3 -> wywołaj rozrost drzew");
        System.out.println("4 -> czas na jesień");
        System.out.println("5 -> czas na zime");
        System.out.println("6 -> czas na wiosne");
        System.out.println("7 -> wypisz zawartość lasu ");
        System.out.println("=======================");
    }

    public void clearConsole() {
        try {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                Runtime.getRuntime().exec("cls");
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (final Exception e) {
            //  Handle any exceptions.
        }
    }

    private void addNewConiferTree(Forest forest) {
        forest.addNewTree(true);
    }

    private void addNewTree(Forest forest) {
        forest.addNewTree(false);
    }

    private void growTree(Forest forest) {
        forest.growTree();
    }

    private void itsAutumnTime(Forest forest) {
        forest.itsAutumnTime();
    }

    private void itsSpringTime(Forest forest) {
        forest.itsSpringTime();
    }

    private void itsWinterTime(Forest forest) {
        forest.itsWinterTime();
    }

    private void printTreeInForest(Forest forest) {
        for (Tree tree : forest.getTrees()) {
            System.out.println(tree.toString());
        }
    }


    public static void main(String[] args) {
        Forest forest = new Forest();
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);
        boolean stopLoop = false;
        while (!stopLoop) {
            main.printMenu();
            switch (scanner.nextInt()) {
                case 0:
                    stopLoop = true;
                    break;
                case 1:
                    main.addNewTree(forest);
                    break;
                case 2:
                    main.addNewConiferTree(forest);
                    break;
                case 3:
                    main.growTree(forest);
                    break;
                case 4:
                    main.itsAutumnTime(forest);
                    break;
                case 5:
                    main.itsWinterTime(forest);
                    break;
                case 6:
                    main.itsSpringTime(forest);
                    break;
                case 7:
                    main.printTreeInForest(forest);
                    break;
            }
        }
    }
}
