package br.com.confidencecambio.javabasico.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import static org.junit.Assert.assertEquals;

@ExtendWith(SpringExtension.class)
public class IMCServiceTest {

    @MockBean
    private IMCService service;

    @Before
    public void init(){
        service= new IMCService();
    }

    private final MathContext mc = new MathContext(4);

    @Test
    public void quandoPassarValoresPesoAlturaQueroRetornaIMC(){

        var expected = new BigDecimal(36.93, mc);
        var peso = new BigDecimal(121);
        var altura = new BigDecimal(1.81).setScale(2, RoundingMode.FLOOR);

        BigDecimal imc = service.calculaIMC(peso, altura);
        assertEquals(expected, imc);
    }
}
