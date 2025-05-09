package br.pro.luciene.usadao.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="tbpublicacoes")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PublicacaoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 1500, nullable = false)
    private String descricao;
    private String titulo;
    private Timestamp dataHora;
    private float valor;
    @OneToOne
    private ClienteEntity cliente;
    @OneToOne
    private CategoriaEntity categoria;
    private int status;
}
