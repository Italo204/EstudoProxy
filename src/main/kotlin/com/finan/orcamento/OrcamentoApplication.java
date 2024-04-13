package com.finan.orcamento;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.ApplicationContext;
import com.finan.orcamento.model.OrcamentoModel;
import com.finan.orcamento.repositories.OrcamentoRepository;
import com.finan.orcamento.service.OrcamentoService;
import com.finan.orcamento.service.Proxy.OrcamentoProxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;

@SpringBootApplication(scanBasePackages = {"com.finan.orcamento"})
public class OrcamentoApplication {

    @Autowired
    private OrcamentoProxy orcamentoProxy;

    public OrcamentoApplication() {
        orcamentoProxy = new OrcamentoProxy();
    }

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrcamentoApplication.class, args);
        OrcamentoProxy orcamentoProxy = context.getBean(OrcamentoProxy.class);

        OrcamentoModel orcamentoModel = orcamentoProxy.buscaporId(1L);
        System.out.println("Valor sem proxy: " + orcamentoModel.toString());
        OrcamentoModel orcamentoModel2 = orcamentoProxy.buscaporId(1L);
        System.out.println("Valor com proxy: " + orcamentoModel2.toString());
        System.out.println("Valor com proxy: " + orcamentoModel2.toString());
    }
}