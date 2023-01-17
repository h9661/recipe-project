package chanwoo.recipe.project.converters;

import chanwoo.recipe.project.commands.NotesCommand;
import chanwoo.recipe.project.domain.Notes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NotesCommandToNotesTest {

    NotesCommandToNotes notesCommandToNotesConverter;

    @BeforeEach
    void setUp() {
        notesCommandToNotesConverter = new NotesCommandToNotes();
    }

    @Test
    void convert() {
        NotesCommand notesCommand = new NotesCommand();
        notesCommand.setId(1L);

        Notes notes = notesCommandToNotesConverter.convert(notesCommand);

        assertEquals(notes.getId(), notesCommand.getId());
    }
}