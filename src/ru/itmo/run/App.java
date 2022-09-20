package ru.itmo.run;

import ru.itmo.allcommands.*;
import ru.itmo.utility.*;

import java.util.Scanner;

/**
 * Main application class. Creates all instances and runs the program.
 *
 * @author Kalyabina Alexandra
        */
public class App {
    public static final String PS1 = "$ ";
    public static final String PS2 = "> ";

    public static void main(String[] args) {
        String filename = "Collection.json";
        try (Scanner userScanner = new Scanner(System.in)) {


            MarineAsker marineAsker = new MarineAsker(userScanner);
            FileManager fileManager = new FileManager(filename);
            CollectionManager collectionManager = new CollectionManager(fileManager);
            CommandManager commandManager = new CommandManager(
                    new HelpICommand(),
                    new InfoICommand(collectionManager),
                    new ShowICommand(collectionManager),
                    new AddICommand(collectionManager, marineAsker),
                    new UpdateIDICommand(collectionManager, marineAsker),
                    new RemoveAllByHealthICommand(collectionManager),
                    new ClearICommand(collectionManager),
                    new SaveICommand(collectionManager),
                    new ExitICommand(),
                    new ExecuteScriptICommand(),
                    new AddIfMinICommand(collectionManager, marineAsker),
                    new AddIfMaxICommand(collectionManager, marineAsker),
                    new RemoveLowerICommand(collectionManager,marineAsker),
                    new RemoveByIDICommand(collectionManager),
                    new FilterGreaterThanChapter(collectionManager),
                    new MaxByIDICommand(collectionManager)
                    );
            Console console = new Console(commandManager, userScanner, marineAsker);
            console.interactiveMode();
        }
    }
}