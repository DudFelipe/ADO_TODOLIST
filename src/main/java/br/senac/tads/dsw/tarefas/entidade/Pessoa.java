/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.dsw.tarefas.entidade;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author fernando.tsuda
 */
@Entity
public class Pessoa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 100, nullable = false)
    private String nomeCompleto;

    //@Transient // REMOVER O @Transient e USAR A ANOTAÇÃO DE ASSOCIAÇÃO COM A CLASSE Tarefa
    @OneToMany(mappedBy = "responsavel", cascade = CascadeType.ALL)
    private List<Tarefa> tarefas;

    public Pessoa() {
        
    }
    
    public Pessoa(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public List<Tarefa> getTarefas() {
        return tarefas;
    }

    public void setTarefas(List<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }

}
