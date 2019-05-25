package br.edu.uepb.controleAcademico.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: Aluno
 *
 */

@Entity
@Table(name="TB_MATRICULA")
public class Matricula implements Serializable, Identificavel {

	private static final long serialVersionUID = 1L;
	   
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@ManyToOne 
	@JoinColumn (name= "disciplina_fk", nullable=false)
	private Disciplina disciplina;

	@ManyToOne 
	@JoinColumn (name= "aluno_fk", nullable=false)
	private Aluno aluno;
	
	@Column(nullable=false,  length=5)
	private int periodo;
	
	
	@Enumerated(EnumType.STRING)
	@Column (length=15)
	private Turno turno;
	
	@Column(nullable=true, precision=8, scale=2)
	private Float nota1;
	
	@Column(nullable=true, precision=8, scale=2)
	private Float nota2;
	
	@Column(nullable=true, precision=8, scale=2)
	private Float nota3;
	
	public Matricula() {
		super();
	}

	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Disciplina getDisciplina() {
		return disciplina;
	}


	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}


	public Aluno getAluno() {
		return aluno;
	}


	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}


	public int getPeriodo() {
		return periodo;
	}


	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}


	public Turno getTurno() {
		return turno;
	}


	public void setTurno(Turno turno) {
		this.turno = turno;
	}


	public Float getNota1() {
		return nota1;
	}


	public void setNota1(Float nota1) {
		this.nota1 = nota1;
	}


	public Float getNota2() {
		return nota2;
	}


	public void setNota2(Float nota2) {
		this.nota2 = nota2;
	}


	public Float getNota3() {
		return nota3;
	}


	public void setNota3(Float nota3) {
		this.nota3 = nota3;
	}


	@Override
	public Long getIdentificador() {
		return getId();
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Matricula other = (Matricula) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}   
	
	
	
		
   
}
