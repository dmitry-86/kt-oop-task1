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