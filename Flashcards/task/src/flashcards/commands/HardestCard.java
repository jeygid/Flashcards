package flashcards.commands;

import flashcards.Runner;
import flashcards.interfaces.Command;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

public class HardestCard implements Command {

    @Override
    public void perform() {

        ArrayList<String> hardestCards = new ArrayList<>();
        ArrayList<Integer> statsValues = new ArrayList<>(Runner.stats.values());

        if (statsValues.isEmpty()) {
            System.out.println("There are no cards with errors.");
            return;
        }

        int max = Collections.max(statsValues);

        if (max == 0) {
            System.out.println("There are no cards with errors.");
            return;
        }

        for (Map.Entry<String, Integer> entry : Runner.stats.entrySet()) {
            if (entry.getValue() == max) {
                hardestCards.add(entry.getKey());
            }
        }

        if (hardestCards.size() == 1) {
            System.out.println("The hardest card is \"" + hardestCards.get(0) + "\"." +
                    " You have " + max + " errors answering it");
        } else {
            StringBuilder hardest = new StringBuilder();

            for (String card : hardestCards) {
                hardest.append("\"" + card + "\", ");
            }

            System.out.println("The hardest cards are " + hardest.substring(0, hardest.length() - 2) + "." +
                    " You have " + max + " errors answering them.");
        }

    }
}
