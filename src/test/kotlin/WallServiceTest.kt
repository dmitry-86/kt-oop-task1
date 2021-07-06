import org.junit.Test

import org.junit.Assert.*

class WallServiceTest {

    val post = Post(0,
        1,
        2,
        3,
        4,
        "Original Text",
        6,
        7,
        1,
        null,
        null,
        null,
        null,
        null,
        "Text",
        null,
        null,
        null,
        7,
        false,
        false,
        false,
        false,
        false,
        false,
        null,
        7)

    @Test//(expected = PostNotFoundException::class)
    fun updateComment() {
        val service = WallService
        service.add(post)
        service.add(post)
        service.add(post)
        val postId = 2
        val comment = Comment(1, postId, 2, "comment", 5, null, 2, " ")
        service.createComment(comment)
    }

    @Test(expected = PostNotFoundException::class)
    fun shouldThrow(){
        val service = WallService
        service.add(post)
        service.add(post)
        service.add(post)
        service.add(post)
        service.add(post)
        val postId = 20
        val comment = Comment(10, postId, 2, "comment", 5, null,2, " ")
        service.createComment(comment)
    }

    @Test
    fun reportComment() {
        val service = WallService
        val comment = Comment(10, 2, 2, "comment", 5, null,2, " ")
        val report = Report(1,3,7)
        val result = service.reportComment(report, comment)
        assertTrue(result)
    }

    @Test(expected = ReasonNotFoundException::class)
    fun reportCommentShouldThrow() {
        val service = WallService
        val reason = 9
        val comment = Comment(10, 2, 2, "comment", 5, null,2, " ")
        val report = Report(1,3,reason)
        val result = service.reportComment(report, comment)
        assertTrue(result)
    }

    @Test
    fun add() {
        val service = WallService

        service.add(post)
        service.add(post)
        service.add(post)
        service.add(post)
        service.add(post)

        val result = service.add(post)
        assertEquals(13, result.id)
    }

    @Test
    fun updateExisting() {

        val service = WallService
        val post = Post(6,
            1,
            2,
            3,
            4,
            "Original Text",
            6,
            7,
            1,
            null,
            null,
            null,
            null,
            null,
            "Text",
            null,
            null,
            null,
            7,
            false,
            false,
            false,
            false,
            false,
            false,
            null,
            7)

        service.add(post)
        service.add(post)
        service.add(post)

        val update = Post(6,
            1,
            2,
            3,
            4,
            "Original Text",
            6,
            7,
            1,
            null,
            null,
            null,
            null,
            null,
            "Text",
            null,
            null,
            null,
            7,
            false,
            false,
            false,
            false,
            false,
            false,
            null,
            7)

        val result = service.update(update)

        assertTrue(result)
    }

    @Test
    fun updateNotExisting() {

        val service = WallService
        val post = Post(2,
            1,
            2,
            3,
            4,
            "Original Text",
            6,
            7,
            1,
            null,
            null,
            null,
            null,
            null,
            "Text",
            null,
            null,
            null,
            7,
            false,
            false,
            false,
            false,
            false,
            false,
            null,
            7)

        service.add(post)
        service.add(post)
        service.add(post)
        service.add(post)
        service.add(post)

        val update = Post(23,
            1,
            2,
            3,
            4,
            "Original Text",
            6,
            7,
            1,
            null,
            null,
            null,
            null,
            null,
            "Text",
            null,
            null,
            null,
            7,
            false,
            false,
            false,
            false,
            false,
            false,
            null,
            7)

        val result = service.update(update)

        assertFalse(result)
    }

}