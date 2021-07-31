import java.lang.RuntimeException

class ChatNotFoundException(message: String) : RuntimeException(message)
class MessageNotFoundException(message: String) : RuntimeException(message)

data class Chat(
    var user_id: Int = 0,
    val chat_id: Int,
    val messages: MutableList<Message> = mutableListOf()
)

data class Message(
    val message_id: Int,
    var chat_id: Int=0,
    val user_id: Int = 0,
    var text: String,
    var unread: Boolean = true,
    val incomingMsg: Boolean = true
)

object ChatService{

    val chats = mutableListOf<Chat>()

    //получить чат по его id
    fun getChatById(userId: Int, chatId: Int): Chat =
        chats.filter{it.user_id == userId}.findLast { it.chat_id == chatId }!!
        //chats.filter { it.chat_id == chtId }.last() // предполагается что у чата уникальный id


    // количество непрочитанных чатов, в котором есть хотя бы 1 непрочитанное сообщение
    fun getUnreadChatsCount(userId:Int, chatId: Int): Int {
        return chats.filter{getChatById(userId, chatId).messages.filter { it.unread }.isNotEmpty()}.size
    }

    //Получить список чатов, где в каждом чате есть последнее сообщение
    fun getChats(chatId: Int): Any {
        val lst: (Int) -> List<Chat> = { id -> chats.filter { it.messages.isNotEmpty() }}
        return if(lst(chatId).isNotEmpty()){
            lst(chatId)
        }else{
            "нет сообщений"
        }
    }

    //Получить список сообщений из чата, указав id чата, id последнего сообщения, количество сообщений
    fun getListOfMessages(userId:Int, chatId: Int, lastMsgId:Int, numberOfMessages: Int): List<Message> {
        getChatById(userId, chatId).messages.forEach{ it.unread = false}
        return getChatById(userId, chatId).messages.filter { it.message_id<=lastMsgId}
    }

    fun removeChat(userId:Int, chatId: Int){
        if(chats.contains(getChatById(userId, chatId))){
            chats.remove(getChatById(userId, chatId))
        }else{
            throw ChatNotFoundException("Chat does not exist")
        }
    }

    // работа с сообщеними

    fun addMessage(userId: Int, chat: Chat, message: Message) {

        if(chat.messages.isEmpty()){
            val lastChatId = if(chats.isEmpty()){
                0
            }else{
                chats.last().chat_id
            }
            chats.add(chat.copy(chat_id = lastChatId+1))
        }
        chats.filter { it.user_id == userId }
        chat.messages.add(message)
    }

    fun delete(userId: Int, chatId: Int, element: Message) {
        if(chats.contains(getChatById(userId, chatId))) {
            getChatById(userId, chatId).messages.remove(element)
            if (getChatById(userId, chatId).messages.isEmpty()) {
                chats.remove(getChatById(userId, chatId))
            }
        }else{
            throw ChatNotFoundException("Chat does not exist")
        }
    }

    fun edit(userId: Int, chatId: Int, message: Message, editedText:String) {
        if(!chats.contains(getChatById(userId, chatId))) {
            throw ChatNotFoundException("Chat does not exist")
        }else if(!getChatById(userId, chatId).messages.contains(message)){
            throw MessageNotFoundException("Message does not exist")
        }else{
            getChatById(userId, chatId).messages
            message.text = editedText
        }
    }

        fun print() {
        for (chat in chats) {
            println(chat)
        }
    }

}