package example

import com.github.seratch.jslack.Slack
import org.slf4j.LoggerFactory
import kotlin.test.Test
import kotlin.test.assertNull

class RemindersTest {

    private val logger = LoggerFactory.getLogger(javaClass)

    private val userToken = System.getenv("SLACK_TEST_OAUTH_ACCESS_TOKEN")
    private val slack = Slack.getInstance()

    @Test
    fun remindersList() {
        val response = slack.methods().remindersList { it.token(userToken) }
        logger.info("reminders: {}", response.reminders)
        assertNull(response.error)
    }

}
