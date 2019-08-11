package example

import com.github.seratch.jslack.Slack
import org.slf4j.LoggerFactory
import kotlin.test.Test
import kotlin.test.assertNull

class EmojiTest {

    private val logger = LoggerFactory.getLogger(javaClass)

    private val userToken = System.getenv("SLACK_TEST_OAUTH_ACCESS_TOKEN")
    private val slack = Slack.getInstance()

    @Test
    fun emojiList() {
        val response = slack.methods(userToken).emojiList { it }
        assertNull(response.error)

        logger.info("custom emoji list: {}", response.emoji.map { it.key })
    }

}
