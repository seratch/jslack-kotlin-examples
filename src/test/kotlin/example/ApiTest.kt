package example

import com.github.seratch.jslack.Slack
import org.slf4j.LoggerFactory
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class ApiTest {

    private val logger = LoggerFactory.getLogger(javaClass)

    private val slack = Slack.getInstance()

    @Test
    fun foo() {
        val response = slack.methods().apiTest { it.foo("bar") }
        logger.info("response: {}", response)
        assertNull(response.error)
    }

    @Test
    fun error() {
        val response = slack.methods().apiTest { it.error("something_wrong") }
        logger.info("response: {}", response)
        assertEquals("something_wrong", response.error)
    }

}
