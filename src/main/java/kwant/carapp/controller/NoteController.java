package kwant.carapp.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kwant.carapp.model.Car;
import kwant.carapp.model.Note;
import kwant.carapp.service.NoteService;
import kwant.carapp.serviceImpl.NoteServiceImpl;

@RestController
@RequestMapping("api/v1/")
public class NoteController {

	@Autowired
	NoteService noteService;
	
	@RequestMapping(value = "note", method = RequestMethod.GET)
	public List<Note> list() {
		return noteService.findAll();
	}

	@RequestMapping(value = "note", method = RequestMethod.POST)
	public Note create(@RequestBody Note note) {
		return noteService.save(note);
	}

	@RequestMapping(value = "note/{id}", method = RequestMethod.GET)
	public Note get(@PathVariable Long id) {
		return noteService.findNote(id);
	} 

	@RequestMapping(value = "note/{id}", method = RequestMethod.PUT)
	public Note update(@PathVariable Long id, @RequestBody Note note) {
		Note existingNote = noteService.findNote(id);
		BeanUtils.copyProperties(note, existingNote);
		return noteService.save(existingNote);
	}

	@RequestMapping(value = "note/{id}", method = RequestMethod.DELETE)
	public Note delete(@PathVariable Long id) {
		Note note = noteService.findNote(id); 
		noteService.delete(id);
		return note;
	}
}
