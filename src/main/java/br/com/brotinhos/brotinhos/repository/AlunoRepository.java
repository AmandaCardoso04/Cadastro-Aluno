package br.com.brotinhos.brotinhos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.brotinhos.brotinhos.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{
    
}
