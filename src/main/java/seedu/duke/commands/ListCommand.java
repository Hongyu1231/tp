package seedu.duke.commands;

import seedu.duke.equipment.Equipment;
import seedu.duke.equipmentlist.EquipmentList;
import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;
import seedu.duke.ui.UiTable;
import seedu.duke.ui.UiTableRow;

import java.util.stream.IntStream;

public class ListCommand extends Command {

    public ListCommand() {
    }

    @Override
    public void execute(EquipmentList equipments, Ui ui, Storage storage) {
        UiTable table = new UiTable();

        IntStream.range(0, equipments.getSize())
                .mapToObj(i -> new UiTableRow(equipments.getEquipment(i)))
                .forEach(table::addRow);

        ui.showMessage("Here are the equipments in your list:");
        ui.showMessage(table.toString().trim());
    }
}
