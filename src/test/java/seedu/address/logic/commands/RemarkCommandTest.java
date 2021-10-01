package seedu.address.logic.commands;


import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import org.junit.jupiter.api.Test;

import seedu.address.model.AddressBook;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.person.Person;
import seedu.address.model.person.Remark;


class RemarkCommandTest {
    private Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
    @Test
    void execute_test() {
        Person modelPerson = model.getFilteredPersonList().get(0);
        Person remarkedPerson = new Person(modelPerson.getName(), modelPerson.getPhone(),
                modelPerson.getEmail(), modelPerson.getAddress(), modelPerson.getTags(), new Remark("Pokemon Master")
                );
        RemarkCommand remarkCommand = new RemarkCommand(INDEX_FIRST_PERSON, "Pokemon Master");
        String expectedMessage = "Edited at index 0 with remark Pokemon Master";
        Model expectedModel = new ModelManager(new AddressBook(model.getAddressBook()), new UserPrefs());
        expectedModel.setPerson(model.getFilteredPersonList().get(0), remarkedPerson);
        CommandTestUtil.assertCommandSuccess(remarkCommand, model, expectedMessage, expectedModel);
    }
}
