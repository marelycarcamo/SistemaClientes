/**
 * 
 */
package servicio;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

import modelo.CategoriaEnum;
import modelo.Cliente;

/**
 * @author marely
 *
 */
public class ArchivoServicio implements IServicios<Object> {

	@Override
	public List<Cliente> cargaDatos() {

//		List<Cliente> listaClientes = new ArrayList<Cliente>();

		String path = "src/Directorio/DBClientes.csv";

		File file = new File(path);

		try {
			if (file.exists()) {
				if (file.canRead()) {

					Scanner sc = new Scanner(file);

					while (sc.hasNextLine()) {

						String linea = sc.nextLine();
						StringTokenizer atributo = new StringTokenizer(linea, ",");
						Cliente cliente = new Cliente();
						// System.out.println(sc.nextLine());

						while (atributo.hasMoreElements()) {
							// empleado.setID(Integer.parseInt(atributo.nextElement().toString()));
							cliente.setRunCliente((atributo.nextElement().toString()));
							cliente.setNombreCliente((atributo.nextElement().toString()));
							cliente.setApellidoCliente((atributo.nextElement().toString()));
							cliente.setAniosCliente((atributo.nextElement().toString()));
							cliente.setNombreCategoria(CategoriaEnum.valueOf((atributo.nextElement().toString())));
						}

						IServicios.listaClientes.add(cliente);
					}

					sc.close();
//				
//					System.out.println(listaClientes.toString());
			listaClientes.forEach(x -> System.out.println(x+"\n"));

				}
			} else {
				System.out.println(("El archivo no existe !!"));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return listaClientes;

	}

	private CategoriaEnum CategoriaEnum(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void exportar() {
	}



	@Override
	public int listarClientes(List<Cliente> listaClientes) {
		return 0;
		// TODO Auto-generated method stub

	}

	@Override
	public int iniciarMenu() {
		// TODO Auto-generated method stub
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
