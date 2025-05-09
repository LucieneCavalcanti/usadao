package br.pro.luciene.usadao.entity;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="tbpessoas")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PessoaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idpessoa")
    private int id;
    @Column(name="nome", length=200, nullable = false)
    private String nome;
    @Column(name="email", length=200, nullable = false)
    private String email;
    @Column(length=20, nullable = false)
    private String senha;
    @Column(columnDefinition = "integer default 0")
    private int status; //0 -> desativado, 1 - ativo
}
