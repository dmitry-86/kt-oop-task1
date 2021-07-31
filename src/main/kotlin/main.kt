data class Post(
    val id: Int,
    val owner_id: Int,
    val from_id: Int,
    val created_by: Int,
    val date: Int,
    val text: String,
    val reply_owner_id: Int,
    val reply_post_id: Int,
    val friends_only: Int = 1,
    val comments: Comments?,
    val copyright: Copyright?,
    val likes: Likes?,
    val reposts: Reposts?,
    val views: Views?,
    val post_type: String,
    val post_source: PostSource?,
    val attachment: Attachment?,
    val geo: Geo?,
    val signer_id: Int,
    val can_pinval : Boolean,
    val can_delete : Boolean,
    val can_edit : Boolean,
    val is_pinned : Boolean,
    val marked_as_ads : Boolean,
    val is_favorite : Boolean,
    val donut: Donut?,
    val postponed_id: Int
)

class Copyright(
    val id: Int,
    val link: String,
    val name: String,
    val type: String
)

class Likes(
    val count: Int,
    val user_likes: Boolean,
    val can_like: Boolean,
    val can_publish: Boolean
)

class Reposts(
    val count: Int,
    val user_reposted: Boolean
)

class Views(
    val count: Int
)

class PostSource(
    val type: String,
    val platform: String,
    val data: String,
    val url: String
)

class Geo(
    val type: String,
    val coordinates: String
)

class Donut(
    val is_donut: Boolean,
    val paid_duration: Boolean,
    val placeholder: String,
    val can_publish_free_copy: Boolean,
    val edit_mode: String
)

fun main() {

    val chat1 = Chat(1, 2)
    val chat2 = Chat(2, 2)
    val msg = Message(1, 1, 1, "Privet", false)
    val msg2 = Message(2, 1, 1, "Как дела?", false)
    val msg3 = Message(2, 1, 1, "Как дела?", false)

    val service = ChatService
    service.addMessage(1,  chat1, msg)
    service.addMessage(1, chat1, msg2)
    service.addMessage(1, chat1, msg3)
    service.addMessage(2, chat2, msg3)

    service.print()
    //service.delete(1, msg)
    //service.print()
    service.edit(1, 1,  msg2, "Что делаешь?")
    service.print()
    //service.removeChat(1)
    println(service.getUnreadChatsCount(1, 1))
    println(service.getChats(1))
    println(service.getListOfMessages(1, 1, 1, 2))
}