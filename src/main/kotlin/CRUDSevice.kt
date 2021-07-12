interface CRUDSevice<E> {

    fun add(element: E): Int //Создает новую заметку у текущего пользователя.
    fun delete(element: E): Boolean  //Удаляет заметку текущего пользователя.
    fun edit(element: E, editedTitle: String, editedText:String): Boolean //Редактирует заметку текущего пользователя.
    fun get(id: Int): List<E> //Возвращает список заметок, созданных пользователем.
    fun getById(id: Int): E //Возвращает заметку по её id.

 }