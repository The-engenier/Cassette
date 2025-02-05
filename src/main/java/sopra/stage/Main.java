package sopra.stage;
import java.io.IOException;
import java.util.Scanner;

import com.sun.source.tree.CaseLabelTree;
import sopra.stage.Cassette;


public class Main {

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_ORANGE = "\u001B[38;2;255;165;0m";

    public static int inputId;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Cassette cassette = new Cassette();

        String nombre;
        while (true) {
            System.out.println("\nselect your list of options:");
            System.out.println("1: READ");
            System.out.println("2: Write");
            System.out.println("3: Remove");
            System.out.println("4: About");
            System.out.println("5: Quit");

            nombre = scanner.nextLine();
            //switch case
            switch (nombre){
                case ("1"):
                    cassette.printCassetteData();
                    System.out.println();
                    break;
                case ("2"):
                    System.out.print("Write your id: ");
                    cassette.addToCassette(Integer.parseInt(scanner.nextLine()));
                    System.out.print("Write your info: ");
                    cassette.addData(scanner.nextLine());
//                  cassette.writer();
//                  System.out.println(cassette.table);
//                  cassette.data.set(500, 3);
                    break;
                case ("3"):
                    cassette.printCassetteData();
                    System.out.print("delete your id: ");
                    inputId = Integer.parseInt(scanner.nextLine());
                    cassette.remover();

                    break;
                case ("4"):
                    System.out.println("Current Version " + ANSI_RED + "ALPHA\n" + ANSI_WHITE);
                    System.out.println(ANSI_ORANGE + "JAVA 17.0.14" + ANSI_WHITE);
                    System.out.println("Par Ahmed\n");
                    System.out.println("Source:");
                    System.out.println("W3SCHOOL");
                    System.out.println("STACKOVERFLOW");
                    System.out.println("ORACLE DOCS\n");
                    break;
                case ("5"):
                    scanner.close();
                    System.exit(0);
                    break;
                case ("21"):
                    System.out.println("HELLO");
            }

        }
    }
}