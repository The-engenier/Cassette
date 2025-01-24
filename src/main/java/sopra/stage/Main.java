package sopra.stage;
import java.io.IOException;
import java.util.Scanner;
import sopra.stage.Cassette;


public class Main {

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_ORANGE ="\u0001B[38,2,255,165;";

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Cassette cassette = new Cassette();

        String nombre;
        while (true) {
            System.out.println("select your list of options:");
            System.out.println("1: READ");
            System.out.println("2: Write");
            System.out.println("3: Remove");
            System.out.println("4: About");
            System.out.println("5: Quit");

            nombre = scanner.nextLine();
            //switch case
            switch (nombre){
                case ("1"):
                    System.out.println("read");

                    break;
                case ("2"):
                    System.out.println("WRITE");
                    break;
                case ("3"):
                    System.out.println("REMOVE");
                    break;
                case ("4"):
                    System.out.println("Current Version " + ANSI_RED + "ALPHA\n" + ANSI_WHITE);
                    System.out.println("\u001B[38;2;255;165;0mJAVA 17.0.14\u001B[0m");
                    System.out.println("Par Ahmed\n");
                    System.out.println("Source:");
                    System.out.println("W3SCHOOL");
                    System.out.println("STACKOVERFLOW");
                    System.out.println("ORACLE DOCS\n");
                    break;
                case ("5"):
                    scanner.close();
                    System.exit(0);

            }

        }
    }
}