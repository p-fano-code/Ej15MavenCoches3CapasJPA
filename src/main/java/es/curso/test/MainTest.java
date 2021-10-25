package es.curso.test;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import es.curso.cfg.ConfigJPA;
import es.curso.modelo.entidad.Coche;
import es.curso.modelo.negocio.GestorCoche;

public class MainTest {
	private static ApplicationContext context;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
				
		context = new AnnotationConfigApplicationContext(ConfigJPA.class);
		System.out.println("Inicializando BBDD...");
		
		Coche c = context.getBean("coche",Coche.class);
		c.setMatricula("1234ABC");
		c.setMarca("Seat");
		c.setModelo("C�rdoba");
		c.setKilometros(200000);
		
		
		GestorCoche gc = context.getBean(GestorCoche.class);
		int id = gc.alta(c);
		System.out.println("Se insert� el coche con id: "+id);
		System.out.println(gc.obtener(id));
		System.out.println("Estos son los coches que tienes:");
		System.out.println(gc.listar());
	
	}

}
