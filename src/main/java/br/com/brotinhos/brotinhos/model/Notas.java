package br.com.brotinhos.brotinhos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="conceitos")
@AllArgsConstructor
@NoArgsConstructor
public class Notas {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String nomeMateria;
    public String faltas;
    public String nota;
    
	public String getNota() {
		return nota;
	}
	public void setNota(String nota) {
		this.nota = nota;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomeMateria() {
		return nomeMateria;
	}
	public void setNomeMateria(String nomeMateria) {
		this.nomeMateria = nomeMateria;
	}
	public String getFaltas() {
		return faltas;
	}
	public void setFaltas(String faltas) {
		this.faltas = faltas;
	}
	
}
