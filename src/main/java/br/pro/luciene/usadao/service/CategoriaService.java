package br.pro.luciene.usadao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.pro.luciene.usadao.entity.CategoriaEntity;
import br.pro.luciene.usadao.repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoriaService {
    @Autowired
    private final CategoriaRepository categoriaRepository;

    public CategoriaEntity incluir(CategoriaEntity usuario) {
        return categoriaRepository.save(usuario);
    }
    public CategoriaEntity editar(int id, CategoriaEntity usuario) {
        return categoriaRepository.save(usuario);
    }
    public List<CategoriaEntity> listarTodos() {
        return categoriaRepository.findAll();
    }
    public void excluir(Integer id) {
        categoriaRepository.deleteById(id);
    }
}
