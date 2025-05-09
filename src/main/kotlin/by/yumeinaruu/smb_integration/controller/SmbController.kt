package by.yumeinaruu.smb_integration.controller

import by.yumeinaruu.smb_integration.dto.RequestCreationDto
import by.yumeinaruu.smb_integration.service.SmbService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/public/smb")
class SmbController(
    private val smbService: SmbService,
) {

    @PostMapping("/upload_files")
    fun createDir(requestCreationDto: RequestCreationDto): ResponseEntity<String> {
        return ResponseEntity.status(HttpStatus.CREATED).body(
            smbService.uploadFiles(requestCreationDto)
        )
    }

}