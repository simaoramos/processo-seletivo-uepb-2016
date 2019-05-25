package br.edu.uepb.controleAcademico.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="TB_CURSO")
public class Curso implements Serializable, Identificavel {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(nullable=false, unique=true )
	private int codigo;
	
	@Column(nullable=false,  length=100)
	private String nome;
	
	@Enumerated(EnumType.STRING)
	@Column (length=10)
	private Tipo genero;

	@Enumerated(EnumType.STRING)
	@Column (length=20)
	private Nivel nivel;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Tipo getGenero() {
		return genero;
	}

	public void setGenero(Tipo genero) {
		this.genero = genero;
	}

	public Nivel getNivel() {
		return nivel;
	}

	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
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
		Curso other = (Curso) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
}
