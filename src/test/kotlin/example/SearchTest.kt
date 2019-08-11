package example

import com.github.seratch.jslack.Slack
import org.slf4j.LoggerFactory
import kotlin.test.Test
import kotlin.test.assertNull

class SearchTest {

    private val logger = LoggerFactory.getLogger(javaClass)

    private val userToken = System.getenv("SLACK_TEST_OAUTH_ACCESS_TOKEN")
    private val slack = Slack.getInstance()

    @Test
    fun searchAll() {
        val response = slack.methods(userToken).searchAll {
            it.highlight(true)
                    .query("Searchable Log of All Conversation and Knowledge")
                    .count(5)
                    .page(2)
        }
        assertNull(response.error)

        logger.info("files: {}", response.files.matches)
        logger.info("messages: {}", response.messages.matches)
        logger.info("posts: {}", response.posts.matches)
    }

}
