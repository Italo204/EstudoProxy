package com.finan.orcamento;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.finan.orcamento.model.OrcamentoModel;
import com.finan.orcamento.service.OrcamentoService;
import com.finan.orcamento.service.Proxy.OrcamentoProxy;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrcamentoProxyTest {

    @Autowired
    private OrcamentoProxy orcamentoProxy;

    @MockBean
    private OrcamentoService orcamentoService;

    @Test
    public void testBuscaporId() {
        // Configuração do mock
        Long id = 1L;
        OrcamentoModel mockOrcamentoModel = new OrcamentoModel();
        mockOrcamentoModel.setId(id);
        when(orcamentoService.buscaId(id)).thenReturn(mockOrcamentoModel);

        // Chama o método do proxy
        OrcamentoModel resultado = orcamentoProxy.buscaporId(id);

        if (resultado != null) {
            System.out.println("Resultado: " + resultado.toString());
        } else {
            System.out.println("Resultado é nulo");
        }

        // Verifica se o resultado é o esperado
        assertEquals(mockOrcamentoModel, resultado);
    }
}
