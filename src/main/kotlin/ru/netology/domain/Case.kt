package ru.netology.domain

abstract class CaseGeneric<T>(var item: T, var listItem: MutableList<T>) : CRUDService<T> {

    override fun add(item: T) {
        listItem.add(item)
    }
    override fun getById(id: Int): T {
        return listItem[id]
    }
//    override fun edit(id: Int, item: T) {
//        listItem[id] = item
//    }
}


class CaseNote(item: Note, listItem: MutableList<Note>) : CaseGeneric<Note>(item, listItem) {

    override fun delete(id: Int) {
        listItem[id].isDeleted = true
        listItem[id].comments?.isDeleted = true
    }

    override fun edit(id: Int, item: Note) {
        if (!listItem[id].isDeleted) {
            listItem[id] = item
        } else {
            throw ObjectNotFoundException("Нельзя редактировать удаленный объект")
        }
    }
}

class CaseNoteComment(item: NoteComment, listItem: MutableList<NoteComment>) :
    CaseGeneric<NoteComment>(item, listItem) {

    override fun delete(id: Int) {
        listItem[id].isDeleted = true
    }

    override fun edit(id: Int, item: NoteComment) {
        if (!listItem[id].isDeleted) {
            listItem[id] = item
        } else {
            throw ObjectNotFoundException("Нельзя редактировать удаленный объект")
        }
    }
}



