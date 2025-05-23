package br.pro.luciene.usadao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.pro.luciene.usadao.entity.AdministradorEntity;
import br.pro.luciene.usadao.entity.CategoriaEntity;
import br.pro.luciene.usadao.repository.AdministradorRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdministradorService {
    @Autowired
    private final AdministradorRepository administradorRepository;

    public AdministradorEntity incluir(AdministradorEntity administrador) {
        return administradorRepository.save(administrador);
    }
    public AdministradorEntity editar(int id, AdministradorEntity administrador) {
        // Verifique se a Administrador existe
        Optional<AdministradorEntity> AdministradorExistente = administradorRepository.findById(id);
        
        if (AdministradorExistente.isPresent()) {
            // Atualiza a Administrador
            AdministradorEntity AdministradorAtualizado = AdministradorExistente.get();
            AdministradorAtualizado.setNome(administrador.getNome());  // Atualiza os campos necessários
            AdministradorAtualizado.setEmail(administrador.getEmail());
            AdministradorAtualizado.setSenha(administrador.getSenha());
            AdministradorAtualizado.setTelefone(administrador.getTelefone());
            AdministradorAtualizado.setStatus(administrador.getStatus());
            return administradorRepository.save(AdministradorAtualizado);  // Salva o usuário atualizado
        } else {
            // Caso o usuario não exista, retorna null
            return null;
        }
    }
    public List<AdministradorEntity> listarTodos() {
        return administradorRepository.findAll();
    }
    public void excluir(Integer id) {
        administradorRepository.deleteById(id);
    }
}
