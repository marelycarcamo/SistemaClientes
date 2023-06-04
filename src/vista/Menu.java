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
	 * AGREGAR CLIENTES
	 */
	@Override
	public List<Cliente> agregarCliente() {
	
		String dato = "";
		sc.nextLine();
		System.out.print("\n\tRut cliente      : ");
		dato = sc.nextLine();
		if (dato != "") {
			cliente.setRunCliente(dato);
		
		}

		System.out.print("\n\tNombre cliente   : ");
		dato = sc.nextLine();
		if (dato != "") {
			cliente.setNombreCliente(dato);
		}

		System.out.print("\n\tApellido cliente : ");
		dato = sc.nextLine();
		if (dato != "") {
			cliente.setApellidoCliente(dato);
		}

		System.out.print("\n\tAños cliente     : ");
		dato = sc.nextLine();
		if (dato != "") {
			cliente.setAniosCliente(dato);
		}

		cliente.setNombreCategoria(CategoriaEnum.activo);
		
		System.out.println(cliente.toString());
		IServicios.listaClientes.add(cliente);
		System.out.println("Lista: " + listaClientes);
		utilidad.tiempoEspera("regreso al menu principal", 300);
//		opcionesMenu();
		return IServicios.listaClientes;
		
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



	/**
	 * @return the n
	 */
	public int getN() {
		return n;
	}



	/**
	 * @param n the n to set
	 */
	public void setN(int n) {
		this.n = n;
	}

}

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
