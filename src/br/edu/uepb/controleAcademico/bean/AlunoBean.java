package br.edu.uepb.controleAcademico.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.uepb.controleAcademico.dao.AlunoDAO;
import br.edu.uepb.controleAcademico.dao.CursoDAO;
import br.edu.uepb.controleAcademico.model.Aluno;
import br.edu.uepb.controleAcademico.model.Curso;

@RequestScoped
@Named
public class AlunoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private CursoDAO cursoDAO;
	@Inject
	private AlunoDAO alunoDAO;
	
	private Aluno aluno;
	private List<Aluno> alunos;
	private List<Curso> cursos;
	
	public AlunoBean() {
		this.setAluno(new Aluno());
		this.setCursos(new ArrayList<Curso>());
		this.setAlunos(new ArrayList<Aluno>());
	}
	
	@PostConstruct
    public void init() {
        // In @PostConstruct (will be invoked immediately after construction and dependency/property injection).
		this.cursos = cursoDAO.listaTodos();
		this.alunos = alunoDAO.listaTodos();
    }

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public List<Curso> getCursos() {
		if(this.cursos == null){
			this.cursos = cursoDAO.listaTodos();
		}
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}
	
	public void limpaCampos() {
		aluno = new Aluno();
		this.init();
	}
	
	public String adicionar() {
		this.alunoDAO.adiciona(this.aluno);
		
		this.alunos = this.alunoDAO.listaTodos();
		return "cadastrarAlunos";
	}
	
}
