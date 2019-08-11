package example

import com.github.seratch.jslack.Slack
import kotlin.test.Test
import kotlin.test.assertNull

class AuditLogsTest {

    private val adminUserToken = System.getenv("SLACK_TEST_ADMIN_OAUTH_ACCESS_TOKEN")
    private val slack = Slack.getInstance()

    @Test
    fun schemas() {
        val response = slack.audit(adminUserToken).schemas
        assertNull(response.error)
    }

    @Test
    fun actions() {
        val response = slack.audit(adminUserToken).actions
        assertNull(response.error)
    }

    @Test
    fun getLogs() {
        val response = slack.audit(adminUserToken).getLogs { it.action("user_login").limit(5) }
        assertNull(response.error)
    }

}
