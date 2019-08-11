package example

import com.github.seratch.jslack.Slack
import org.slf4j.LoggerFactory
import kotlin.test.Test
import kotlin.test.assertNull

class ConversationsTest {

    private val logger = LoggerFactory.getLogger(javaClass)

    private val userToken = System.getenv("SLACK_TEST_OAUTH_ACCESS_TOKEN")
    private val botToken = System.getenv("SLACK_BOT_USER_TEST_OAUTH_ACCESS_TOKEN")
    private val slack = Slack.getInstance()

    @Test
    fun userConversationsList() {
        conversationsList(userToken)
    }

    @Test
    fun botConversationsList() {
        conversationsList(botToken)
    }

    private fun conversationsList(token: String) {
        val response = slack.methods(token).conversationsList {
            it.excludeArchived(true).limit(1000)
        }
        logger.info("response: {}", response)
        assertNull(response.error)

        val activeConversations = response.channels.filter { !it.isArchived }
        val publicChannels = activeConversations.filter { it.isChannel && !it.isPrivate }
        val privateChannels = activeConversations.filter { (it.isChannel && it.isPrivate) || it.isGroup }

        logger.info("public: {}, private: {}", publicChannels.map { it.name }, privateChannels.map { it.name })
    }

}
