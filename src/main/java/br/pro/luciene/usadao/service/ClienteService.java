package br.pro.luciene.usadao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.pro.luciene.usadao.entity.AdministradorEntity;
import br.pro.luciene.usadao.entity.ClienteEntity;
import br.pro.luciene.usadao.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteService {
    @Autowired
    private final ClienteRepository clienteRepository;

    public ClienteEntity incluir(ClienteEntity cliente) {
        return clienteRepository.save(cliente);
    }
    public ClienteEntity editar(int id, ClienteEntity cliente) {
        // Verifique se a Cliente existe
        Optional<ClienteEntity> clienteExistente = clienteRepository.findById(id);
        
        if (clienteExistente.isPresent()) {
            // Atualiza a Cliente
            ClienteEntity clienteAtualizado = clienteExistente.get();
            clienteAtualizado.setNome(cliente.getNome());  // Atualiza os campos necessários
            clienteAtualizado.setEmail(cliente.getEmail());
            clienteAtualizado.setSenha(cliente.getSenha());
            clienteAtualizado.setEndereco(cliente.getEndereco());
            clienteAtualizado.setStatus(cliente.getStatus());
            return clienteRepository.save(clienteAtualizado);  // Salva o usuário atualizado
        } else {
            // Caso o usuario não exista, retorna null
            return null;
        }
    }
    public List<ClienteEntity> listarTodos() {
        return clienteRepository.findAll();
    }
    public void excluir(Integer id) {
        clienteRepository.deleteById(id);
    }
}
