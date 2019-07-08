package example

import com.github.seratch.jslack.Slack
import org.slf4j.LoggerFactory
import kotlin.test.Test
import kotlin.test.assertNull

class UsersTest {

    private val logger = LoggerFactory.getLogger(javaClass)

    private val botToken = System.getenv("SLACK_BOT_USER_TEST_OAUTH_ACCESS_TOKEN")
    private val slack = Slack.getInstance()

    @Test
    fun usersList() {
        val response = slack.methods().usersList { it.token(botToken).limit(100) }
        assertNull(response.error)

        logger.info("users: {}", response.members.map { it.name })
    }

}
