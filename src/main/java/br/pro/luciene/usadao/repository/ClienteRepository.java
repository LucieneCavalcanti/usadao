package br.pro.luciene.usadao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.pro.luciene.usadao.entity.ClienteEntity;

@Repository
public interface ClienteRepository extends
JpaRepository<ClienteEntity, Integer> {

}
