package org.example.backtesttask.entity;

import jakarta.persistence.*; // Import Jakarta Persistence API for working with entities and databases
import lombok.*; // Import Lombok annotations for boilerplate code reduction
import javax.validation.constraints.NotEmpty; // Import validation annotations
import java.time.LocalDateTime; // Import for handling date and time

@Entity // Marks this class as a JPA entity
@AllArgsConstructor // Lombok annotation to generate an all-args constructor
@NoArgsConstructor // Lombok annotation to generate a no-args constructor
@Getter // Lombok annotation to generate getter methods
@Setter // Lombok annotation to generate setter methods
public class NoteEntity {

    @Id // Indicates the primary key of the entity
    @GeneratedValue(strategy = GenerationType.AUTO) // Specifies primary key generation strategy
    @Column(nullable = false, updatable = false) // Specifies column properties
    private Long id; // Unique identifier for each note

    @NotEmpty // Validation constraint to ensure the field is not empty
    @Column(nullable = false, updatable = true) // Specifies column properties
    private String noteTitle; // Title of the note

    @NotEmpty // Validation constraint to ensure the field is not empty
    @Column(nullable = false, updatable = true) // Specifies column properties
    private String noteContent; // Content of the note

    @NotEmpty // Validation constraint to ensure the field is not empty
    @Column(nullable = false, updatable = true) // Specifies column properties
    private LocalDateTime noteDate; // Date and time when the note was created

    @Override
    public String toString() { // Overrides the default toString method
        return "NoteEntity{" +
                "id=" + id +
                ", noteTitle='" + noteTitle + '\'' +
                ", noteContent='" + noteContent + '\'' +
                ", noteDate=" + noteDate +
                '}';
    }
}
