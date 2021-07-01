data class Post(
    val id: Int,
    var owner_id: Int,
    var from_id: Int,
    var created_by: Int,
    val date: Int,
    var text: String,
    var reply_owner_id: Int,
    var reply_post_id: Int,
    var friends_only: Int = 1,
    var post_type: String,
    var signer_id: Int,
    var can_pinval : Boolean,
    var can_delete : Boolean,
    var can_edit : Boolean,
    var is_pinned : Boolean,
    var marked_as_ads : Boolean,
    var is_favorite : Boolean,
    var postponed_id: Int
)

fun main() {

}