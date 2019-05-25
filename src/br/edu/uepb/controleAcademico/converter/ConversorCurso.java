package br.edu.uepb.controleAcademico.converter;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.uepb.controleAcademico.dao.CursoDAO;
import br.edu.uepb.controleAcademico.dao.Dao;
import br.edu.uepb.controleAcademico.model.Curso;

@Named
@ManagedBean
@RequestScoped
public class ConversorCurso extends ConversorGenerico<Curso> {

	@Inject
	private CursoDAO dao;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Dao<Curso> getDao() {
		return dao;
	}
	
	

}
