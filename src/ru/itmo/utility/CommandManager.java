package ru.itmo.utility;

import java.util.ArrayList;
import java.util.List;

import ru.itmo.allcommands.ICommand;

/**
 * Operates the commands.
 */
public class CommandManager {
    private List<ICommand> ICommands = new ArrayList<>();
    private ICommand helpICommand;
    private ICommand infoICommand;
    private ICommand showICommand;
    private ICommand addICommand;
    private ICommand updateIDICommand;
    private ICommand removeAllByHealthICommand;
    private ICommand clearICommand;
    private ICommand saveICommand;
    private ICommand exitICommand;
    private ICommand executeScriptICommand;
    private ICommand addIfMinICommand;
    private ICommand addIfMaxICommand;
    private ICommand removeLowerICommand;
    private ICommand removeByIDICommand;
    private ICommand filterGreaterThanChapterICommand;
    private ICommand maxByIDICommand;


    public CommandManager(ICommand helpICommand, ICommand infoICommand, ICommand showICommand, ICommand addICommand, ICommand updateIDICommand,
                          ICommand removeAllByHealthICommand, ICommand clearICommand, ICommand saveICommand, ICommand exitICommand, ICommand executeScriptICommand,
                          ICommand addIfMinICommand, ICommand addIfMaxICommand, ICommand removeLowerICommand,ICommand removeByIDICommand, ICommand filterGreaterThanChapterICommand, ICommand maxByIDICommand) {
        this.helpICommand = helpICommand;
        this.infoICommand = infoICommand;
        this.showICommand = showICommand;
        this.addICommand = addICommand;
        this.updateIDICommand = updateIDICommand;
        this.removeAllByHealthICommand = removeAllByHealthICommand;
        this.clearICommand = clearICommand;
        this.saveICommand = saveICommand;
        this.exitICommand = exitICommand;
        this.executeScriptICommand = executeScriptICommand;
        this.addIfMinICommand = addIfMinICommand;
        this.addIfMaxICommand = addIfMaxICommand;
        this.removeLowerICommand = removeLowerICommand;
        this.removeByIDICommand = removeByIDICommand;
        this.filterGreaterThanChapterICommand = filterGreaterThanChapterICommand;
        this.maxByIDICommand = maxByIDICommand;

        ICommands.add(helpICommand);
        ICommands.add(infoICommand);
        ICommands.add(showICommand);
        ICommands.add(addICommand);
        ICommands.add(updateIDICommand);
        ICommands.add(removeAllByHealthICommand);
        ICommands.add(clearICommand);
        ICommands.add(saveICommand);
        ICommands.add(exitICommand);
        ICommands.add(executeScriptICommand);
        ICommands.add(addIfMinICommand);
        ICommands.add(addIfMaxICommand);
        ICommands.add(removeLowerICommand);
        ICommands.add(removeByIDICommand);
        ICommands.add(filterGreaterThanChapterICommand);
        ICommands.add(maxByIDICommand);
    }


    /**
     * Prints that command is not found.
     * @param command Comand, which is not found.
     * @return Command exit status.
     */
    public boolean noSuchCommand(String command) {
        Console.println("Команда '" + command + "' не найдена. Наберите 'help' для справки.");
        return false;
    }

    /**
     * Prints info about the all commands.
     * @param argument Its argument.
     * @return Command exit status.
     */
    public boolean help(String argument) {
        if (helpICommand.execute(argument)) {
            for (ICommand ICommand : ICommands) {
                Console.printtable(ICommand.getName(), ICommand.getDescription());
            }
            return true;
        } else return false;
    }

    /**
     * Executes needed command.
     * @param argument Its argument.
     * @return Command exit status.
     */
    public boolean info(String argument) {
        return infoICommand.execute(argument);
    }

    /**
     * Executes needed command.
     * @param argument Its argument.
     * @return Command exit status.
     */
    public boolean show(String argument) {
        return showICommand.execute(argument);
    }

    /**
     * Executes needed command.
     * @param argument Its argument.
     * @return Command exit status.
     */
    public boolean add(String argument) {
        return addICommand.execute(argument);
    }

    /**
     * Executes needed command.
     * @param argument Its argument.
     * @return Command exit status.
     */
    public boolean update(String argument) {
        return updateIDICommand.execute(argument);
    }

    /**
     * Executes needed command.
     * @param argument Its argument.
     * @return Command exit status.
     */
    public boolean removeByHealth(String argument) {
        return removeAllByHealthICommand.execute(argument);
    }

    /**
     * Executes needed command.
     * @param argument Its argument.
     * @return Command exit status.
     */
    public boolean clear(String argument) {
        return clearICommand.execute(argument);
    }

    /**
     * Executes needed command.
     * @param argument Its argument.
     * @return Command exit status.
     */
    public boolean save(String argument) {
        return saveICommand.execute(argument);
    }

    /**
     * Executes needed command.
     * @param argument Its argument.
     * @return Command exit status.
     */
    public boolean exit(String argument) {
        return exitICommand.execute(argument);
    }

    /**
     * Executes needed command.
     * @param argument Its argument.
     * @return Command exit status.
     */
    public boolean executeScript(String argument) {
        return executeScriptICommand.execute(argument);
    }

    /**
     * Executes needed command.
     * @param argument Its argument.
     * @return Command exit status.
     */
    public boolean addIfMin(String argument) {
        return addIfMinICommand.execute(argument);
    }

    /**
     * Executes needed command.
     * @param argument Its argument.
     * @return Command exit status.
     */
    public boolean addIfMax(String argument) {
        return addIfMaxICommand.execute(argument);
    }

    /**
     * Executes needed command.
     * @param argument Its argument.
     * @return Command exit status.
     */
    public boolean removeLower(String argument) {
        return removeLowerICommand.execute(argument);
    }
    /**
     * Executes needed command.
     * @param argument Its argument.
     * @return Command exit status.
     */
    public boolean removeByID(String argument) {
        return removeByIDICommand.execute(argument);
    }

    /**
     * Executes needed command.
     * @param argument Its argument.
     * @return Command exit status.
     */
    public boolean filterGreaterThanChapter(String argument) {
        return filterGreaterThanChapterICommand.execute(argument);
    }

    /**
     * Executes needed command.
     * @param argument Its argument.
     * @return Command exit status.
     */
    public boolean maxByID(String argument) {
        return maxByIDICommand.execute(argument);
    }



    @Override
    public String toString() {
        return "CommandManager (вспомогательный класс для работы с командами)";
    }
}
