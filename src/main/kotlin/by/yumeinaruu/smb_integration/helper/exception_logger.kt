package by.yumeinaruu.smb_integration.helper

import org.slf4j.LoggerFactory

/**
 * Возвращает корневое исключение.
 */
private fun getRootCause(exception: Throwable): Throwable {
    var rootCause = exception
    while (rootCause.cause != null) {
        rootCause = rootCause.cause!!
    }
    return rootCause
}

/**
 * Возвращает класс и метод, где возникло исключение.
 */
private fun getSourceClassAndMethod(exception: Throwable): Pair<String, String> {
    val rootCause = getRootCause(exception)
    val stackTraceElement = rootCause.stackTrace.firstOrNull()
    val className = stackTraceElement?.className ?: "UnknownClass"
    val methodName = stackTraceElement?.methodName ?: "UnknownMethod"
    return className to methodName
}

/**
 * Функция логирующая ошибки
 */
fun logException(ex: Throwable) {
    val (className, methodName) = getSourceClassAndMethod(ex)

    val logger = LoggerFactory.getLogger(Class.forName(className))
    logger.error("Error in method '$methodName': ${ex.message}")
}