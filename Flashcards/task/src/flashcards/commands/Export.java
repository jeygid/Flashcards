package flashcards.commands;

import flashcards.Runner;
import flashcards.interfaces.CommandWithArg;

import java.io.File;
import java.io.FileWriter;
import java.util.Map;

public class Export implements CommandWithArg {

    @Override
    public void perform(String fileName) {


        if (fileName == null) {
            System.out.println("File name:");
            fileName = Runner.scanner.nextLine();
        }

        File file = new File(fileName);

        int counter = 0;

        try {

            FileWriter fileWriter = new FileWriter(file);

            for (Map.Entry entry : Runner.map.entrySet()) {
                fileWriter.write(entry.getValue() + ":" + entry.getKey() + ":" +
                        Runner.stats.get(entry.getValue()) + "\n");
                fileWriter.flush();
                counter++;
            }

            fileWriter.close();

        } catch (Exception e) {
            System.out.println("Error happened during export of file " + fileName);
            return;
        }

        System.out.println(counter + " cards have been saved.");

    }
}
