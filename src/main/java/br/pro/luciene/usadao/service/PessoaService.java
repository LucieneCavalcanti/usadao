package br.pro.luciene.usadao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.pro.luciene.usadao.entity.PessoaEntity;
import br.pro.luciene.usadao.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PessoaService {
    @Autowired
    private final PessoaRepository pessoaRepository;

    public PessoaEntity incluir(PessoaEntity usuario) {
        return pessoaRepository.save(usuario);
    }
    public PessoaEntity editar(int id, PessoaEntity usuario) {
        return pessoaRepository.save(usuario);
    }
    public List<PessoaEntity> listarTodos() {
        return pessoaRepository.findAll();
    }
    public void excluir(Integer id) {
        pessoaRepository.deleteById(id);
    }
}
