package by.yumeinaruu.smb_integration

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
class SmbIntegrationApplication

fun main(args: Array<String>) {
    runApplication<SmbIntegrationApplication>(*args)
}
