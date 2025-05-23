package br.pro.luciene.usadao.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.pro.luciene.usadao.entity.AdministradorEntity;
import br.pro.luciene.usadao.service.AdministradorService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor //colocando isso não precisa colocar @Autowired no atributo
@RequestMapping(value = "/administrador")
public class AdministradorController {
    @SuppressWarnings("unused")
    private final AdministradorService administradorService;
    @GetMapping
    public ResponseEntity<List<AdministradorEntity>> listarTodos() {
        List<AdministradorEntity> lista = administradorService.listarTodos();
        return ResponseEntity.ok().body(lista);
    }

    @PostMapping
    public ResponseEntity<AdministradorEntity> incluir(@RequestBody AdministradorEntity Administrador) {
        AdministradorEntity novo = administradorService.incluir(Administrador);
        if (novo != null) {
            return new ResponseEntity<>(novo, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

     @PutMapping("/{id}")
    public ResponseEntity<AdministradorEntity> editar(@PathVariable int id, 
    @RequestBody AdministradorEntity Administrador) {
        AdministradorEntity atualizado = administradorService.editar(id,Administrador);
        if (atualizado != null) {
            return new ResponseEntity<>(atualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable int id) {
        administradorService.excluir(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
