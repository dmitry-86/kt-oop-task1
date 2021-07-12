import java.lang.RuntimeException

class NoteNotFoundException(message: String) : RuntimeException(message)

object NoteService : CRUDSevice<Note>, CommentCRUDService<Note, Comment> {

    private var notes = mutableListOf<Note>()

    //Создает новую заметку у текущего пользователя.
    override fun add(element: Note): Int {
        var uniqueId = element.note_id
        for (n in notes) {
            if (n.note_id == uniqueId) {
                uniqueId++
            }
        }
        notes.add(element.copy(note_id = uniqueId))
        return element.note_id
    }

    //Удаляет заметку текущего пользователя.
    override fun delete(element: Note): Boolean {
        var isDeleted = false
        if (notes.contains(element)) {
            notes.remove(element)
            isDeleted = true
        }
        return isDeleted
    }

    //Редактирует заметку текущего пользователя.
    override fun edit(element: Note, editedTitle: String, editedText: String): Boolean {
        var isNoteEdited = false
        for ((index, note) in notes.withIndex()) {
            if (element.note_id == note.note_id) {
                notes[index].title = editedTitle
                notes[index].text = editedText
                isNoteEdited = true
            }
        }
        return isNoteEdited
    }

    //Возвращает список заметок, созданных пользователем.
    override fun get(id: Int): List<Note> { // список заметок созданных пользователем
        return notes.filter { it.user_id == id }
    }

    //Возвращает заметку по её id.
    override fun getById(id: Int): Note {
        return notes.find { it.note_id == id }!!
    }

    //Добавляет новый комментарий к заметке.
    override fun createComment(element: Note, comment: Comment): Int {
        if (notes.contains(element)) {
            for (n in notes) {
                if (n.note_id == element.note_id) {
                    element.comment.add(comment)
                }
            }
            return comment.cid
        } else {
            throw NoteNotFoundException("Note with id: ${element.note_id} was not found")
        }
    }

    //Удаляет комментарий к заметке.
    override fun deleteComment(element: Note, comment: Comment): Boolean {
        if (notes.contains(element) || !comment.isDeleted) {
            for (cmmnt in element.comment) {
                cmmnt.isDeleted = true
            }
            return true
        } else {
            throw NoteNotFoundException("Note with id: ${element.note_id} was not found or comment is deleted")
        }

    }

    //Редактирует указанный комментарий у заметки.
    override fun editComment(element: Note, comment: Comment, editedMessage: String): Boolean {
        if (notes.contains(element) || !comment.isDeleted) {
            if (!element.comment.isNullOrEmpty()) {
                for (cmmnt in element.comment) {
                    cmmnt.message = editedMessage
                }
            }
            return true
        } else {
            throw NoteNotFoundException("Note with id: ${element.note_id} was not found or comment is deleted")
        }
    }

    //Возвращает список комментариев к заметке.
    override fun getComments(element: Note): MutableList<Comment> {
        return element.comment.filter { !it.isDeleted } as MutableList<Comment>
    }

    //Восстанавливает удалённый комментарий
    override fun restoreComment(element: Note, comment: Comment): Boolean {
        if (notes.contains(element) || !comment.isDeleted) {
            if (!element.comment.isNullOrEmpty()) {
                for (cmmnt in element.comment) {
                    cmmnt.isDeleted = false
                }
            }
            return true
        } else {
            throw NoteNotFoundException("Note with id: ${element.note_id} was not found or comment is deleted")
        }
    }

}


