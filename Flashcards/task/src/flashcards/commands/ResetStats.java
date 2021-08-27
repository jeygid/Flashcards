package flashcards.commands;

import flashcards.Runner;
import flashcards.interfaces.Command;

import java.util.Map;

public class ResetStats implements Command {

    @Override
    public void perform() {

        for (Map.Entry<String, Integer> entry : Runner.stats.entrySet()) {
            Runner.stats.put(entry.getKey(), 0);
        }

        System.out.println("Card statistics have been reset.");
    }
}