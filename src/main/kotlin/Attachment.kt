interface Attachment{
    val type: String
    //второе поле зависит от типа
}

class AudioAttachment(
    override val type: String = "audio",
    val audio: Audio
): Attachment

class Audio(
    val id: Int,
    val album_id: Int,
    val owner_id: Int,
    val user_id: Int
)

class VideoAttachment(
    override val type: String = "video",
    val video: Video
): Attachment

class Video(
    val id: Int,
    val owner_id: Int,
    val title: String,
    val description: String,
    val duration: Int,
    val date: Int,
    val adding_date: Int,
    val views: Int
)

class PhotoAttachment(
    override val type: String = "photo",
    val photo: Photo
): Attachment

class Photo(
    val id: Int,
    val owner_id: Int,
    val photo_130: String,
    val photo_604: String
)

class AlbumAttachment(
    override val type: String = "album",
    val album: Album
): Attachment

class Album(
    val id: Int,
    val owner_id: Int,
    val title: String,
    val description: String,
    val created: Int,
    val updated: Int,
    val size: Int
)

class DocAttachment(
    override val type: String,
    val doc: Doc
): Attachment

class Doc(
    val id: Int,
    val owner_id: Int,
    val title: String,
    val size: Int,
    val ext: String,
    val url: String,
    val date: Int,
    val type: Int
)
