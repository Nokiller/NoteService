package ru.netology.domain


object NotesService {

    internal var notesList: MutableList<Note> = mutableListOf()
    internal var commentsList: MutableList<NoteComment> = mutableListOf()


    fun clear() {
        notesList.clear()
        commentsList.clear()
    }
}


fun main() {

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

    val noteCase = CaseNote(note,NotesService.notesList)
    println(NotesService.notesList)

    noteCase.add(note)
    println(NotesService.notesList)

    noteCase.add(note2)
    println(NotesService.notesList)

    val commentCase = CaseNoteComment(comment1, NotesService.commentsList)
    println(NotesService.commentsList)

    commentCase.add(comment1)
    println(NotesService.commentsList)

    commentCase.add(comment2)
    println(NotesService.commentsList)


    noteCase.edit(0, note2)
    println(NotesService.notesList)

    commentCase.edit(0, comment2)
    println(NotesService.commentsList)

    commentCase.delete(1)
    println(NotesService.commentsList)

//    noteCase.delete(1)
    println(NotesService.notesList)

}