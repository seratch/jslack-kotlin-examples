package example

import com.github.seratch.jslack.Slack
import com.github.seratch.jslack.shortcut.model.ApiToken
import com.github.seratch.jslack.shortcut.model.ChannelName
import org.slf4j.LoggerFactory
import kotlin.test.Test
import kotlin.test.assertNull

class PinsTest {

    private val logger = LoggerFactory.getLogger(javaClass)

    private val userToken = System.getenv("SLACK_TEST_OAUTH_ACCESS_TOKEN")
    private val slack = Slack.getInstance()

    @Test
    fun filesList() {
        val channelId = slack.shortcut(ApiToken.of(userToken)).findChannelIdByName(ChannelName.of("general"))
        val response = slack.methods(userToken).pinsList { it.channel(channelId.get().value) }
        assertNull(response.error)

        logger.info("item types: {}", response.items.map { it.type })
    }

}
