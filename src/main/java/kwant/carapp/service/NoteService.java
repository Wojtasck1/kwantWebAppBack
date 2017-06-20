package kwant.carapp.service;

import java.util.List;

import kwant.carapp.model.Note;

public interface NoteService {

	public void delete(Long noteId);

	public List<Note> findAll();

	public Note save(Note note);

	public Note findNote(Long noteId);

	public Note update(Note note);
}
