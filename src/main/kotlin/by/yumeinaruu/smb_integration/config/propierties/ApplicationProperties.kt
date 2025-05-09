package by.yumeinaruu.smb_integration.config.propierties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.MessageSource
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.support.ReloadableResourceBundleMessageSource


@Configuration
@EnableConfigurationProperties(
    ApplicationProperties::class
)
class ApplicationPropertiesConfiguration {

    @Bean
    fun messageSource(): MessageSource {

        return ReloadableResourceBundleMessageSource().also {
            it.setDefaultEncoding("UTF-8")
            it.addBasenames("classpath:messages")
        }
    }
}

@ConfigurationProperties(prefix = "yumeinaruu.smb")
data class ApplicationProperties(
    val host: String,
    val username: String,
    val password: String,
    val domain: String,
    val port: Int,
    val shareAndDir: String,
)
