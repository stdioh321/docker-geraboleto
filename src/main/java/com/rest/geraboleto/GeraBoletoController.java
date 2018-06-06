package com.rest.geraboleto;

import br.com.caelum.stella.boleto.Boleto;
import br.com.caelum.stella.boleto.transformer.GeradorDeBoleto;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GeraBoletoController {

    @RequestMapping(value = "/geraboleto", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<InputStreamResource> generate(@ModelAttribute BoletoForm boletoForm) throws IOException {
        Boleto boleto = boletoForm.toBoleto();
        GeradorDeBoleto gerador = new GeradorDeBoleto(boleto);

        MediaType mediaType = MediaType.APPLICATION_PDF;
        String contentDisposition = "inline; filename=geraboleto.pdf";
        byte[] bytes = gerador.geraPDF();

        if ("png".equalsIgnoreCase(boletoForm.getFormatoSaida())) {
            mediaType = MediaType.IMAGE_PNG;
            contentDisposition = "inline; filename=geraboleto.png";
            bytes = gerador.geraPNG();
        }

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", contentDisposition);

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(mediaType)
                .body(new InputStreamResource(new ByteArrayInputStream(bytes)));
    }

}
