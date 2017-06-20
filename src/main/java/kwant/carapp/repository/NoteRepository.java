package kwant.carapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kwant.carapp.model.Note;

public interface NoteRepository extends JpaRepository<Note, Long> {

}
