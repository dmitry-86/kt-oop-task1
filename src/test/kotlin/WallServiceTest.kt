import org.junit.Test

import org.junit.Assert.*

class WallServiceTest {

    @Test
    fun add() {
        val service = WallService

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

        service.add(post)
        service.add(post)
        service.add(post)
        service.add(post)
        service.add(post)

        val result = service.add(post)

        assertEquals(5, result.id)
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