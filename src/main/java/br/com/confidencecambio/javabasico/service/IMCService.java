package br.com.confidencecambio.javabasico.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;

@Service
public class IMCService {
    public BigDecimal calculaIMC(BigDecimal peso, BigDecimal altura) {
        MathContext mc = new MathContext(4);
        return peso.divide(altura.pow(2) , mc);
    }
}
