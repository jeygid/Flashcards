package flashcards;

import flashcards.commands.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Runner {

    public static Map<String, String> map = new LinkedHashMap<>();
    public static Map<String, Integer> stats = new HashMap<>();

    public static Scanner scanner = new Scanner(System.in);

    private static boolean exit = false;

    public static String fileImport = "";
    public static String fileExport = "";

    private static boolean startWithImport = false;
    private static boolean stopWithExport = false;

    public static void run(String[] args) {

        for (int i = 0; i < args.length; i++) {

            if (args[i].equals("-export")) {
                fileExport = args[i + 1];
                stopWithExport = true;
            }

            if (args[i].equals("-import")) {
                fileImport = args[i + 1];
                startWithImport = true;
            }
        }

        if (startWithImport) {
            new Import().perform(fileImport);
        }

        while (!exit) {

            System.out.println("Input the action (add, remove, import, export, " +
                    "ask, exit, log, hardest card, reset stats):");

            String command = scanner.nextLine();
            if (!command.matches(("(add|remove|import|export|ask|exit|log|hardest card|reset stats)"))) continue;

            switch (command) {
                case "add":
                    new Add().perform();
                    break;
                case "remove":
                    new Remove().perform();
                    break;
                case "import":
                    new Import().perform(null);
                    break;
                case "export":
                    new Export().perform(null);
                    break;
                case "ask":
                    new Ask().perform();
                    break;
                case "log":
                    new Log().perform();
                    break;
                case "hardest card":
                    new HardestCard().perform();
                    break;
                case "reset stats":
                    new ResetStats().perform();
                    break;
                case "exit":
                    if (stopWithExport) {
                        new Export().perform(fileExport);
                    }
                    exit = true;
                    scanner.close();
                    System.out.println("Bye bye!");
                    break;
            }

        }

    }
}
