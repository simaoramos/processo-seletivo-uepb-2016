package br.edu.uepb.controleAcademico.model;

import java.io.Serializable;

import java.lang.String;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Aluno
 *
 */

@Entity
@Table(name="TB_ALUNO")
public class Aluno implements Serializable, Identificavel {

	private static final long serialVersionUID = 1L;
	   
	@Id
	private Long matricula;
	
	@Column(nullable=false,  length=100)
	private String nome;
	 
	@Column(nullable=false,  length=11)
	private String cpf;
	 
	@Column(nullable=false)
	@Temporal(value=TemporalType.DATE)
	private Date dataIngresso;
	
	@ManyToOne 
	@JoinColumn (name= "curso_fk")
	private Curso curso;

	public Aluno() {
		super();
	}   
	public Long getMatricula() {
		return this.matricula;
	}

	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}   
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}   
	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}   
	public Date getDataIngresso() {
		return this.dataIngresso;
	}

	public void setDataIngresso(Date dataIngresso) {
		this.dataIngresso = dataIngresso;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	@Override
	public Long getIdentificador() {
		return new Long(getMatricula());
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (matricula != other.matricula)
			return false;
		return true;
	}
	
	
	
	
   
}
