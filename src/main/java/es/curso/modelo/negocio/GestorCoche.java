package es.curso.modelo.negocio;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.curso.modelo.entidad.Coche;
import es.curso.modelo.persistencia.CocheDaoJPA;
import es.curso.modelo.persistencia.interfaces.DaoCoche;
@Service
public class GestorCoche {

	@Autowired
	private DaoCoche cocheDao;
	
	@Transactional
	public int alta(Coche c) {
		if(c.getMatricula().length() == 7 &&
				   c.getMatricula().length() > 0 &&
				   c.getMarca().length() > 0 &&
				   c.getModelo().length() > 0) {
			
				cocheDao.alta(c);
				return c.getId();
					
			}				
				System.out.println("ERROR");
				System.out.println("La matricula debe contener 7 caracteres");
				System.out.println("La marca y el modelo no pueden estar vacios");
				return 0;
	}
	
	@Transactional
	public void baja(int id) {
		cocheDao.baja(id);
	}
	
	@Transactional
	public Coche modCoche(Coche c) {
		if(c.getMatricula().length() == 7 &&
				   c.getMatricula().length() > 0 &&
				   c.getMarca().length() > 0 &&
				   c.getModelo().length() > 0) {
			
				return cocheDao.modificar(c);
					
			}				
				System.out.println("ERROR");
				System.out.println("La matricula debe contener 7 caracteres");
				System.out.println("La marca y el modelo no pueden estar vacios");
				return c;
	}
	
	
	public Coche obtener(int id){
		return cocheDao.obtener(id);
	}
	
	public List<Coche> listar(){
		return cocheDao.listar();
	}
	
}
