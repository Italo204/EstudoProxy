package com.finan.orcamento.repositories.Proxy;


import com.finan.orcamento.model.OrcamentoModel;
import com.finan.orcamento.service.OrcamentoService;


public class OrcamentoProxy {
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
