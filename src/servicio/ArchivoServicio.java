/**
 * 
 */
package servicio;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import modelo.CategoriaEnum;
import modelo.Cliente;

/**
 * @author marely
 *
 */
public class ArchivoServicio implements IArchivos {

	boolean listaCargada = false;

	/***************************************
	 * CargarDatos
	 *
	 */
	@Override
	public List<Cliente> cargarDatos(List<Cliente> listaClientes) {

//		 List<Cliente>listaArchivo = new ArrayList<Cliente>();

		if (listaCargada == false) {
			String path = "src/directorio/DBClientes.csv";

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
								cliente.setAniosCliente(Integer.parseInt(atributo.nextElement().toString()));
								cliente.setNombreCategoria(CategoriaEnum.valueOf((atributo.nextElement().toString())));
							}

							listaClientes.add(cliente);
						}
						if (listaClientes.isEmpty()) {
							System.out.println("\n\tEl archivo no contiene datos para ser cargados ! \n");
						} else {

							listaClientes.forEach(x -> System.out.println(x + "\n"));
							System.out.println("\n\n\t*** Los datos externos se cargaron con éxito !! ***\n\n");

						}
						sc.close();
					}

				} else {
					System.out.println(("\n\tEl archivo no existe !!"));
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

		} else {

			System.out.println("\n\t *** Los datos del archivo ya se encuentran cargados en sistema ***\n");
		}

		listaCargada = true;
		return listaClientes;

	}

	@Override
	public int menuTipoSistema() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String rutaArchivo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cliente> cargarDatos() {
		// TODO Auto-generated method stub
		return null;
	}

}
