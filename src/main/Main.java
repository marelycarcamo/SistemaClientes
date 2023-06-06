/**
 * 
 */
package main;

import java.util.List;

import modelo.Cliente;
import servicio.IServicios;
import utilidades.IUtilidad;
import vista.Menu;

/**
 * @author marely
 *
 */
public class Main implements IServicios<Object> {
	static int opcion = 0;
	static Menu menu = new Menu();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		do {
			opcion = IServicios.menu.iniciarMenu();
			try {
				switch (opcion) {
				case 1:
					// metodo listar clientes
					IServicios.menu.listarClientes(listaClientes);
					System.out.println(opcion);
					break;
				case 2:
					// metodo agregar cliente
					IServicios.menu.agregarClientes(listaClientes);
					break;
				case 3:
					// editar
					System.out.println("editar clientes");
					break;
				case 4:
					// cargar datos
					
					List<Cliente> listaClientes = IServicios.archivoServicio.cargaDatos();
					System.out.println("\n-------LISTA CARGADA -------");
					break;
				case 5:
					// exportar datos
					System.out.println("exportar datos");
//				menuExportar();
					break;
				case 6:
					// salir
					System.out.println("FIN DEL PROGRAMA");
					System.exit(0);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} while (opcion != 6);
	}

	@Override
	public void exportar() {
	}

	@Override
	public List<Cliente> cargaDatos() {
		return null;
	}


	@Override
	public int listarClientes(List listaClientes) {
		return 0;
	}

	@Override
	public int iniciarMenu() {
		return 0;
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
