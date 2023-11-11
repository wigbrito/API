package br.com.projeto.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.projeto.api.model.Mensagem;
import br.com.projeto.api.model.Pessoa;
import br.com.projeto.api.repository.RepositoryPessoa;

@Service
public class Servico {

    @Autowired
    private Mensagem mensagem;

    @Autowired
    private RepositoryPessoa acao;

    public ResponseEntity<?> cadastrar(Pessoa obj) {

        if (obj.getNome().equals("")) {
            mensagem.setMensagem("O nome precisa ser preenchido");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        } else if (obj.getIdade() < 0) {
            mensagem.setMensagem("Informe uma idade válida");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(acao.save(obj), HttpStatus.CREATED);
        }
    }
}
