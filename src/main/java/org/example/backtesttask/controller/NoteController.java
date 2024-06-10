package org.example.backtesttask.controller;

import lombok.AllArgsConstructor;
import org.example.backtesttask.entity.NoteEntity;
import org.example.backtesttask.service.NoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController // Marks this class as a REST controller
@AllArgsConstructor // Lombok annotation to generate an all-args constructor
public class NoteController {

    private final NoteService noteService; // Service to handle business logic

    @GetMapping("/notes") // Endpoint to get all notes
    public ResponseEntity<List<NoteEntity>> getAllNotes() {
        List<NoteEntity> notes = noteService.findAllNotes();
        return new ResponseEntity<>(notes, HttpStatus.OK); // Return notes with 200 OK status
    }

    @GetMapping("/notes/{id}") // Endpoint to get a note by its ID
    public ResponseEntity<Optional<NoteEntity>> getNoteById(@PathVariable("id") Long id) {
        Optional<NoteEntity> note = noteService.findNoteById(id);
        return new ResponseEntity<>(note, HttpStatus.OK); // Return the note with 200 OK status
    }

    @PostMapping("/notes") // Endpoint to add a new note
    public ResponseEntity<NoteEntity> addNotes(@Valid @RequestBody NoteEntity note) {
        NoteEntity newNote = noteService.addNote(note);
        return new ResponseEntity<>(newNote, HttpStatus.CREATED); // Return the created note with 201 Created status
    }

    @PutMapping("/notes/{id}") // Endpoint to update a note by its ID
    public ResponseEntity<NoteEntity> updateNoteById(@Valid @PathVariable("id") Long id, @RequestBody NoteEntity note) {
        NoteEntity updatedNote = noteService.updateNoteById(id, note);
        return new ResponseEntity<>(updatedNote, HttpStatus.CREATED); // Return the updated note with 201 Created status
    }

    @DeleteMapping("/notes/{id}") // Endpoint to delete a note by its ID
    public ResponseEntity<?> deleteNoteById(@PathVariable("id") Long id) {
        noteService.deleteNoteById(id);
        return new ResponseEntity<>(HttpStatus.OK); // Return 200 OK status
    }
}
