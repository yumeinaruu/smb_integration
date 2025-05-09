package by.yumeinaruu.smb_integration.controller.handler

import by.yumeinaruu.smb_integration.helper.logException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionHandler {

    @ExceptionHandler(
        Exception::class
    )
    fun handleException(ex: Exception): ResponseEntity<Map<String, String?>> {
        logException(ex)
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(getResponseBody(ex.message))
    }

    private fun getResponseBody(message: String?): Map<String, String?> {
        return mapOf(
            "status" to "error",
            "error" to message
        )
    }

}