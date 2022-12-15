package ru.netology.domain

data class Note (
    var id: Int,
    //val ownerId: Int,
    var title: String,
    var text: String,
    val date: Int,
    var privacy: String = "0",
//    var commentPrivacy: String = "0",
//    var privacyView: String,
    var comments: NoteComment?,
//    var readComments: Int?,
//    var canComment: Boolean = true,
    var isDeleted: Boolean = false
 )

data class NoteComment(
    var id: Int,
    val noteId: String,
    val ownerId: String,
    val replyTo: String?,
    var message: String,
 //   val guid: String
    var isDeleted: Boolean = false
)