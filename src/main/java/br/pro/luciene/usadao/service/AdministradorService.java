package br.pro.luciene.usadao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.pro.luciene.usadao.entity.AdministradorEntity;
import br.pro.luciene.usadao.repository.AdministradorRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdministradorService {
    @Autowired
    private final AdministradorRepository administradorRepository;

    public AdministradorEntity incluir(AdministradorEntity usuario) {
        return administradorRepository.save(usuario);
    }
    public AdministradorEntity editar(int id, AdministradorEntity usuario) {
        return administradorRepository.save(usuario);
    }
    public List<AdministradorEntity> listarTodos() {
        return administradorRepository.findAll();
    }
    public void excluir(Integer id) {
        administradorRepository.deleteById(id);
    }
}
