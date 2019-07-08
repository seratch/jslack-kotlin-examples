package example

import com.github.seratch.jslack.Slack
import com.github.seratch.jslack.api.model.block.ActionsBlock
import com.github.seratch.jslack.api.model.block.composition.PlainTextObject
import com.github.seratch.jslack.api.model.block.element.ButtonElement
import com.github.seratch.jslack.api.webhook.Payload
import org.slf4j.LoggerFactory
import kotlin.test.Test
import kotlin.test.assertEquals

class IncomingWebhooksTest {

    private val logger = LoggerFactory.getLogger(javaClass)
    private val webhookUrl = System.getenv("SLACK_WEBHOOK_TEST_URL")
    private val slack = Slack.getInstance()

    @Test
    fun send() {
        val response = slack.send(webhookUrl, """{"text":"Hello!"}""")
        logger.info("response: {}", response)

        assertEquals(200, response.code)
        assertEquals("ok", response.body)
    }

    @Test
    fun sendText() {
        val payload = Payload.builder().text("Hello!").build()
        val response = slack.send(webhookUrl, payload)
        logger.info("response: {}", response)

        assertEquals(200, response.code)
        assertEquals("ok", response.body)
    }

    @Test
    fun sendBlocks() {
        val blocks = listOf(ActionsBlock.builder()
                .elements(listOf(
                        ButtonElement.builder()
                                .text(PlainTextObject.builder().text("Farmhouse").build())
                                .value("click_me_123")
                                .build()
                ))
                .build())

        val payload = Payload.builder().blocks(blocks).build()
        val response = slack.send(webhookUrl, payload)
        logger.info("response: {}", response)

        assertEquals(200, response.code)
        assertEquals("ok", response.body)
    }

}
