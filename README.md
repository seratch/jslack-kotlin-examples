# Slack API examples in Kotlin

This is a collection of Slack API examples in Kotlin. 

https://github.com/seratch/jslack-kotlin-examples/tree/master/src/test/kotlin/example

All the examples in this repository use [jSlack](https://github.com/seratch/jslack), a well-maintained Java Slack API client.
If you have feedback or suggestions, raise a ticket [at the library's GitHub Issues](https://github.com/seratch/jslack/issues).

## Prerequisites

```bash
export SLACK_TEST_OAUTH_ACCESS_TOKEN=xoxp-00000000-00000000-00000000-00000000
export SLACK_BOT_USER_TEST_OAUTH_ACCESS_TOKEN=xoxb-00000000-00000000
export SLACK_WEBHOOK_TEST_URL=https://hooks.slack.com/services/T00000000/B00000000/D6apuEH80000000000000000
```

If you're an admin of Slack org/workspace, you can try AuditLogsTest and SCIMTest with the following env variable (required scopes: admin, auditlogs:read).

```bash
export SLACK_TEST_ADMIN_OAUTH_ACCESS_TOKEN=xoxp-00000000-00000000-00000000-00000000
```

## License

The MIT License