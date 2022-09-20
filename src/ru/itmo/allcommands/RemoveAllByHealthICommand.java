package ru.itmo.allcommands;
import ru.itmo.spaceMarine.SpaceMarine;
import ru.itmo.exceptoins.MarineNotFoundException;
import ru.itmo.exceptoins.WrongAmountOfElementsException;
import ru.itmo.exceptoins.CollectionIsEmptyException;
import ru.itmo.utility.CollectionManager;
import ru.itmo.utility.Console;

/**
 * Command 'remove_by_health'. Removes the element by its ID.
 */
public class RemoveAllByHealthICommand extends AbstractICommand {
    private CollectionManager collectionManager;

    public RemoveAllByHealthICommand(CollectionManager collectionManager) {
        super("remove_by_health <health>", "удалить элемент из коллекции по health");
        this.collectionManager = collectionManager;
    }

    /**
     * Executes the command.
     * @return Command exit status.
     */
    @Override
    public boolean execute(String argument) {
        try {
            if (argument.isEmpty()) throw new WrongAmountOfElementsException();
            if (collectionManager.collectionSize() == 0) throw new CollectionIsEmptyException();

            Long health = Long.parseLong(argument);
            for (SpaceMarine spaceMarine: collectionManager.getCollection()) {
                if (spaceMarine.getHealth() == health) collectionManager.removeFromCollection(spaceMarine);
            }
            Console.println("Все солдаты с health=" + health + " были удалены.");
            return true;
        } catch (WrongAmountOfElementsException exception) {
            Console.println("Использование: '" + getName() + "'");
        } catch (CollectionIsEmptyException exception) {
            Console.printerror("Коллекция пуста!");
        } catch (NumberFormatException exception) {
            Console.printerror("Health должен быть представлен числом!");
        }
        return false;
    }
}
