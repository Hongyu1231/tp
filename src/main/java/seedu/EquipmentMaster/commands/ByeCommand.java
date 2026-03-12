package seedu.EquipmentMaster.commands;

import seedu.EquipmentMaster.equipmentlist.EquipmentList;
import seedu.EquipmentMaster.storage.Storage;
import seedu.EquipmentMaster.ui.Ui;

/**
 * Represents a command that terminates the program.
 * When executed, it displays a goodbye message to the user
 * and signals that the application should exit.
 */
public class ByeCommand extends Command {

    /**
     * Executes the bye command by displaying a goodbye message.
     *
     * @param equipments The equipment list (not used in this command).
     * @param ui The user interface used to display the goodbye message.
     * @param storage The storage system (not used in this command).
     */
    @Override
    public void execute(EquipmentList equipments, Ui ui, Storage storage) {
        ui.showGoodByeMessage();
    }

    /**
     * Returns true to indicate that the program should terminate.
     *
     * @return {@code true} since this command exits the program.
     */
    @Override
    public boolean isExit() {
        return true;
    }
}
