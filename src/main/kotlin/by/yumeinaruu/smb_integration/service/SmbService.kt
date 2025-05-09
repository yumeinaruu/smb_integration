package by.yumeinaruu.smb_integration.service

import by.yumeinaruu.smb_integration.dto.RequestCreationDto
import org.springframework.stereotype.Service

@Service
interface SmbService {

    fun uploadFiles(requestCreationDto: RequestCreationDto): String

}