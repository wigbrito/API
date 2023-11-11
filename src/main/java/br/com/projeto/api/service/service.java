package br.com.projeto.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projeto.api.model.Mensagem;

@Service
public class service {
    @Autowired
    private Mensagem mensagem;

}
