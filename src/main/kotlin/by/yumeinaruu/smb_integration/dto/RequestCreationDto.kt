package by.yumeinaruu.smb_integration.dto

import by.yumeinaruu.smb_integration.type.DocumentContent
import by.yumeinaruu.smb_integration.type.DocumentType
import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class RequestCreationDto(
    val fullName: String,
    val idNumber: String,
    val requestId: Long,
    val documents: List<DocumentContent>,
)
