package vista;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import modelo.Cliente;
import servicio.ArchivoServicio;
import servicio.ClienteServicio;
import servicio.IExportador;

public class Menu {
	String elRut;
	int opcion1 = 0;
	int i = 0; // contador del arreglo
	ArchivoServicio archivoServicio = new ArchivoServicio();
	ClienteServicio clienteServicio = new ClienteServicio();
	Scanner sc = new Scanner(System.in);
	List<Cliente> listaClientes = new ArrayList<Cliente>();
	Menu menu = new Menu();
	Cliente rutClienteEncontrado = new Cliente();

	/***************************************************
	 * 
	 * INICIAR MENU
	 * 
	 ***************************************************/

	public void iniciarMenu() {

		do {
			opcion1 = elMenu();
			try {
				switch (opcion1) {

				case 1:
					if (listaClientes.isEmpty()) {
						System.out.println("\n\t*** La lista se encuentra vacía! ***\n\n");
					} else {
						clienteServicio.listarClientes(listaClientes);
					}
					break;

				case 2:
					listaClientes = clienteServicio.agregarCliente(listaClientes);
					break;

				case 3:
					listaClientes = clienteServicio.editarCliente(listaClientes);
					break;

				case 4:
					listaClientes = archivoServicio.cargarDatos(listaClientes);
					break;

				case 5:
					String ruta = null;
					try {
						System.out.println("exportar datos");
						int tipoFormato = IExportador.exportadorTxt.menuExportarFormato();
						int tipoSistema = IExportador.exportadorTxt.menuTipoSistema();

						if (tipoFormato == 2) {
							ruta = IExportador.exportadorTxt.rutaArchivo(tipoSistema);
						}

						System.out.println("ruta: " + ruta);

//						if (tipoFormato==1) {
//							IExportador.exportadorCsv.rutaArchivo(tipoSistema);
//						}

//						IExportador.exportadorTxt.exportar(listaClientes,"src/directorio/BDClientes.txt");

					} catch (Exception e) {
						e.printStackTrace();
					}

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
		} while (opcion1 != 6);
	}

	/**************************************************************************
	 * 
	 * ...................EL MENU PRINCIPAL
	 * 
	 * @return
	 ***************************************************************************/
	public int elMenu() {
		System.out.println("\t-------------- M E N U --------------\n");
		System.out.println("\t[1] Listar clientes");
		System.out.println("\t[2] Agregar cliente");
		System.out.println("\t[3] Editar cliente");
		System.out.println("\t[4] Cargar datos");
		System.out.println("\t[5] Exportar datos");
		System.out.println("\t[6] Salir\n");
		do {
			try {
				System.out.print("\n\tSeleccione una opción:");
				while (!sc.hasNextInt()) {
					System.out.print("\tError! \n\tDebe ingresar un número entero :");
					sc.next();
				}
				opcion1 = sc.nextInt();
			} catch (InputMismatchException e) {
				sc.next();
			}
		} while ((opcion1 < 1) || (opcion1 > 6));
		return opcion1;
	}

}
