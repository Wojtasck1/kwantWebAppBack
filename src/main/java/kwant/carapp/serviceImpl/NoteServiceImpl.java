package kwant.carapp.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kwant.carapp.model.Note;
import kwant.carapp.repository.NoteRepository;
import kwant.carapp.service.NoteService;

@Service
public class NoteServiceImpl implements NoteService {

	@Autowired
	NoteRepository noteRepository;

	@Override
	public void delete(Long noteId) {
		noteRepository.delete(noteId);
	}

	@Override
	public List<Note> findAll() {
		return noteRepository.findAll();
	}

	@Override
	public Note save(Note note) {
		return noteRepository.saveAndFlush(note);
	}

	@Override
	public Note findNote(Long noteId) {
		return noteRepository.findOne(noteId);
	} 

	@Override
	public Note update(Note note) {
		return noteRepository.saveAndFlush(note);
	}
	
}
