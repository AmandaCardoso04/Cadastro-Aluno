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

import br.com.brotinhos.brotinhos.dto.NotasDto;
import br.com.brotinhos.brotinhos.service.NotasService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@RestController
@RequestMapping("/notas")
public class NotasController {

	@Autowired
	private NotasService service;
	
	@GetMapping
    public Page<NotasDto> listarNotas(@PageableDefault(size = 20)Pageable pagina) {
        return service.obterNotasCadastradas(pagina);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NotasDto> listarNotasPorId(@PathVariable @NotNull Long id){
        NotasDto dto = service.obterPorId(id);
        return ResponseEntity.ok(dto);
    }	

    @PostMapping
    public ResponseEntity<NotasDto> cadastrar(@RequestBody NotasDto dto, UriComponentsBuilder uriBuilder){
        NotasDto notas = service.adicionarNotas(dto);
        URI endereco = uriBuilder.path("/notas/{id}").buildAndExpand(notas.getId()).toUri();

        return ResponseEntity.created(endereco).body(notas);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NotasDto> atualizar(@PathVariable @NotNull Long id, @RequestBody @Valid NotasDto dto){
        NotasDto atualizado = service.atualizarNotas(id, dto);

        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<NotasDto> deletar(@PathVariable @NotNull Long id){
        service.excluirNota(id);

        return ResponseEntity.noContent().build();
    }
}
