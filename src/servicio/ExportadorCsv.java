/**
 * 
 */
package servicio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

import modelo.CategoriaEnum;
import modelo.Cliente;

/**
 * @author marely
 * @param <Cliente>
 *
 */

public class ExportadorCsv  {

	public void rutaArchivo(int tipoSistema) {
		// TODO Auto-generated method stub
		
	}

//	private String clienteTexto = "";
//	private 
//	public void exportar(List listaCliente, String path) {
//System.out.println("en el método exportar");
//		File file = new File(path);
//
//		for (Cliente c : listaClientes) {
//		    clienteTexto += c.getRunCliente() + "," + c.getNombreCliente() + "," + c.getApellidoCliente() + ","
//		            + c.getAniosCliente() + "," + c.getNombreCategoria(CategoriaEnum.values()) + "\n";
//		}
//		
//		try {
//
//			if (file.exists()) {
//				System.out.println("El archivo ya existe, se sobreescribirá");
//			} else {
//				file.createNewFile();
//				FileWriter fw = new FileWriter(file);
//				BufferedWriter bw = new BufferedWriter(fw);
//				bw.write(clienteTexto);
//				bw.close();
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	//



}
