package servicio;

import java.util.ArrayList;
import java.util.List;

import modelo.Cliente;

public interface IArchivos {
	



	ArchivoServicio archivoServicio = new ArchivoServicio();
	/**
	 * @return Este método selecciona el tipo de sistema operativo
	 */
	int menuTipoSistema();
	
	
	/**
	 * @return 
	 * @return Este método permite ingresar la ruta del archivo
	 */
	 String rutaArchivo();

	List<Cliente> cargarDatos();


	/***************************************
	 *CargarDatos
	 *
	 */
	List<Cliente> cargarDatos(List<Cliente> listaClientes);




	
	

}
