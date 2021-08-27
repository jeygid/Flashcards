package flashcards.commands;

import flashcards.Runner;
import flashcards.interfaces.Command;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Remove implements Command {

    @Override
    public void perform() {

        System.out.println("Which card?");

        List<String> cards = new ArrayList<>(Runner.map.values());

        String userCard = Runner.scanner.nextLine();

        if (!cards.contains(userCard)) {
            System.out.println("Can't remove \"" + userCard + "\": there is no such card.");
            return;
        }

        String userDefinition = "";

        for (Map.Entry<String, String> entry : Runner.map.entrySet()) {
            if (entry.getValue().equals(userCard)) {
                userDefinition = entry.getKey();
            }
        }

        Runner.stats.remove(Runner.map.get(userDefinition));
        Runner.map.remove(userDefinition);
        System.out.println("The card has been removed");
    }
}
