package br.com.confidencecambio.javabasico.controller;

import br.com.confidencecambio.javabasico.service.IMCService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/v1")
public class IMCController {

    private IMCService service;

    public IMCController(final IMCService service) {
        this.service = service;
    }

    @GetMapping(value = "/imc")
    public ResponseEntity<BigDecimal> getImc(@RequestParam(value = "peso") BigDecimal peso,
                                             @RequestParam(value = "altura") BigDecimal altura) {
        var icm = service.calculaIMC(peso, altura);
        return new ResponseEntity<>(icm, HttpStatus.OK);
    }
}