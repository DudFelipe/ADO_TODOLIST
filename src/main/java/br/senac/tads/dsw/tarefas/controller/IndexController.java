/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.dsw.tarefas.controller;

import br.senac.tads.dsw.tarefas.entidade.Tarefa;
import br.senac.tads.dsw.tarefas.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 *
 * @author fernando.tsuda
 */
@Controller
@RequestMapping("/index")
public class IndexController {

    @Autowired
    TarefaRepository tarefaRepository;

    @GetMapping
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView("Tela1A");

        List<Tarefa> tarefas = tarefaRepository.findAll();

        mv.addObject("tarefas", tarefas);

        return mv;
    }
    
}
