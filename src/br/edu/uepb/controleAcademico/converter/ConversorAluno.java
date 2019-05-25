package br.edu.uepb.controleAcademico.converter;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.uepb.controleAcademico.dao.AlunoDAO;
import br.edu.uepb.controleAcademico.dao.Dao;
import br.edu.uepb.controleAcademico.model.Aluno;

@Named
@ManagedBean
@RequestScoped
public class ConversorAluno extends ConversorGenerico<Aluno> {
	
	@Inject
	private AlunoDAO dao;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Dao<Aluno> getDao() {
		return dao;
	}
	
	

}
