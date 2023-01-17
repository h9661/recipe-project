package chanwoo.recipe.project.converters;

import chanwoo.recipe.project.commands.NotesCommand;
import chanwoo.recipe.project.domain.Notes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NotesToNotesCommandTest {

    NotesToNotesCommand notesToNotesCommandConverter;

    @BeforeEach
    void setUp() {
        notesToNotesCommandConverter = new NotesToNotesCommand();
    }

    @Test
    void convert() {
        Notes notes = new Notes();
        notes.setId(1L);

        NotesCommand notesCommand = notesToNotesCommandConverter.convert(notes);

        assertEquals(notes.getId(), notesCommand.getId());
    }
}