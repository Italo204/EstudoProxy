package com.finan.orcamento.repositories.Proxy;


import com.finan.orcamento.model.OrcamentoModel;
import com.finan.orcamento.repositories.OrcamentoRepository;
import com.finan.orcamento.service.OrcamentoService;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrcamentoProxy {
    private final OrcamentoService orcamentoService;
    private OrcamentoModel orcamentoModel;

    public OrcamentoProxy(OrcamentoService orcamentoService) {
        this.orcamentoService = orcamentoService;
    }

    public OrcamentoModel buscaporId(Long id) {
        if (orcamentoModel == null || !orcamentoModel.getId().equals(id)) {
            orcamentoModel = orcamentoService.buscaId(id);
            return orcamentoModel;
        } else {
            return orcamentoModel;
        }
    }
}