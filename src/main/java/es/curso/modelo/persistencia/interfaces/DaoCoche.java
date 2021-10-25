package es.curso.modelo.persistencia.interfaces;

import java.util.List;

import es.curso.modelo.entidad.Coche;

public interface DaoCoche {

	int alta(Coche c);
	int baja(int id);
	Coche modificar(Coche c);
	Coche obtener(int id);
	List <Coche> listar();
	
}
