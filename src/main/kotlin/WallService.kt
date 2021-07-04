object WallService {

    private var posts = emptyArray<Post>()
    private var attachments = emptyArray<Attachment>()



    fun add(post: Post): Post {
        var uniqueId = post.id
        for (pst in posts) {
            if (pst.id == uniqueId) {
                uniqueId++
            }
        }
        posts += post.copy(id = uniqueId)
        return posts.last()
    }

    fun add(attachment: Attachment): Attachment{
        attachments+=attachment
        return attachments.last()
    }

    fun update(post: Post): Boolean {
        var isPostExists = false
        for ((index, existingPost) in posts.withIndex()) {
            if (existingPost.id == post.id) {
                posts[index] = post.copy(
                    owner_id = post.owner_id + 1,
                    from_id = post.from_id + 1,
                    created_by = post.created_by + 1,
                    text = "Some Text",
                    reply_owner_id = post.reply_owner_id + 1,
                    reply_post_id = post.reply_post_id + 1,
                    friends_only = post.friends_only,
                    post_type = post.post_type,
                    signer_id = post.signer_id,
                    can_pinval = post.can_pinval,
                    can_delete = false,
                    can_edit = false,
                    is_pinned = post.is_pinned,
                    marked_as_ads = post.marked_as_ads,
                    is_favorite = post.is_favorite,
                    postponed_id = post.postponed_id
                )
                isPostExists = true
            }
        }
        return isPostExists
    }

    fun audioAttachment(attachment: Attachment){
        if(attachment !is AudioAttachment) {
            //TODO
        }else{
            val audio = attachment.audio
        }
    }

    fun videoAttachment(attachment: Attachment){
        if(attachment !is VideoAttachment) {
            //TODO
        }else{
            val video = attachment.video
        }
    }

    fun photoAttachment(attachment: Attachment){
        if(attachment !is PhotoAttachment) {
            //TODO
        }else{
            val photo = attachment.photo
        }
    }

    fun albumAttachment(attachment: Attachment){
        if(attachment !is AlbumAttachment) {
            //TODO
        }else{
            val album = attachment.album
        }
    }

    fun docAttachment(attachment: Attachment){
        if(attachment !is DocAttachment) {
            //TODO
        }else{
            val doc = attachment.doc
        }
    }


//    fun print() {
//        for (post in posts) {
//            println(post)
//        }
//    }

}

