/**
 * 
 */
package servicio;

import java.util.List;
import java.util.ArrayList;
import modelo.Cliente;

/**
 * @author marely
 *
 */
public interface IExportador extends IArchivos {
	Cliente cliente = new Cliente();
	List<Cliente> listaCl = new ArrayList<Cliente>();
	@SuppressWarnings("rawtypes")
	ExportadorTxt exportadorTxt = new ExportadorTxt();
	ExportadorCsv exportadorCsv = new ExportadorCsv();
	

	
	int menuExportarFormato();
	

	void exportar(List<Cliente> listaClientes, String path);

 



	void exportar();


	String rutaArchivo(int tipoSistema);


	

}
