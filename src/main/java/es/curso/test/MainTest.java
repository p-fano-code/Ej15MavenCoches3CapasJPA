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
		Scanner sc = new Scanner(System.in);		
		context = new AnnotationConfigApplicationContext(ConfigJPA.class);
		System.out.println("Inicializando BBDD...");
		
		String stringScanner;
		int intScanner;
		boolean init = true;
		
		GestorCoche gc = context.getBean(GestorCoche.class);
		System.out.println("Bienvenido, ¿qué operación deseas hacer?");
		do {
			System.out.println("1-Agregar un nuevo coche");
			System.out.println("2-Borrar un coche existente");
			System.out.println("3-Modificar un coche existente");
			System.out.println("4-Mostrar un coche por su id");
			System.out.println("5-Listar todos los coches");
			System.out.println("0-Salir");
			int opcion = sc.nextInt(); 
			switch (opcion) {
			case 1:
				Coche agregacion = context.getBean("coche",Coche.class);
				
				System.out.println("Introduce una matricula válida: ");
				stringScanner = sc.next();
				agregacion.setMatricula(stringScanner);
				
				System.out.println("Introduce una marca: ");
				stringScanner = sc.next();
				agregacion.setMarca(stringScanner);
				
				System.out.println("Introduce un modelo:");
				stringScanner = sc.next();
				agregacion.setModelo(stringScanner);
				
				System.out.println("Introduce los kiómetros:");
				intScanner = sc.nextInt();
				agregacion.setKilometros(intScanner);
				
				gc.alta(agregacion);
				System.out.println("El coche se dió de alta!!");
				break;
			
			case 2:
				System.out.println("Introduce el id del coche que deseas eliminar:");
				intScanner = sc.nextInt();
				gc.baja(intScanner);
				System.out.println("El coche se dió de baja!!");
				break;
			
			case 3:
				System.out.println("Introduce el id del coche que deseas modificar");
				intScanner = sc.nextInt();
				Coche modificacion = gc.obtener(intScanner);
				
				System.out.println("Introduce una matricula válida: ");
				stringScanner = sc.next();
				modificacion.setMatricula(stringScanner);
				
				System.out.println("Introduce una marca: ");
				stringScanner = sc.next();
				modificacion.setMarca(stringScanner);
				
				System.out.println("Introduce un modelo:");
				stringScanner = sc.next();
				modificacion.setModelo(stringScanner);
				
				System.out.println("Introduce los kiómetros:");
				intScanner = sc.nextInt();
				modificacion.setKilometros(intScanner);
				
				gc.modCoche(modificacion);
				System.out.println("El coche modificó!!");
				break;
				
			case 4:
				System.out.println("Introduce el id del coche que quieres ver: ");
				intScanner = sc.nextInt();
				System.out.println(gc.obtener(intScanner));
				break;
				
			case 5:
				System.out.println(gc.listar());
				break;
			
			case 0:
				 init = false;
				 System.out.println("Hasta la próxima");
				break;
				
			default:
				System.out.println("Introduce una opcion correcta.");;
			}
			
		} while (init);
		
		
		
		
	
	}

}
