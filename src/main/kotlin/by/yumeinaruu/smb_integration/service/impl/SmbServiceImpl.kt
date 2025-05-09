package by.yumeinaruu.smb_integration.service.impl

import by.yumeinaruu.smb_integration.dto.RequestCreationDto
import by.yumeinaruu.smb_integration.service.SmbService
import org.springframework.integration.smb.session.SmbSessionFactory as Factory
import org.springframework.stereotype.Service

@Service
class SmbServiceImpl(
    private val smbFactory: Factory,
) : SmbService {

    private fun createFolder(remotePath: String) {
        smbFactory.session.use { session ->
            if (!session.exists(remotePath)) {
                session.mkdir(remotePath)
            }
        }
    }

    private fun generateFolderName(requestCreationDto: RequestCreationDto): String {
        return "${requestCreationDto.fullName}_${requestCreationDto.idNumber}/${requestCreationDto.requestId}"
    }

    override fun uploadFiles(requestCreationDto: RequestCreationDto): String {
        val remotePath = generateFolderName(requestCreationDto)
        createFolder(remotePath)

        requestCreationDto.documents.forEach { (documentContent, fileName) ->

            val remoteFilePath = "$remotePath/$fileName"

            smbFactory.session.use { session ->
                session.write(documentContent.inputStream(), remoteFilePath)
            }
        }
        return remotePath
    }

}