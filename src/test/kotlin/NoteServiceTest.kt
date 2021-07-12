import org.junit.Test

import org.junit.Assert.*

class NoteServiceTest {

    private val note = Note(1, 2, "new note", "text", 4, 5, 6, 1, false)
    private val comment = Comment(1, 1, 1, 1, 2, "new text", 2, null, 2, "", false)

    @Test
    fun add() {
        val service = NoteService
        val result = service.add(note.copy(note_id = 2))

        assertEquals(2, result)
    }

    @Test
    fun delete() {
        val service = NoteService
        service.add(note)
        val note2 = note.copy(note_id = 2)
        service.add(note2)
        service.add(note.copy(note_id = 3))
        service.add(note.copy(note_id = 4))
        val result = service.delete(note2)

        assertTrue(result)

    }

    @Test
    fun edit() {
        val service = NoteService
        service.add(note)
        val note2 = note.copy(note_id = 2)
        service.add(note2)
        service.add(note.copy(note_id = 3))
        service.add(note.copy(note_id = 4))
        val result = service.edit(note2, "title", "text")

        assertTrue(result)

    }

    @Test
    fun get() {

        val service = NoteService
        val newNote = Note(5, 2, "new note", "text", 3, 5, 6, 1, false)

        service.add(newNote.copy(note_id = 1))
        val newNote2 = newNote.copy(note_id = 9)
        service.add(newNote2)
        val newNote3 = newNote.copy(note_id = 10)
        service.add(newNote3)
        val result = service.get(3)

        assertEquals(mutableListOf(newNote, newNote2, newNote3), result)

    }

    @Test
    fun getById() {
        val service = NoteService
        service.add(note)
        service.add(note.copy(note_id = 2))
        service.add(note.copy(note_id = 3))
        service.add(note.copy(note_id = 4))
        val result = service.getById(4)
        assertSame(4, result.note_id)
    }

    @Test
    fun createComment() {
        val service = NoteService
        val note4 = note.copy(note_id = 4)
        service.add(note4)
        val comment4 = comment.copy(cid = 2, message = "Новый комментарий")
        val result = service.createComment(note4, comment4)
        assertEquals(2, result)
    }

    @Test(expected = NoteNotFoundException::class)
    fun createCommentThrows() {
        val service = NoteService
        val note5 = note.copy(note_id = 30)
        service.createComment(note5, comment.copy(cid = 2, message = "Новый комментарий"))
    }


    @Test
    fun deleteComment() {
        val service = NoteService
        val note13 = note.copy(note_id = 13)
        service.add(note13)
        val comment1 = comment.copy(nid = 1, message = "Новый комментарий")
        val comment2 = comment.copy(nid = 2, message = "Новый комментарий")
        val comment3 = comment.copy(nid = 3, message = "Новый комментарий")

        service.createComment(note13, comment1)
        service.createComment(note13, comment2)
        service.createComment(note13, comment3)
        val result = service.deleteComment(note13, comment2)
        assertTrue(result)
    }

    @Test
    fun editComment() {
        val service = NoteService
        service.add(note)
        service.createComment(note, comment)
        var newComment = comment.copy(message = "Новый комментарий")
        service.createComment(note, newComment)
        val editedMessage = "Какой-то текст"
        val result = service.editComment(note, newComment, editedMessage)
        assertTrue(result)
    }

    @Test
    fun getComments() {
        val service = NoteService
        val note15 = note.copy(note_id = 15)
        service.add(note15)
        val comment5 = comment.copy(nid = 12, message = "text1")
        val comment6 = comment.copy(nid = 12, message = "text2")
        val comment7 = comment.copy(nid = 12, message = "text3")
        service.createComment(note15, comment5)
        service.createComment(note15, comment6)
        service.createComment(note15, comment7)
        val result = service.getComments(note15)

        assertEquals(mutableListOf(comment5, comment6, comment7), result)

    }

    @Test
    fun restoreComment() {
        val service = NoteService
        val note14 = note.copy(note_id = 14)
        service.add(note14)
        service.createComment(note14, comment)
        val newComment = comment.copy(message = "Новый комментарий")
        service.createComment(note14, newComment)
        val result = service.restoreComment(note, newComment)
        assertTrue(result)

    }
}