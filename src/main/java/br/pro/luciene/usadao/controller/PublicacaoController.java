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

import br.pro.luciene.usadao.entity.PublicacaoEntity;
import br.pro.luciene.usadao.service.PublicacaoService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor //colocando isso não precisa colocar @Autowired no atributo
@RequestMapping(value = "/publicacao")
public class PublicacaoController {
    @SuppressWarnings("unused")
    private final PublicacaoService publicacaoService;
    @GetMapping
    public ResponseEntity<List<PublicacaoEntity>> listarTodos() {
        List<PublicacaoEntity> lista = publicacaoService.listarTodos();
        return ResponseEntity.ok().body(lista);
    }

    @PostMapping
    public ResponseEntity<PublicacaoEntity> incluir(@RequestBody PublicacaoEntity Publicacao) {
        PublicacaoEntity novo = publicacaoService.incluir(Publicacao);
        if (novo != null) {
            return new ResponseEntity<>(novo, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<PublicacaoEntity> editar(@PathVariable int id, 
    @RequestBody PublicacaoEntity Publicacao) {
        PublicacaoEntity atualizado = publicacaoService.editar(id,Publicacao);
        if (atualizado != null) {
            return new ResponseEntity<>(atualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable int id) {
        publicacaoService.excluir(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
