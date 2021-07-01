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
            "Text",
            7,
            false,
            false,
            false,
            false,
            false,
            false,
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
            "Text",
            7,
            false,
            false,
            false,
            false,
            false,
            false,
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
            "Text",
            7,
            false,
            false,
            false,
            false,
            false,
            false,
            7)

        val result = service.update(update)

        assertTrue(result)
    }

    @Test
    fun updateNotExisting() {

        val service = WallService
        val post = Post(3,
            1,
            2,
            3,
            4,
            "Original Text",
            6,
            7,
            1,
            "Text",
            7,
            false,
            false,
            false,
            false,
            false,
            false,
            7)

        service.add(post)
        service.add(post)
        service.add(post)
        service.add(post)
        service.add(post)

        val update = Post(23,
            3,
            2,
            3,
            4,
            "Original Text",
            6,
            7,
            1,
            "Text",
            7,
            false,
            false,
            false,
            false,
            false,
            false,
            7)

        val result = service.update(update)

        assertFalse(result)
    }

}