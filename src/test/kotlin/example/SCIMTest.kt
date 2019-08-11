package example

import com.github.seratch.jslack.Slack
import kotlin.test.Test
import kotlin.test.assertNotNull

class SCIMTest {

    private val adminUserToken = System.getenv("SLACK_TEST_ADMIN_OAUTH_ACCESS_TOKEN")
    private val slack = Slack.getInstance()

    @Test
    fun users() {
        val searchResponse = slack.scim(adminUserToken).searchUsers { it.count(5).filter("restricted eq '0'") }
        assert(searchResponse.resources.size <= 5)

        val userId = searchResponse.resources[0].id
        val readResponse = slack.scim(adminUserToken).readUser { it.id(userId) }
        assertNotNull(readResponse)
    }

    @Test
    fun groups() {
        val searchResponse = slack.scim(adminUserToken).searchGroups { it.count(5) }
        assert(searchResponse.resources.size <= 5)

        val groupId = searchResponse.resources[0].id
        val readResponse = slack.scim(adminUserToken).readGroup { it.id(groupId) }
        assertNotNull(readResponse)
    }

}
