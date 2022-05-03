package br.com.confidencecambio.javabasico.service;

import br.com.confidencecambio.javabasico.entity.Cliente;
import br.com.confidencecambio.javabasico.entity.Gerente;
import br.com.confidencecambio.javabasico.entity.Robo;
import br.com.confidencecambio.javabasico.exception.IncorrectNameException;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.Assert.assertEquals;

public class NameServiceTest {

    @MockBean
    private NameService service;

    @Before
    public void init(){
        service= new NameService();
    }

    @Test(expected = IncorrectNameException.class)
    public void quandoPassarNomeNuloRetornaError() throws IncorrectNameException {

        Cliente cliente = new Cliente();
        cliente.setName(null);
        service.getShortName(cliente);
    }

    @Test(expected = IncorrectNameException.class)
    public void quandoPassarNomeVazioRetornaError() throws IncorrectNameException {

        Cliente cliente = new Cliente();
        cliente.setName("");
        service.getShortName(cliente);
    }

    @Test
    public void quandoPassarNomeComEspacoRetornaNomeMaiusculo() throws IncorrectNameException {

        Robo robo = new Robo();
        robo.setName("Robo 1234rE  ");

        String expected = "ROBO 1234RE";

        String retorno = service.getUpperCaseName(robo);
        assertEquals(expected, retorno);
    }

    @Test
    public void quandoPassarNomeClienteRetornaPrimeiroNome() throws IncorrectNameException {

        Cliente cliente = new Cliente();
        cliente.setName("Alan Nicolas");

        String expected = "Alan";

        String retorno = service.getFirstName(cliente);
        assertEquals(expected, retorno);
    }

    @Test
    public void quandoPassarNomeGerenteRetornaUltimoNome() throws IncorrectNameException {

        Gerente gerente = new Gerente();
        gerente.setName("Alan Lins de Albuquerque");

        String expected = "Lins de Albuquerque";

        String retorno = service.getLastName(gerente);
        assertEquals(expected, retorno);
    }

    @Test
    public void quandoPassarNomeRoboRetornaNomeMaiusculo() throws IncorrectNameException {

        Robo robo = new Robo();
        robo.setName("xpto 47l");

        String expected = "XPTO 47L";

        String retorno = service.getUpperCaseName(robo);
        assertEquals(expected, retorno);
    }

    @Test
    public void quandoPassarNomeClienteRetornaNomeAbreviado() throws IncorrectNameException {

        Cliente cliente = new Cliente();
        cliente.setName("Carlos Carvalho Almeida");

        String expected = "Carlos C. Almeida";

        String retorno = service.getShortName(cliente);
        assertEquals(expected, retorno);
    }


}
