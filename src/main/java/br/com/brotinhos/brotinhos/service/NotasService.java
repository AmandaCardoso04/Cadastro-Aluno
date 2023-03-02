package br.com.brotinhos.brotinhos.service;

import br.com.brotinhos.brotinhos.dto.NotasDto;
import br.com.brotinhos.brotinhos.model.Notas;
import br.com.brotinhos.brotinhos.repository.NotasRepository;
import jakarta.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class NotasService {

	@Autowired
	private NotasRepository repository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public Page<NotasDto> obterNotasCadastradas(Pageable paginacao) {
        return repository
                .findAll(paginacao)
                .map(p -> {
                    return modelMapper.map(p, NotasDto.class);
                });

    }

    public NotasDto adicionarNotas(NotasDto dto){
        Notas notas = modelMapper.map(dto, Notas.class);
        repository.save(notas);

        return modelMapper.map(notas, NotasDto.class);
    }

    public NotasDto obterPorId(Long id) { //obter registro de aluno por id
        Notas notas = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException());

        return modelMapper.map(notas, NotasDto.class);
    }
    public NotasDto atualizarNotas(Long id, NotasDto dto) {
        Notas notas = modelMapper.map(dto, Notas.class);
        notas.setId(id);
        notas = repository.save(notas);
        return modelMapper.map(notas, NotasDto.class);
    }

    public void excluirNota(Long id) {

        repository.deleteById(id);
    }
}
