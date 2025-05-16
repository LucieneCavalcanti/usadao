package br.pro.luciene.usadao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.pro.luciene.usadao.entity.PublicacaoEntity;

@Repository
public interface PublicacaoRepository extends
JpaRepository<PublicacaoEntity, Integer> {

}
