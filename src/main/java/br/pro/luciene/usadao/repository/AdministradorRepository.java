package br.pro.luciene.usadao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.pro.luciene.usadao.entity.AdministradorEntity;

@Repository
public interface AdministradorRepository extends
JpaRepository<AdministradorEntity, Integer>{

}
