package ru.netology.domain

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class CaseGenericTest {

    @Before
    fun clearBeforeTest() {
        NotesService.clear()
    }

    @Test
    fun addNote() {

        val comment1 = NoteComment(0, "0", "111", null, "Test message")
        val note = Note(
            id = 0,
            title = "Test1",
            text = "Test1 text",
            date = 1663613504,
            privacy = "0",
            comments = comment1
        )
        val noteCase = CaseNote(note, NotesService.notesList)

        // act
        noteCase.add(note)
        val result = NotesService.notesList[0].id

        // assert
        assertEquals(0, result)
    }

    @Test
    fun addComment() {

        val comment1 = NoteComment(0, "0", "111", null, "Test message")
        val commentCase = CaseNoteComment(comment1, NotesService.commentsList)

        // act
        commentCase.add(comment1)
        val result = NotesService.commentsList[0].id

        // assert
        assertEquals(0, result)
    }

    @Test
    fun getNoteById() {
        val comment1 = NoteComment(0, "0", "111", null, "Test message")
        val note = Note(
            id = 0,
            title = "Test1",
            text = "Test1 text",
            date = 1663613504,
            privacy = "0",
            comments = comment1
        )
        val noteCase = CaseNote(note, NotesService.notesList)
        noteCase.add(note)

        // act
        val result = noteCase.getById(0)

        // assert
        assertEquals(NotesService.notesList[0], result)
    }

    @Test
    fun getCommentById() {
        val comment1 = NoteComment(0, "0", "111", null, "Test message")
        val commentCase = CaseNoteComment(comment1, NotesService.commentsList)

        // act
        commentCase.add(comment1)
        val result = commentCase.getById(0)

        // assert
        assertEquals(NotesService.commentsList[0], result)
    }
}

