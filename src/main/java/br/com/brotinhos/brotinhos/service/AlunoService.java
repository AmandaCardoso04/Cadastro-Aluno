package br.com.brotinhos.brotinhos.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.brotinhos.brotinhos.dto.AlunoDto;
import br.com.brotinhos.brotinhos.model.Aluno;
import br.com.brotinhos.brotinhos.repository.AlunoRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class AlunoService {
    
    @Autowired
    private AlunoRepository alunoRepository;
    
    @Autowired
    private ModelMapper modelMapper;
    
    public Page<AlunoDto> obterTodos(Pageable paginacao) { //tras todos os alunos cadastrados
        return alunoRepository
                .findAll(paginacao)
                .map(p -> modelMapper.map(p, AlunoDto.class));
    }

    public AlunoDto obterPorId(Long id) { //obter Aluno de aluno por id
        Aluno pagamento = alunoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException());

        return modelMapper.map(pagamento, AlunoDto.class);
    }

    public AlunoDto criarAluno(AlunoDto dto) { //cadastra um aluno
        Aluno Aluno = modelMapper.map(dto, Aluno.class);
        alunoRepository.save(Aluno);

        return modelMapper.map(Aluno, AlunoDto.class);
    }

    public AlunoDto atualizarAluno(Long id, AlunoDto dto) {
        Aluno Aluno = modelMapper.map(dto, Aluno.class);
        Aluno.setId(id);
        Aluno = alunoRepository.save(Aluno);
        return modelMapper.map(Aluno, AlunoDto.class);
    }

    public void excluirAluno(Long id) {

    	alunoRepository.deleteById(id);
    }
}
