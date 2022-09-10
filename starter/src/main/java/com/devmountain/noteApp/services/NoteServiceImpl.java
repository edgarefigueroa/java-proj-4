package com.devmountain.noteApp.services;

import com.devmountain.noteApp.dtos.NoteDto;
import com.devmountain.noteApp.entities.Note;
import com.devmountain.noteApp.entities.User;
import com.devmountain.noteApp.repositories.NoteRepository;
import com.devmountain.noteApp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteRepository noteRepository;
    @Autowired
    private UserRepository userRepository;

    // adding note
    @Override
    @Transactional
    public void addNote(NoteDto noteDto, Long userId){
        Optional<User> userOptional = userRepository.findById(userId);
        Note note = new Note(noteDto);
        userOptional.ifPresent(note::setUser);
        noteRepository.saveAndFlush(note);
    }

    // deleting note by ID
    @Override
    @Transactional
    public void deleteNoteById(Long noteId){
        Optional<Note> noteOptional = noteRepository.findById(noteId);
        noteOptional.ifPresent(note-> noteRepository.delete(note));
    }

    //updating a note by ID
    @Override
    @Transactional
    public void updateNoteById(NoteDto noteDto){
        Optional<Note> noteOptional = noteRepository.findById(noteDto.getId());
        noteOptional.ifPresent(note-> {
            note.setBody(noteDto.getBody());
            noteRepository.saveAndFlush(note);
        });
    }
    // get notes by user id
    @Override
    @Transactional
    public List<NoteDto> getAllNoteByUserId(Long userId){
        Optional<User> userOptional = userRepository.findById(userId);
        if(userOptional.isPresent()) {
            List<Note> noteList = noteRepository.findAllByUserEquals(userOptional.get());
            return noteList.stream().map(note-> new NoteDto(note)).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }
    // get note by note id
    @Override
    @Transactional
    public Optional<NoteDto> getNoteById(Long noteId){
        Optional<Note> noteOptional = noteRepository.findById(noteId);
        if(noteOptional.isPresent()){
            return Optional.of(new NoteDto(noteOptional.get()));
        }
        return  Optional.empty();
    }
}