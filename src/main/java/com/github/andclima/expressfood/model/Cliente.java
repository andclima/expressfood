package com.github.andclima.expressfood.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Data;

// 1. construtor sem parâmetros
// 2. getters e setters atributos
// 3. toString padrao
// 4. equals e hashcode (todos atributos)

@Entity
@Data
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String cpfOuCnpj;

    @Enumerated(value = EnumType.STRING)
    private TipoCliente tipo;

    @OneToMany
    @JoinColumn(name = "idCliente")
    private List<Telefone> telefones;

    @OneToMany(mappedBy = "cliente")
    private List<Pedido> pedidos;
    
}
