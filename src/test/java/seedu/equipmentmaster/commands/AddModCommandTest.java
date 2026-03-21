package seedu.equipmentmaster.commands;

import org.junit.jupiter.api.Test;
import seedu.equipmentmaster.exception.EquipmentMasterException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * JUnit tests for the {@code AddModCommand} class, focusing on the parsing logic.
 */
public class AddModCommandTest {

    @Test
    public void parse_validInput_returnsCommand() throws EquipmentMasterException {
        // Arrange
        String validInput = "addmod n/CG2111A pax/150";

        // Act
        AddModCommand command = AddModCommand.parse(validInput);

        // Assert
        assertNotNull(command);
    }

    @Test
    public void parse_missingPaxPrefix_throwsException() {
        // Arrange
        String invalidInput = "addmod n/CG2111A 150"; // Missing "pax/"

        // Act & Assert
        EquipmentMasterException thrown = assertThrows(EquipmentMasterException.class, () -> {
            AddModCommand.parse(invalidInput);
        });

        // Optionally verify the exception message
        assertEquals("Invalid command format. \nExpected: addmod n/NAME pax/QTY", thrown.getMessage());
    }

    @Test
    public void parse_nonIntegerPax_throwsException() {
        // Arrange
        String invalidInput = "addmod n/CG2111A pax/abc"; // "abc" is not a number

        // Act & Assert
        assertThrows(EquipmentMasterException.class, () -> {
            AddModCommand.parse(invalidInput);
        });
    }

    @Test
    public void constructor_negativePax_throwsException() {
        // Arrange
        String moduleName = "CG2111A";
        int negativePax = -5;

        // Act & Assert
        assertThrows(EquipmentMasterException.class, () -> {
            new AddModCommand(moduleName, negativePax);
        });
    }
}