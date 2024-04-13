package com.finan.orcamento.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Component
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="usuario")
public class UsuarioModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name="nome_usuario")
    private String nomeUsuario;

    @JsonIgnore
    @OneToMany(mappedBy = "id",  fetch = FetchType.EAGER)
    private List<OrcamentoModel> orcamentos = new ArrayList<>();
}
