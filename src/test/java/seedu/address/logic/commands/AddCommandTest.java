package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Predicate;

import org.junit.jupiter.api.Test;

import javafx.collections.ObservableList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.AddressBook;
import seedu.address.model.Model;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.ReadOnlyUserPrefs;
import seedu.address.model.consultation.Consultation;
import seedu.address.model.contact.Contact;
import seedu.address.model.medical.Medical;
import seedu.address.model.patient.Patient;
import seedu.address.model.prescription.Prescription;
import seedu.address.model.testresult.TestResult;
import seedu.address.testutil.PersonBuilder;

public class AddCommandTest {

    @Test
    public void constructor_nullPerson_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new AddCommand(null));
    }

    @Test
    public void execute_personAcceptedByModel_addSuccessful() throws Exception {
        ModelStubAcceptingPersonAdded modelStub = new ModelStubAcceptingPersonAdded();
        Patient validPatient = new PersonBuilder().build();

        CommandResult commandResult = new AddCommand(validPatient).execute(modelStub);

        assertEquals(String.format(AddCommand.MESSAGE_SUCCESS, validPatient), commandResult.getFeedbackToUser());
        assertEquals(Arrays.asList(validPatient), modelStub.personsAdded);
    }

    @Test
    public void execute_duplicatePerson_throwsCommandException() {
        Patient validPatient = new PersonBuilder().build();
        AddCommand addCommand = new AddCommand(validPatient);
        ModelStub modelStub = new ModelStubWithPerson(validPatient);

        assertThrows(CommandException.class, AddCommand.MESSAGE_DUPLICATE_PERSON, () -> addCommand.execute(modelStub));
    }

    @Test
    public void equals() {
        Patient alice = new PersonBuilder().withName("Alice").build();
        Patient bob = new PersonBuilder().withName("Bob").build();
        AddCommand addAliceCommand = new AddCommand(alice);
        AddCommand addBobCommand = new AddCommand(bob);

        // same object -> returns true
        assertTrue(addAliceCommand.equals(addAliceCommand));

        // same values -> returns true
        AddCommand addAliceCommandCopy = new AddCommand(alice);
        assertTrue(addAliceCommand.equals(addAliceCommandCopy));

        // different types -> returns false
        assertFalse(addAliceCommand.equals(1));

        // null -> returns false
        assertFalse(addAliceCommand.equals(null));

        // different person -> returns false
        assertFalse(addAliceCommand.equals(addBobCommand));
    }

    /**
     * A default model stub that have all of the methods failing.
     */
    private class ModelStub implements Model {
        @Override
        public void setUserPrefs(ReadOnlyUserPrefs userPrefs) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ObservableList<Patient> getPersonList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ReadOnlyUserPrefs getUserPrefs() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public GuiSettings getGuiSettings() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setGuiSettings(GuiSettings guiSettings) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public Path getAddressBookFilePath() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setAddressBookFilePath(Path addressBookFilePath) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void addPerson(Patient patient) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void addPrescription(Prescription prescription) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void deletePrescription(Prescription target) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean hasPrescription(Prescription prescription) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setPrescription(Prescription target, Prescription editedPrescription) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setAddressBook(ReadOnlyAddressBook newData) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ReadOnlyAddressBook getAddressBook() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean hasPerson(Patient patient) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean hasPerson(Predicate<Patient> predicate) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void deleteConsultation(Consultation target) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void addConsultation(Consultation consultation) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean hasConsultation(Consultation consultation) {
            throw new AssertionError("This method should not be called.");
        }



        @Override
        public void deletePerson(Patient target) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setPerson(Patient target, Patient editedPatient) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setConsultation(Consultation target, Consultation edited) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ObservableList<Patient> getFilteredPersonList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ObservableList<Prescription> getFilteredPrescriptionList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ObservableList<Consultation> getFilteredConsultationList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ObservableList<Medical> getFilteredMedicalList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void updateFilteredPersonList(Predicate<Patient> predicate) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void updateFilteredConsultationList(Predicate<Consultation> predicate) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void updateFilteredPrescriptionList(Predicate<Prescription> predicate) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void updateFilteredMedicalList(Predicate<Medical> predicate) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void addContact(Contact contact) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean hasContact(Contact contact) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void deleteContact(Contact target) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setContact(Contact target, Contact editedContact) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ObservableList<Contact> getFilteredContactList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void updateFilteredContactList(Predicate<Contact> predicate) {
            throw new AssertionError("This method should not be called.");
        }

        @Override

        public void addTestResult(TestResult testResult) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void addMedical(Medical medical) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean hasTestResult(TestResult testResult) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void deleteTestResult(TestResult target) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setTestResult(TestResult target, TestResult editedTestResult) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ObservableList<TestResult> getFilteredTestResultList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void updateFilteredTestResultList(Predicate<TestResult> predicate) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean hasMedical(Medical medical) {
            throw new AssertionError("This method should not be called.");
        }


        @Override
        public void deleteMedical(Medical target) {
            throw new AssertionError("This method should not be called.");
        }

    }

    /**
     * A Model stub that contains a single person.
     */
    private class ModelStubWithPerson extends ModelStub {
        private final Patient patient;

        ModelStubWithPerson(Patient patient) {
            requireNonNull(patient);
            this.patient = patient;
        }

        @Override
        public boolean hasPerson(Patient patient) {
            requireNonNull(patient);
            return this.patient.isSamePerson(patient);
        }
    }

    /**
     * A Model stub that always accept the person being added.
     */
    private class ModelStubAcceptingPersonAdded extends ModelStub {
        final ArrayList<Patient> personsAdded = new ArrayList<>();
        final ArrayList<Medical> medicalsAdded = new ArrayList<Medical>();

        @Override
        public boolean hasPerson(Patient patient) {
            requireNonNull(patient);
            return personsAdded.stream().anyMatch(patient::isSamePerson);
        }

        @Override
        public void addPerson(Patient patient) {
            requireNonNull(patient);
            personsAdded.add(patient);
        }

        @Override
        public ReadOnlyAddressBook getAddressBook() {
            return new AddressBook();
        }

        @Override
        public void addMedical(Medical medical) {
            requireNonNull(medical);
            medicalsAdded.add(medical);
        }
    }

}
