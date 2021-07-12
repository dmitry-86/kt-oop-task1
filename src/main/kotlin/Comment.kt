class Comments(
    val count: Int,
    val can_post: Boolean,
    val groups_can_post: Boolean,
    val can_close: Boolean,
    val can_open: Boolean
)

data class Comment(
    val cid: Int,
    val owner_id: Int,
    val post_id: Int,
    val nid: Int,
    var from_group: Int = 0,
    var message: String,
    var reply_to_comment: Int,
    val attachments: Attachment?,
    val sticker_id: Int,
    val guid: String,
    var isDeleted: Boolean = false
)

class Report(
    val owner_id: Int,
    val comment_id: Int,
    val reason: Int
)


data class Note(
    val note_id: Int,
    val owner_id: Int,
    var title: String,
    var text: String,
    val user_id: Int,
    val offset: Int = 0,
    val count: Int = 20,
    val sort: Int,
    val need_wiki: Boolean,
    var comment: MutableList<Comment> = mutableListOf()
    //val privacy_view: Array<String>, //?
    //val privacy_comment: Array<String> //?
)