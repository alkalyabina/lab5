package ru.itmo.allcommands;

import java.util.Date;

import ru.itmo.spaceMarine.*;
import ru.itmo.exceptoins.CollectionIsEmptyException;
import ru.itmo.exceptoins.IncorrectInputInScriptException;
import ru.itmo.exceptoins.MarineNotFoundException;
import ru.itmo.exceptoins.WrongAmountOfElementsException;
import ru.itmo.utility.CollectionManager;
import ru.itmo.utility.Console;
import ru.itmo.utility.MarineAsker;

/**
 * Command 'update ID'. Updates the information about selected marine.
 */
public class UpdateIDICommand extends AbstractICommand {
    private CollectionManager collectionManager;
    private MarineAsker marineAsker;

    public UpdateIDICommand(CollectionManager collectionManager, MarineAsker marineAsker) {
        super("update_by_id <ID> {element}", "обновить значение элемента коллекции по ID");
        this.collectionManager = collectionManager;
        this.marineAsker = marineAsker;
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

            Integer id =  Integer.parseInt(argument);
            SpaceMarine oldMarine = collectionManager.getById(id);
            if (oldMarine == null) throw new MarineNotFoundException();

            String name = oldMarine.getName();
            Coordinates coordinates = oldMarine.getCoordinates();
            Date creationDate = oldMarine.getCreationDate();
            Long health = oldMarine.getHealth();
            double height = oldMarine.getHeight();
            Weapon weaponType =oldMarine.getWeaponType();
            AstartesCategory category = oldMarine.getCategory();
            Chapter chapter = oldMarine.getChapter();

            collectionManager.removeFromCollection2(oldMarine);

            if (marineAsker.askQuestion("Хотите изменить имя солдата?")) name = marineAsker.askName();
            if (marineAsker.askQuestion("Хотите изменить координаты солдата?")) coordinates = marineAsker.askCoordinates();
            if (marineAsker.askQuestion("Хотите изменить здоровье солдата?")) health = marineAsker.askHealth();
            if (marineAsker.askQuestion("Хотите изменить рост солдата?")) height = marineAsker.askHeight();
            if (marineAsker.askQuestion("Хотите изменить категорию солдата?")) category = marineAsker.askCategory();
            if (marineAsker.askQuestion("Хотите изменить оружие солдата?")) weaponType = marineAsker.askWeaponType();
            if (marineAsker.askQuestion("Хотите изменить подразделение солдата?")) chapter = marineAsker.askChapter();


            collectionManager.addToCollection(new SpaceMarine(
                    id,
                    name,
                    coordinates,
                    creationDate,
                    health,
                    height,
                    category,
                    weaponType,
                    chapter
            ));
            Console.println("Солдат успешно изменен!");
            return true;
        } catch (WrongAmountOfElementsException exception) {
            Console.println("Использование: '" + getName() + "'");
        } catch (CollectionIsEmptyException exception) {
            Console.printerror("Коллекция пуста!");
        } catch (NumberFormatException exception) {
            Console.printerror("ID должен быть представлен числом!");
        } catch (MarineNotFoundException exception) {
            Console.printerror("Солдата с таким ID в коллекции нет!");
        } catch (IncorrectInputInScriptException exception) {}
        return false;
    }
}
