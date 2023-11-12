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


    //Metodo para cadastrar pessoas
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
//Metodo para selecionar pessoas
public ResponseEntity<?> selecionar(){
    return new ResponseEntity<>(acao.findAll(), HttpStatus.OK);
}

//Metodo para selecionar pessoas atraves do código
public ResponseEntity<?> selecionarPeloCodigo(int codigo){
    if(acao.countByCodigo(codigo) == 0){
        mensagem.setMensagem("Não foi encontrado nenhuma pessoa.");
        return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
    }else{
        return new ResponseEntity<>(acao.findByCodigo(codigo),HttpStatus.OK);
        
    }
   
}
}
