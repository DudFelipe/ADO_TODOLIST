package br.senac.tads.dsw.tarefas.controller;

import br.senac.tads.dsw.tarefas.entidade.Pessoa;
import br.senac.tads.dsw.tarefas.entidade.Tarefa;
import br.senac.tads.dsw.tarefas.repository.PessoaRepository;
import br.senac.tads.dsw.tarefas.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
        mv.addObject("insert", true);

        return mv;
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable int id){
        ModelAndView mv = new ModelAndView("Tela2A");

        List<Pessoa> pessoas = pessoaRepository.findAll();
        Tarefa t = tarefaRepository.getOne(id);

        mv.addObject("tarefa", t);
        mv.addObject("pessoas", pessoas);

        return mv;
    }

    @PostMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable int id, Tarefa t){
        ModelAndView mv = new ModelAndView("redirect:/index");

        Tarefa tare = tarefaRepository.getOne(id);

        tare.setDataUltimaAlteracao(LocalDateTime.now());
        tare.setDescricao(t.getDescricao());
        tare.setDataInicioPrevisto(t.getDataInicioPrevisto());
        tare.setDataTerminoPrevisto(t.getDataTerminoPrevisto());
        tare.setNome(t.getNome());
        tare.setResponsavel(t.getResponsavel());
        t.setDataUltimaAlteracao(LocalDateTime.now());

        tarefaRepository.save(tare);

        return mv;
    }

    @GetMapping("/iniciar/{id}")
    public ModelAndView iniciar(@PathVariable int id){
        ModelAndView mv = new ModelAndView("redirect:/index");

        Tarefa t = tarefaRepository.getOne(id);

        t.setDataInicioReal(LocalDate.now());
        t.setStatus(1);
        t.setDataUltimaAlteracao(LocalDateTime.now());

        tarefaRepository.save(t);

        return mv;
    }

    @GetMapping("/concluir/{id}/{nota}")
    public ModelAndView concluir(@PathVariable int id, @PathVariable int nota){
        ModelAndView mv = new ModelAndView("redirect:/index");

        Tarefa t = tarefaRepository.getOne(id);
        t.setDataTerminoReal(LocalDate.now());
        t.setStatus(2);
        t.setDataUltimaAlteracao(LocalDateTime.now());

        t.setNota(nota);

        tarefaRepository.save(t);

        return mv;
    }

}
