package example

import com.github.seratch.jslack.Slack
import org.slf4j.LoggerFactory
import kotlin.test.Test
import kotlin.test.assertNull

class FilesTest {

    private val logger = LoggerFactory.getLogger(javaClass)

    private val userToken = System.getenv("SLACK_TEST_OAUTH_ACCESS_TOKEN")
    private val slack = Slack.getInstance()

    @Test
    fun filesList() {
        val response = slack.methods(userToken).filesList { it.count(100) }
        assertNull(response.error)

        logger.info("file names: {}", response.files.map { it.name })
    }

}
