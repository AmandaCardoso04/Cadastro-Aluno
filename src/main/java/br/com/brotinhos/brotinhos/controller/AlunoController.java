package br.com.brotinhos.brotinhos.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.brotinhos.brotinhos.dto.AlunoDto;
import br.com.brotinhos.brotinhos.service.AlunoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@RestController
@RequestMapping("/aluno")
public class AlunoController {
    
    @Autowired
    private AlunoService service;

    @GetMapping
    public Page<AlunoDto> listarAluno(@PageableDefault(size=5)Pageable paginacao) {
        return service.obterTodos(paginacao);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoDto> listarAlunoPorId(@PathVariable @NotNull Long Id){
        AlunoDto dto = service.obterPorId(Id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<AlunoDto> cadastrar(@RequestBody @Valid AlunoDto dto, UriComponentsBuilder uriBuilder){
        AlunoDto Aluno = service.criarAluno(dto);
        URI endereco = uriBuilder.path("/Aluno/{id}").buildAndExpand(Aluno.getId()).toUri();

        return ResponseEntity.created(endereco).body(Aluno);
    }

    @PutMapping("/{id}") 
    @Transactional
    public ResponseEntity<AlunoDto> atualizar(@PathVariable @NotNull Long Id, @RequestBody @Valid AlunoDto dto){
        
        AlunoDto atualizado = service.atualizarAluno(Id, dto);

        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<AlunoDto> deletar(@PathVariable @NotNull Long id){
        service.excluirAluno(id);

        return ResponseEntity.noContent().build();
    }
}
