package org.example.backtesttask.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.example.backtesttask.entity.NoteEntity;
import org.example.backtesttask.repository.NoteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service // Marks this class as a Spring service
@Transactional // Manages transactions for the methods in this class
@AllArgsConstructor // Lombok annotation to generate an all-args constructor
public class NoteService {

    private final NoteRepository noteRepository; // Repository to perform CRUD operations

    public NoteEntity addNote(NoteEntity note) {
        note.setNoteDate(LocalDateTime.now()); // Set current date and time for the note
        return noteRepository.save(note); // Save the new note
    }

    public List<NoteEntity> findAllNotes() {
        return noteRepository.findAll(); // Retrieve all notes
    }

    // Finds a note by its ID, returns an Optional to avoid null issues such as NullPointerException
    public Optional<NoteEntity> findNoteById(Long id) {
        return noteRepository.findNoteEntityById(id);
    }

    public void deleteNoteById(Long id) {
        noteRepository.deleteNoteEntityById(id); // Delete a note by its ID
    }

    public NoteEntity updateNoteById(Long id, NoteEntity updatedNote) {
        // Find the current note by ID, throw an exception if not found
        NoteEntity currentNote = noteRepository.findNoteEntityById(id)
                .orElseThrow(() -> new EntityNotFoundException("Note not found with id: " + id));

        // Update the current note's fields with the new values
        currentNote.setNoteTitle(updatedNote.getNoteTitle());
        currentNote.setNoteContent(updatedNote.getNoteContent());
        currentNote.setNoteDate(LocalDateTime.now()); // Update the date to the current time

        return noteRepository.save(currentNote); // Save the updated note
    }
}
