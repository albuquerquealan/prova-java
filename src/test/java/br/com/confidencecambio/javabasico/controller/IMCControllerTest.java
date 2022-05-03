package br.com.confidencecambio.javabasico.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class IMCControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void deveCalcularIMCCorretamenteQuandoPassarTodosValores() throws Exception {
        this.mockMvc.perform(get("/v1/imc?peso=121&altura=1.81"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("36.93")));
    }

    @Test
    public void deveRetornarErroQuandoNaoPassarAltura() throws Exception {
        this.mockMvc.perform(get("/v1/imc?peso=80"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().string(containsString("A variável 'altura' é obrigatória")));
    }

    @Test
    public void deveRetornarErroQuandoNaoPassarPeso() throws Exception {
        this.mockMvc.perform(get("/v1/imc?altura=1.70"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().string(containsString("A variável 'peso' é obrigatória")));
    }
}
