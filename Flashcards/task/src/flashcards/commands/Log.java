package flashcards.commands;

import flashcards.Runner;
import flashcards.interfaces.Command;

import java.io.File;
import java.io.FileWriter;
import java.util.Map;

public class Log implements Command {

    @Override
    public void perform() {

        System.out.println("File name:");
        String fileName = Runner.scanner.nextLine();

        File file = new File(fileName);

        try {

            FileWriter fileWriter = new FileWriter(file);

            for (Map.Entry entry : Runner.stats.entrySet()) {
                fileWriter.write("Card: \"" + entry.getKey() + "\". Errors: " + entry.getValue() + "\n");
                fileWriter.flush();
            }

            fileWriter.close();

        } catch (Exception e) {
            System.out.println("Error happened during writing logs to file " + fileName);
            return;
        }

        System.out.println("The log has been saved.");

    }
}
