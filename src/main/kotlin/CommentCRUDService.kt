interface CommentCRUDService<E, C> {

    fun createComment(element: E, comment: C): Int//Добавляет новый комментарий к заметке.
    fun deleteComment(element: E, comment: C): Boolean //Удаляет комментарий к заметке.
    fun editComment(element: E, comment: C, editedMessage: String): Boolean //Редактирует указанный комментарий у заметки.
    fun getComments(element: E): MutableList<C>//Возвращает список комментариев к заметке.
    fun restoreComment(element: E, comment: C): Boolean//Восстанавливает удалённый комментарий.

}