package br.edu.uepb.controleAcademico.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.uepb.controleAcademico.dao.CursoDAO;
import br.edu.uepb.controleAcademico.dao.DisciplinaDAO;
import br.edu.uepb.controleAcademico.model.Curso;
import br.edu.uepb.controleAcademico.model.Disciplina;


@RequestScoped
@Named
public class DisciplinaBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private CursoDAO cursoDao;
	
	@Inject
	private DisciplinaDAO disciplinaDao;
	
	private Disciplina disciplina;
	
	private List<Curso> cursos;
	
	private List<Disciplina> disciplinas;
	
	private Curso cursoSelect; 
	
	public DisciplinaBean(){
		this.cursoSelect = new Curso();
		this.setDisciplina(new Disciplina());
		this.setCursos(new ArrayList<Curso>());
		this.setDisciplinas(new ArrayList<Disciplina>());
	}

	@PostConstruct
    public void init() {
        // In @PostConstruct (will be invoked immediately after construction and dependency/property injection).
		this.cursos = cursoDao.listaTodos();
		this.disciplinas = disciplinaDao.listaTodos();
    }


	public Disciplina getDisciplina() {
		return this.disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public List<Curso> getCursos() {
		if(this.cursos == null){
			this.cursos = cursoDao.listaTodos();
		}
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public Curso getCursoSelect() {
		return cursoSelect;
	}

	public void setCursoSelect(Curso cursoSelect) {
		this.cursoSelect = cursoSelect;
	}
	
	public void salvarDisciplina(){
		disciplinaDao.adiciona(getDisciplina());
		limpaCampos();
	}

	public void limpaCampos() {
		disciplina = new Disciplina();
		cursoSelect = new Curso();
		this.init();
	}
	
	
	/*
	 *demais metodos 
	 */
	public String adicionar() {
		this.disciplinaDao.adiciona(this.disciplina);
		
		this.disciplinas = this.disciplinaDao.listaTodos();
		return "disciplinas";
	}
	
}
