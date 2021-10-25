package es.curso.modelo.persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import es.curso.modelo.entidad.Coche;
import es.curso.modelo.persistencia.interfaces.DaoCoche;

@Repository
public class CocheDaoJPA implements DaoCoche {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public int alta(Coche c) {
		// TODO Auto-generated method stub
		em.persist(c);
		return c.getId();
	}

	@Override
	public int baja(int id) {
		// TODO Auto-generated method stub
		Coche cAux = em.find(Coche.class, id);
		em.remove(cAux);
		return cAux.getId();
	}

	@Override
	public Coche modificar(Coche c) {
		// TODO Auto-generated method stub
		return em.merge(c);
	}

	@Override
	public Coche obtener(int id) {
		// TODO Auto-generated method stub
		return em.find(Coche.class, id);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Coche> listar() {
		// TODO Auto-generated method stub
		List<Coche> listaCoches = em.createQuery("from Coche c").getResultList();
		return listaCoches;
	}

	
}
