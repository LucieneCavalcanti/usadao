package br.pro.luciene.usadao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.pro.luciene.usadao.entity.ClienteEntity;
import br.pro.luciene.usadao.entity.PublicacaoEntity;
import br.pro.luciene.usadao.repository.PublicacaoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PublicacaoService {
    @Autowired
    private final PublicacaoRepository publicacaoRepository;

    public PublicacaoEntity incluir(PublicacaoEntity publicacao) {
        return publicacaoRepository.save(publicacao);
    }
public PublicacaoEntity editar(int id, PublicacaoEntity publicacao) {
        // Verifique se a Publicacao existe
        Optional<PublicacaoEntity> publicacaoExistente = publicacaoRepository.findById(id);
        
        if (publicacaoExistente.isPresent()) {
            // Atualiza a Publicacao
            PublicacaoEntity publicacaoAtualizado = publicacaoExistente.get();
            publicacaoAtualizado.setTitulo(publicacao.getTitulo());
            publicacaoAtualizado.setDataHora(publicacao.getDataHora());
            publicacaoAtualizado.setValor(publicacao.getValor());
            publicacao.setCategoria(publicacao.getCategoria());
            publicacao.setCliente(publicacao.getCliente());
            publicacao.setDescricao(publicacao.getDescricao());
            publicacao.setStatus(publicacao.getStatus());

            return publicacaoRepository.save(publicacaoAtualizado);  // Salva o usuário atualizado
        } else {
            // Caso o usuario não exista, retorna null
            return null;
        }
    }
    public List<PublicacaoEntity> listarTodos() {
        return publicacaoRepository.findAll();
    }
    public void excluir(Integer id) {
        publicacaoRepository.deleteById(id);
    }
}
