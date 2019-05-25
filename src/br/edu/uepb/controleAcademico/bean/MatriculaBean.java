package br.edu.uepb.controleAcademico.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.uepb.controleAcademico.dao.AlunoDAO;
import br.edu.uepb.controleAcademico.dao.DisciplinaDAO;
import br.edu.uepb.controleAcademico.dao.MatriculaDAO;
import br.edu.uepb.controleAcademico.model.Aluno;
import br.edu.uepb.controleAcademico.model.Disciplina;
import br.edu.uepb.controleAcademico.model.Matricula;
import br.edu.uepb.controleAcademico.model.Turno;

@RequestScoped
@Named
public class MatriculaBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private MatriculaDAO matriculaDAO;
	@Inject
	private DisciplinaDAO disciplinaDAO;
	@Inject
	private AlunoDAO alunoDAO;
	
	private Matricula matricula;
	private List<Matricula> matriculas;
	private List<Disciplina> disciplinas;
	private List<Aluno> alunos;
	private Turno turno;
	
	public MatriculaBean() {
		this.setMatricula(new Matricula());
		this.setDisciplinas(new ArrayList<Disciplina>());
		this.setAlunos(new ArrayList<Aluno>());
	}
	
	@PostConstruct
    public void init() {
        // In @PostConstruct (will be invoked immediately after construction and dependency/property injection).
		this.disciplinas = disciplinaDAO.listaTodos();
		this.alunos = alunoDAO.listaTodos();
    }

	public Matricula getMatricula() {
		return matricula;
	}

	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
	
	public List<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}

	public Turno getTurno() {
		return turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}

	public void limpaCampos() {
		matricula = new Matricula();
		this.init();
	}
	
	public String adicionar() {
		this.matriculaDAO.adiciona(this.matricula);
		
		this.matriculas = this.matriculaDAO.listaTodos();
		return "matricularEmDisciplina";
	}
	
}
