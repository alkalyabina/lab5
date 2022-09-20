package ru.itmo.allcommands;

import ru.itmo.exceptoins.WrongAmountOfElementsException;
import ru.itmo.utility.Console;

/**
 * Command 'exit'. Checks for wrong arguments then do nothing.
 */
public class ExitICommand extends AbstractICommand {

    public ExitICommand() {
        super("exit", "завершить программу (без сохранения в файл)");
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
