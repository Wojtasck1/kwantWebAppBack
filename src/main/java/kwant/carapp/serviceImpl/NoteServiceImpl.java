package kwant.carapp.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import kwant.carapp.repository.NoteRepository;
import kwant.carapp.service.NoteService;

public class NoteServiceImpl implements NoteService {

	@Autowired
	NoteRepository noteRepository;
	
}
