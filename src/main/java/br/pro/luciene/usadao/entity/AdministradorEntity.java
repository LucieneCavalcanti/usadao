package br.pro.luciene.usadao.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="tbadministradores")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class AdministradorEntity extends PessoaEntity{
    private String telefone;
}
