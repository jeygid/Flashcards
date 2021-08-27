package flashcards.commands;

import flashcards.Runner;
import flashcards.interfaces.CommandWithArg;

import java.io.File;
import java.util.Map;
import java.util.Scanner;

public class Import implements CommandWithArg {

    @Override
    public void perform(String fileName) {

        if (fileName == null) {
            System.out.println("File name:");
            fileName = Runner.scanner.nextLine();
        }

        File file = new File(fileName);

        if (!file.exists()) {
            System.out.println("File not found.");
            return;
        }

        int counter = 0;

        try {

            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {

                String line = scanner.nextLine();
                String[] cardAndDefinitionWithErrors = line.split(":");
                String card = cardAndDefinitionWithErrors[0];
                String definition = cardAndDefinitionWithErrors[1];
                int errors = Integer.parseInt(cardAndDefinitionWithErrors[2]);

                if (Runner.map.containsValue(card)) {

                    String definitionToRemove = "";

                    for (Map.Entry entry : Runner.map.entrySet()) {
                        if (entry.getValue().equals(card)) {
                            definitionToRemove = (String) entry.getKey();
                        }
                    }

                    Runner.map.remove(definitionToRemove);
                    Runner.map.put(definition, card);
                    Runner.stats.replace(card, errors);

                } else {
                    Runner.map.put(definition, card);
                    Runner.stats.put(card, errors);
                }

                counter++;
            }

        } catch (Exception e) {
            System.out.println("Error happened during import of file " + fileName);
            return;
        }

        System.out.println(counter + " cards have been loaded.");

    }
}
