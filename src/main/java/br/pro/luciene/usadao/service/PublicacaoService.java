package br.pro.luciene.usadao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
        return publicacaoRepository.save(publicacao);
    }
    public List<PublicacaoEntity> listarTodos() {
        return publicacaoRepository.findAll();
    }
    public void excluir(Integer id) {
        publicacaoRepository.deleteById(id);
    }
}
