package flashcards.commands;

import flashcards.Runner;
import flashcards.interfaces.Command;

public class Add implements Command {

    @Override
    public void perform() {

        String card = "";
        String definition = "";

        System.out.println("The card:");
        card = Runner.scanner.nextLine();

        if (Runner.map.containsValue(card)) {
            System.out.println("The card \"" + card + "\" already exists.");
            return;
        }

        System.out.println("The definition of the card:");
        definition = Runner.scanner.nextLine();

        if (Runner.map.containsKey(definition)) {
            System.out.println("The definition \"" + definition + "\" already exists.");
            return;
        }

        Runner.map.put(definition, card);
        Runner.stats.put(card, 0);
        System.out.println("The pair (\"" + card + "\":\"" + definition + "\") has been added.");

    }
}
