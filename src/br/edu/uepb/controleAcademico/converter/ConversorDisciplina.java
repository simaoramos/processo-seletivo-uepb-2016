package br.edu.uepb.controleAcademico.converter;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.uepb.controleAcademico.dao.Dao;
import br.edu.uepb.controleAcademico.dao.DisciplinaDAO;
import br.edu.uepb.controleAcademico.model.Disciplina;

@Named
@ManagedBean
@RequestScoped
public class ConversorDisciplina extends ConversorGenerico<Disciplina> {

	@Inject
	private DisciplinaDAO dao;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	public Dao<Disciplina> getDao() {
		return dao;
	}
	
	

}
