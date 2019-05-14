package br.senac.tads.dsw.tarefas.controller;

import br.senac.tads.dsw.tarefas.entidade.Pessoa;
import br.senac.tads.dsw.tarefas.entidade.Tarefa;
import br.senac.tads.dsw.tarefas.repository.PessoaRepository;
import br.senac.tads.dsw.tarefas.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/tarefa")
public class TarefaController {

    @Autowired
    TarefaRepository tarefaRepository;

    @Autowired
    PessoaRepository pessoaRepository;

    @GetMapping("/adicionar")
    public ModelAndView adicionar(){
        ModelAndView mv = new ModelAndView("Tela2A");

        List<Pessoa> pessoas = pessoaRepository.findAll();

        mv.addObject("tarefa", new Tarefa());
        mv.addObject("pessoas", pessoas);

        return mv;
    }

    @PostMapping("/adicionar")
    public ModelAndView adicionar(Tarefa t){
        ModelAndView mv = new ModelAndView("redirect:/index");

        t.setDataUltimaAlteracao(LocalDateTime.now());

        tarefaRepository.save(t);

        List<Tarefa> tarefas = tarefaRepository.findAll();

        mv.addObject("tarefas", tarefas);

        return mv;
    }

}
