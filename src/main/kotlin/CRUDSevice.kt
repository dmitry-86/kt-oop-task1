interface CRUDSevice<E> {

    fun add(element: E): Int //Создает новую заметку у текущего пользователя.
    fun delete(element: E): Boolean  //Удаляет заметку текущего пользователя.
    fun edit(element: E, editedTitle: String, editedText:String): Boolean //Редактирует заметку текущего пользователя.
    fun get(id: Int): List<Note> //Возвращает список заметок, созданных пользователем.
    fun getById(id: Int): Note //Возвращает заметку по её id.

    fun createComment(element: E, comment: Comment): Int//Добавляет новый комментарий к заметке.
    fun deleteComment(element: E, comment: Comment): Boolean //Удаляет комментарий к заметке.
    fun editComment(element: E, comment: Comment, editedMessage: String): Boolean //Редактирует указанный комментарий у заметки.
    fun getComments(element: E): MutableList<Comment>//Возвращает список комментариев к заметке.
    fun restoreComment(element: E, comment: Comment): Boolean//Восстанавливает удалённый комментарий.

 }