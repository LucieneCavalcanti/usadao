package br.pro.luciene.usadao.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
    @Column(nullable = false)
    private String titulo;
    @Column(columnDefinition = "timestamp default current_timestamp")
    private Timestamp dataHora;
    private float valor;
    @JoinColumn(name = "idcliente", referencedColumnName = "idpessoa")
    @OneToOne
    private ClienteEntity cliente;
    @JoinColumn(name = "idcategoria", referencedColumnName = "id")
    @OneToOne
    private CategoriaEntity categoria;
    @Column(columnDefinition = "varchar default 'AGUARDANDO_ATIVAÇÃO'")
    private Status status;
}
