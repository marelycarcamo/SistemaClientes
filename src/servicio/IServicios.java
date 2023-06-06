/**
 * 
 */
package servicio;

import java.util.List;
import java.util.ArrayList;
import modelo.Cliente;
import vista.Menu;
/**
 * @author marely
 * @param <listaClientes>
 * @param <ExportadorCvs>
 *
 */

public interface IServicios<listaClientes> {
	
	ArchivoServicio archivoServicio = new ArchivoServicio();
	List<Cliente> listaClientes = new ArrayList<Cliente>();
	Menu menu = new Menu();
	
	void exportar();
	
	List<Cliente> cargaDatos();

	void agregarCliente(List<Cliente>listaClientes);

	int listarClientes(List<Cliente> listaClientes);
	int iniciarMenu();

	/**
	 * AGREGAR CLIENTES
	 */
	List<Cliente> agregarCliente();


	



	

	
	
}
