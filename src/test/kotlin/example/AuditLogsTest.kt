package example

import com.github.seratch.jslack.Slack
import kotlin.test.Test
import kotlin.test.assertNull

class AuditLogsTest {

    private val adminUserToken = System.getenv("SLACK_TEST_ADMIN_OAUTH_ACCESS_TOKEN")
    private val slack = Slack.getInstance()

    @Test
    fun schemas() {
        val schemasResponse = slack.audit(adminUserToken).schemas
        assertNull(schemasResponse.error)
    }

    @Test
    fun actions() {
        val schemasResponse = slack.audit(adminUserToken).actions
        assertNull(schemasResponse.error)
    }

    @Test
    fun getLogs() {
        val schemasResponse = slack.audit(adminUserToken).getLogs { it.action("user_login").limit(5) }
        assertNull(schemasResponse.error)
    }

}
