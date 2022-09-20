package ru.itmo.allcommands;
/**
 * Interface for all commands.
 */
public interface ICommand {
        String getDescription();
        String getName();
        boolean execute(String argument);
}
