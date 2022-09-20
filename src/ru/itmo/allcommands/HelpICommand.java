package ru.itmo.allcommands;

import ru.itmo.exceptoins.WrongAmountOfElementsException;
import ru.itmo.utility.Console;

/**
 * Command 'help'. It's here just for logical structure.
 */
public class HelpICommand extends AbstractICommand {

    public HelpICommand() {
        super("help", "вывести справку по доступным командам");
    }

    /**
     * Executes the command.
     * @return Command exit status.
     */
    @Override
    public boolean execute(String argument) {
        try {
            if (!argument.isEmpty()) throw new WrongAmountOfElementsException();
            return true;
        } catch (WrongAmountOfElementsException exception) {
            Console.println("Использование: '" + getName() + "'");
        }
        return false;
    }
}
