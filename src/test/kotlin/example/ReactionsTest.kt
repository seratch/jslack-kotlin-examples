package example

import com.github.seratch.jslack.Slack
import org.slf4j.LoggerFactory
import kotlin.test.Test
import kotlin.test.assertNull

class ReactionsTest {

    private val logger = LoggerFactory.getLogger(javaClass)

    private val userToken = System.getenv("SLACK_TEST_OAUTH_ACCESS_TOKEN")
    //private val botToken = System.getenv("SLACK_BOT_USER_TEST_OAUTH_ACCESS_TOKEN")
    private val slack = Slack.getInstance()

    @Test
    fun reactionsList() {
        val response = slack.methods(userToken).reactionsList { it.count(100) }
        assertNull(response.error)

        logger.info("items: {}", response.items.map {
            "${it.message.reactions.map { r -> r.name }} for ${it.message.ts}"
        })
    }

}
