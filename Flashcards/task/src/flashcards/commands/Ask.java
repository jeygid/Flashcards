package flashcards.commands;

import flashcards.Runner;
import flashcards.interfaces.Command;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ask implements Command {

    @Override
    public void perform() {

        System.out.println("How many times to ask?");
        int counter = Integer.parseInt(Runner.scanner.nextLine());

        for (int i = 0; i < counter; i++) {

            Random random = new Random();
            List<String> definitions = new ArrayList<>(Runner.map.keySet());
            String definition = definitions.get(random.nextInt(definitions.size()));
            String card = Runner.map.get(definition);

            System.out.println("Print the definition of \"" + card + "\":");

            String userDefinition = Runner.scanner.nextLine();

            if (definition.equals(userDefinition)) {
                System.out.println("Correct!");
            } else if (!definition.equals(userDefinition) && Runner.map.containsKey(userDefinition)) {
                System.out.println("Wrong. The right answer is \"" + definition + "\"" +
                        ", but your definition is correct for \"" + Runner.map.get(userDefinition) + "\".");
                Runner.stats.replace(card, Runner.stats.get(card) + 1);
            } else {
                System.out.println("Wrong. The right answer is \"" + definition + "\".");
                Runner.stats.replace(card, Runner.stats.get(card) + 1);
            }

        }

    }
}
