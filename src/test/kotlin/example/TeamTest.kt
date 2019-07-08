package example

import com.github.seratch.jslack.Slack
import org.slf4j.LoggerFactory
import kotlin.test.Test
import kotlin.test.assertNull

class TeamTest {

    private val logger = LoggerFactory.getLogger(javaClass)

    private val userToken = System.getenv("SLACK_TEST_OAUTH_ACCESS_TOKEN")
    private val botToken = System.getenv("SLACK_BOT_USER_TEST_OAUTH_ACCESS_TOKEN")
    private val slack = Slack.getInstance()

    @Test
    fun teamInfo() {
        val response = slack.methods().teamInfo { it.token(botToken) }
        logger.info("response: {}", response)
        assertNull(response.error)
    }

    @Test
    fun teamBillableInfo() {
        val response = slack.methods().teamBillableInfo { it.token(userToken) }
        logger.info("response: {}", response)
        assertNull(response.error)
    }

}
