package br.senac.tads.dsw.tarefas;

import br.senac.tads.dsw.tarefas.entidade.Pessoa;
import br.senac.tads.dsw.tarefas.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TarefasApplication implements CommandLineRunner {

    @Autowired
    private PessoaRepository pessoaRepository;

    public static void main(String[] args) {
        SpringApplication.run(TarefasApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        if (pessoaRepository.count() == 0) {
            pessoaRepository.save(new Pessoa("Fulano da Silva"));
            pessoaRepository.save(new Pessoa("Ciclano de Souza"));
            pessoaRepository.save(new Pessoa("Beltrana das Cruzes"));
        }
    }

}
