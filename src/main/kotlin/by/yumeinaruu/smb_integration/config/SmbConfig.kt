package by.yumeinaruu.smb_integration.config

import by.yumeinaruu.smb_integration.config.propierties.ApplicationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.integration.smb.session.SmbSessionFactory


@Configuration
class SmbConfig(
    private val applicationProperties: ApplicationProperties,
) {

    @Bean
    fun smbSessionFactory(): SmbSessionFactory {
        return SmbSessionFactory().apply {
            host = applicationProperties.host
            port = applicationProperties.port
            domain = applicationProperties.domain
            username = applicationProperties.username
            password = applicationProperties.password
            shareAndDir = applicationProperties.shareAndDir
        }
    }
}