package br.com.projeto.api.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.projeto.api.model.Pessoa;

@Repository
public interface RepositoryPessoa extends CrudRepository<Pessoa, Integer> {

    List<Pessoa> findAll();

    Pessoa findByCodigo(int codigo);
}
