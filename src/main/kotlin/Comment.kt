class Comments(
    val count: Int,
    val can_post: Boolean,
    val groups_can_post: Boolean,
    val can_close: Boolean,
    val can_open: Boolean
)

class Comment(
    val owner_id: Int,
    val post_id: Int,
    var from_group: Int = 0,
    var message: String,
    var reply_to_comment: Int,
    val attachments: Attachment?,
    val sticker_id: Int,
    val guid: String
)

class Report(
    val owner_id: Int,
    val comment_id: Int,
    val reason: Int
)
