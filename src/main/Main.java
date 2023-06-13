/**
 * 
 */
package main;

import vista.*;


/**
 * @author marely
 *
 */
public class Main {
	static int opcion = 0;

	/**
	 * @param args
	 * @param listaClientes
	 */
	public static void main(String[] args) {
	
		Menu menu = new Menu();
		menu.iniciarMenu();
//		do {
//			opcion = IServicios.menu.iniciarMenu();
//			try {
//				switch (opcion) {
//				case 1:
//					clienteServicio.listarClientes(lista);
//				
//					break;
//				case 2:
//					// metodo agregar cliente
//					lista= clienteServicio.agregarCliente(lista);
//					break;
//				case 3:
//					// editar
//					Menu.menu.menuEditar1();
//					// IServicios.menu.editarCliente(listaClientes);
//					break;
//				case 4:
//					lista = ArchivoServicio.archivoServicio.cargarDatos();
//
//					System.out.println("\n\t-----------LISTA CARGADA ------------\n\n");
//					break;
//
//				case 5:
//					String ruta = null;
//					try {
//						System.out.println("exportar datos");
//						int tipoFormato = IExportador.exportadorTxt.menuExportarFormato();
//						int tipoSistema = IExportador.exportadorTxt.menuTipoSistema();
//
//						if (tipoFormato == 2) {
//							ruta = IExportador.exportadorTxt.rutaArchivo(tipoSistema);
//						}
//
//						System.out.println("ruta: " + ruta);
//
////						if (tipoFormato==1) {
////							IExportador.exportadorCsv.rutaArchivo(tipoSistema);
////						}
//
////						IExportador.exportadorTxt.exportar(listaClientes,"src/directorio/BDClientes.txt");
//
//					} catch (Exception e) {
//						e.printStackTrace();
//					}
//
////				menuExportar();
//					break;
//				case 6:
//					// salir
//					System.out.println("FIN DEL PROGRAMA");
//					System.exit(0);
//				}
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		} while (opcion != 6);
	}

}
