/**
 * 
 */
package vista;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import servicio.ClienteServicio;
import servicio.IServicios;
import utilidades.IUtilidad;
import modelo.CategoriaEnum;
import modelo.Cliente;

/**
 * @author marely
 *
 */

public class Menu implements IUtilidad, IServicios<Object> {
	private static int opcion = 0;
	private int n = 0;
	private Cliente cliente = new Cliente();
	private ClienteServicio clienteServicio = new ClienteServicio();
//	private ArchivoServicio archivoServicio = new ArchivoServicio(null);
	static Scanner sc = new Scanner(System.in);
//ExportadorCvs exportadorCvs = new Exportador();


	/**
	 *INICIAR MENU
	 */
	@Override
	public int iniciarMenu() {

		System.out.println("\t-------------- M E N U --------------\n");
		System.out.println("\t[1] Listar clientes");
		System.out.println("\t[2] Agregar cliente");
		System.out.println("\t[3] Editar cliente");
		System.out.println("\t[4] Cargar datos");
		System.out.println("\t[5] Exportar datos");
		System.out.println("\t[6] Salir\n");
		do {
			try {
				System.out.print("\n\tSeleccione una opción :");
				opcion = sc.nextInt();
			} catch (InputMismatchException e) {
				sc.nextLine();
			}
		} while ((opcion < 1) || (opcion > 6));
		return opcion;
	}

	

	
	
	/**
	 *LISTA CLIENTES
	 */
	@Override
	public int listarClientes(List<Cliente> listaclientes) {
		utilidad.tiempoEspera("", 300);
		System.out.println("\n\n\t----------LISTA DE CLIENTES-----------\n");
		for (Cliente c : listaClientes) {
			System.out.println("\tRut      : " + c.getRunCliente().toString());
			System.out.println("\tNombre   : " + c.getNombreCliente().toString());
			System.out.println("\tApellido : " + c.getApellidoCliente().toString());
			System.out.println("\tAños     : " + c.getAniosCliente().toString());
			System.out.println("\tEstado   : " + c.getNombreCategoria().toString());
			System.out.println("\n\t-------------------------------------\n");
		}
		System.out.println("...Fin de la lista...");
		return opcion;
		
	}

	@Override
	public void tiempoEspera(String mensaje, int sleepTimer) {
	}

	@Override
	public void exportar() {
	}

	@Override
	public List cargaDatos() {
		return null;
	}
	
	public ClienteServicio getClienteServicio() {
		return clienteServicio;
	}
	
	/*
	 * ************************************************************
	 */

	private String dato;
	int i=0;

		public void agregarClientes(List<Cliente> listaCliente) {
			
			Cliente[] clientes = new Cliente[i+1];
			 Cliente cliente= new Cliente();
		

			
			clientes[i] = new Cliente();
			sc.nextLine();
			System.out.println("Ingrese rut");
	        dato=sc.nextLine();
	        clientes[i].setRunCliente(dato);
	      
	        System.out.println("Ingrese nombre");
	        dato = sc.nextLine();
	        clientes[i].setNombreCliente(dato);
	      
	        System.out.println("Ingrese apellido");
	        clientes[i].setApellidoCliente(sc.nextLine());
	        System.out.println("Ingrese años");
	        clientes[i].setAniosCliente(sc.nextLine());
	        clientes.clone()[i].setNombreCategoria(CategoriaEnum.activo);
//	    }
	    
//	     imprimir los datos de los clientes creados
//	    for (int i = 0; i < clientes.length; i++) {
//	        System.out.println("Cliente " + (i) + ":");
//	        System.out.println("Rut: " + clientes[i].getRunCliente());
//	        System.out.println("Nombre: " + clientes[i].getNombreCliente());
//	        System.out.println("Apellido: " + clientes[i].getApellidoCliente());
//	        System.out.println("Años: " + clientes[i].getAniosCliente());
//	        System.out.println("Categoria: " + clientes[i].getNombreCategoria());
////	    }
	        listaCliente.add(clientes[i]);
	        System.out.println(listaCliente.toString());
	    i++;
	}



		@Override
		public List<Cliente> agregarCliente() {
			// TODO Auto-generated method stub
			return null;
		}



		@Override
		public void agregarCliente(List<Cliente> listaClientes) {
			// TODO Auto-generated method stub
			
		}



		



}



	/**
	 * @param n the n to set
	 */





//
//	private static void menuExportar() {
//
//		// TODO Auto-generated method stub
//		System.out.println("\n----------Exportar Datos-------------");
//		System.out.println();
//		System.out.println("Seleccione el formato a exportar ");
//		System.out.println();
//		System.out.println("\t[1] formato CSV");
//		System.out.println("\t[2] formato TXT");
//		System.out.println();
//		System.out.println("Ingrese una opción para exportar: ");
//
//		int n = sc.nextInt();
//
//	}
