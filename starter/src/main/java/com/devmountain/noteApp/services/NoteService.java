package com.devmountain.noteApp.services;

import com.devmountain.noteApp.dtos.NoteDto;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface NoteService {
    // adding note
    @Transactional
    void addNote(NoteDto noteDto, Long userId);

    // deleting note by ID
    @Transactional
    void deleteNoteById(Long noteId);

    //updating a note by ID
    @Transactional
    void updateNoteById(NoteDto noteDto);

    // get notes by user id
    @Transactional
    List<NoteDto> getAllNoteByUserId(Long userId);

    // get note by note id
    @Transactional
    Optional<NoteDto> getNoteById(Long noteId);
}
