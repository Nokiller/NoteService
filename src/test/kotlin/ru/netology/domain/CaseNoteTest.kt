package ru.netology.domain

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class CaseNoteTest {

    @Before
    fun clearBeforeTest() {
        NotesService.clear()
    }

    @Test
    fun deleteNote() {

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
        noteCase.delete(0)
        val result = NotesService.notesList[0].isDeleted

        // assert
        assertEquals(true, result)
    }

    @Test
    fun deleteComment() {

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
        val commentCase = CaseNoteComment(comment1, NotesService.commentsList)

        // act
        noteCase.add(note)
        commentCase.add(comment1)
        commentCase.delete(0)
        val result1 = NotesService.commentsList[0].isDeleted
        val result2 = NotesService.notesList[0].comments?.isDeleted

        // assert
        assertEquals(true, result1)
        assertEquals(true, result2)
    }

    @Test
    fun editNote() {
        val comment1 = NoteComment(0, "0", "111", null, "Test message")
        val comment2 = NoteComment(1, "0", "222", null, "Test message 2")

        val note = Note(
            id = 0,
            title = "Test1",
            text = "Test1 text",
            date = 1663613504,
            privacy = "0",
            comments = comment1
        )
        val note2 = Note(
            id = 1,
            title = "Test2",
            text = "Test2 text",
            date = 1663613504,
            privacy = "0",
            comments = comment2
        )
        val noteCase = CaseNote(note, NotesService.notesList)

        // act
        noteCase.add(note)
        noteCase.edit(0, note2)
        val result = NotesService.notesList[0].title

        // assert
        assertEquals("Test2", result)
    }
    @Test
    fun editNoteFail() {
        val comment1 = NoteComment(0, "0", "111", null, "Test message")
        val comment2 = NoteComment(1, "0", "222", null, "Test message 2")

        val note = Note(
            id = 0,
            title = "Test1",
            text = "Test1 text",
            date = 1663613504,
            privacy = "0",
            comments = comment1
        )
        val note2 = Note(
            id = 1,
            title = "Test2",
            text = "Test2 text",
            date = 1663613504,
            privacy = "0",
            comments = comment2
        )
        val noteCase = CaseNote(note, NotesService.notesList)

        // act
        noteCase.add(note)
        noteCase.edit(0, note2)
        val result = NotesService.notesList[0].title

        // assert
        assertEquals("Test2", result)
    }

    @Test
    fun editComment() {
        val comment1 = NoteComment(0, "0", "111", null, "Test message")
        val comment2 = NoteComment(1, "0", "222", null, "Test message 2")
        val note = Note(
            id = 0,
            title = "Test1",
            text = "Test1 text",
            date = 1663613504,
            privacy = "0",
            comments = comment1
        )
        val noteCase = CaseNote(note, NotesService.notesList)
        val commentCase = CaseNoteComment(comment1, NotesService.commentsList)

        // act
        noteCase.add(note)
        commentCase.add(comment1)

        commentCase.edit(0, comment2)
        val result = NotesService.commentsList[0].message

        // assert
        assertEquals("Test message 2", result)
    }
}