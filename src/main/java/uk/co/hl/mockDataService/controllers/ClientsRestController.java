package uk.co.hl.mockDataService.controllers;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;

@RestController
@RequestMapping("clients")
public class ClientsRestController {

    @GetMapping("{clientNo}/portfolio")
    public ResponseEntity<InputStreamResource> getPortoflio(@PathVariable String clientNo) throws IOException {
        return getFileFromPath("clients/" + clientNo + "/portfolio/sample.json");
    }

    @GetMapping("{clientNo}/portfolio/{productNo}")
    public ResponseEntity<InputStreamResource> getPortoflioProducts(@PathVariable String clientNo, @PathVariable String productNo)
            throws IOException {

        return getFileFromPath("clients/" + clientNo + "/portfolio/" + productNo + "/sample.json");
    }

    @GetMapping("{clientNo}/alerts")
    public ResponseEntity<InputStreamResource> getAlerts(@PathVariable String clientNo) throws IOException {
        return getFileFromPath("clients/" + clientNo + "/alerts/sample.json");
    }

    private ResponseEntity<InputStreamResource> getFileFromPath(String path)
            throws IOException {

        ClassPathResource pdfFile = new ClassPathResource(path);

        return ResponseEntity
                .ok()
                .contentLength(pdfFile.contentLength())
                .contentType(
                        MediaType.parseMediaType(MediaType.APPLICATION_JSON_VALUE))
                .body(new InputStreamResource(pdfFile.getInputStream()));
    }

}
