package org.example.backtesttask.repository;

import org.example.backtesttask.entity.NoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// Repository interface for NoteEntity, providing basic CRUD operations
public interface NoteRepository extends JpaRepository<NoteEntity, Long> {

    // Custom method to delete a note by its id
    void deleteNoteEntityById(Long id);

    // Custom method to find a note by its id
    Optional<NoteEntity> findNoteEntityById(Long id);

}
