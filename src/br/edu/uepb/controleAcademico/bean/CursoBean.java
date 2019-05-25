package br.edu.uepb.controleAcademico.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.uepb.controleAcademico.dao.CursoDAO;
import br.edu.uepb.controleAcademico.model.Curso;
import br.edu.uepb.controleAcademico.model.Nivel;
import br.edu.uepb.controleAcademico.model.Tipo;


@Named
@RequestScoped
public class CursoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private CursoDAO cursoDao;
	
	private Curso curso;
	
	private List<Curso> cursos;

	@PostConstruct
    public void init() {
	
		this.cursos = this.listaTodosCursos();
    }
	
	public CursoBean(){
		this.curso = new Curso();
		this.cursos = new ArrayList<Curso>();
	}
	
	public void salvar(){
		
	}	
	
	public List<Curso> listaTodosCursos(){
		return cursoDao.listaTodos();
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	public List<Curso> getCursos() {
		if(this.cursos ==null){
			this.cursos = this.listaTodosCursos();
		}
		return cursos;
	}
	
	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}
	
	public void carregarCursos(){
		for(Curso c: cursosIniciais()){
			cursoDao.adiciona(c);
		}
		this.cursos = this.listaTodosCursos();
		
	}
	
	private List<Curso> cursosIniciais(){
		Curso c1 = new Curso();
		c1.setNome("Ciência da Computação");
		c1.setCodigo(50);
		c1.setGenero(Tipo.PRESENCIAL);
		c1.setNivel(Nivel.GRADUCAO);
		
		Curso c2 = new Curso();
		c2.setNome("Licenciatura em Matemática");
		c2.setCodigo(60);
		c2.setGenero(Tipo.PRESENCIAL);
		c2.setNivel(Nivel.GRADUCAO);
		
		Curso c3 = new Curso();
		c3.setNome("Enfermagem");
		c3.setCodigo(70);
		c3.setGenero(Tipo.PRESENCIAL);
		c3.setNivel(Nivel.GRADUCAO);
		
		return Arrays.asList(c1,c2,c3);
		
	}
	
	
}
