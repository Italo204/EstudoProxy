package com.finan.orcamento.repositories.Proxy;


import com.finan.orcamento.model.OrcamentoModel;
import com.finan.orcamento.service.OrcamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrcamentoProxy {
    @Autowired
   private OrcamentoService orcamentoService;
   private OrcamentoModel orcamentoModel;

    public OrcamentoModel buscaporId(Long id) {
        if(orcamentoModel == null || !orcamentoModel.getId().equals(id)){
            orcamentoModel = orcamentoService.buscaId(id);
            return orcamentoModel;
        } else {
            return orcamentoModel;
        }
    }
}
