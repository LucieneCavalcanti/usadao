package br.pro.luciene.usadao.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="tbclientes")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ClienteEntity extends PessoaEntity{
    private String endereco;
    @Column(length = 14, nullable = false)
    private String cpf;
    
}
