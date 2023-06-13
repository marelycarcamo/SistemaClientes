package servicio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import modelo.CategoriaEnum;
import modelo.Cliente;
import java.util.InputMismatchException;


public class ClienteServicio {

	Scanner sc = new Scanner(System.in);
	private List<Cliente> listaClientes = new ArrayList<Cliente>();
	private Cliente clienteEncontrado = new Cliente(); //cliente encontrado por el numero de rut

	/***************************************************
	 * AGREGAR CLIENTE|
	 * 
	 * @return
	 * 
	 ****************************************************/
//	@Override
	public List<Cliente> agregarCliente(List<Cliente> listaClientes) {
		int i = 0;
		String xdato = "";

		Cliente[] clientes = new Cliente[i + 1];
		clientes[i] = new Cliente();

//
		System.out.println("\n\n\t----------- MENU INGRESO CLIENTE -----------\n");
		while (xdato.isEmpty()) {
			System.out.print("\n\tIngrese rut      : ");
			xdato = sc.nextLine();
			clientes[i].setRunCliente(xdato);
		}
		boolean encontrado = false;
		for (Cliente c : listaClientes) {
			if (c.getRunCliente().equals(clientes[i].getRunCliente())) {
				clienteEncontrado = c;
				encontrado = !encontrado;
			}
		}
		if (!encontrado) {
			xdato = "";
			while (xdato.isEmpty()) {
				System.out.print("\n\tIngrese nombre   : ");
				xdato = sc.nextLine();
				clientes[i].setNombreCliente(xdato);
			}
			xdato = "";
			while (xdato.isEmpty()) {

				System.out.print("\n\tIngrese apellido : ");
				xdato = sc.nextLine();
				clientes[i].setApellidoCliente(xdato);
			}

			int iagno = 0;
			boolean flag = false;
			while (flag == false) {
				System.out.print("\n\tIngrese años     : ");

				try {
					iagno = sc.nextInt();

					clientes[i].setAniosCliente(iagno);

					clientes.clone()[i].setNombreCategoria(CategoriaEnum.ACTIVO);

					listaClientes.add(clientes[i]);

					flag = true;
				} catch (InputMismatchException e) {
					System.out.println("Error. Ingresar solo datos numéricos");
					sc.nextLine();
					flag = false;
				}
			}
			i++;
			System.out.println("\n\tLOS DATOS SE GUARDARON CORRECTAMENTE !!\n\n");

			for (Cliente c : clientes) {
				System.out.println("\n\tRUT      " + c.getRunCliente());
				System.out.println("\n\tNOMBRE   " + c.getNombreCliente());
				System.out.println("\n\tAPELLIDO " + c.getAniosCliente());
				System.out.println("\n\tESTADO   " + c.getNombreCategoria(CategoriaEnum.values()));
			}
		} else {
			System.out.println("\n\n\t*** El cliente ya existe ***\n");
		}
		return listaClientes;
	}

	/********************************************************
	 * ....................LISTAR CLIENTES....................
	 * 
	 * ................@param listaClientes..................
	 * 
	 * @param listaClientes
	 ********************************************************/

	public void listarClientes(List<Cliente> listaClientes) {

//	listaClientes.forEach(x->System.out.println(x));

//		
		System.out.println("\n\tlistaClientes :" + listaClientes.size() + "\n");

		for (Cliente c : listaClientes) {
			System.out.println("\tRut      : " + c.getRunCliente().toString());
			System.out.println("\tNombre   : " + c.getNombreCliente().toString());
			System.out.println("\tApellido : " + c.getApellidoCliente().toString());
			System.out.println("\tAños     : " + c.getAniosCliente().toString());
			System.out.println("\tEstado   : " + c.getNombreCategoria(CategoriaEnum.values()).toString());
			System.out.println("\n\t-------------------------------------\n");
		}

	}

	/************************************************************************
	 * ................EDITAR CLIENTES * @param listaClientes
	 * 
	 * @param listaClientes *
	 * 
	 ***********************************************************************/
	public List<Cliente> editarCliente(List<Cliente> listaClientes) {
//		Cliente clienteEncontrado = new Cliente();
		String elRut = null;
		int op1 = menuEditarCliente();
		boolean encontrado = false;
		sc.nextLine();
		if (listaClientes.isEmpty()) {
			System.out.println("\n\t*** La lista se encuentra vacía! ***\n\n");
		} else {

			do {
				try {
					System.out.print("\n\n\tIngrese rut del cliente: ");

					elRut = sc.nextLine();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					sc.nextLine();
				}

				for (Cliente c : listaClientes) {
					if (c.getRunCliente().equals(elRut)) {
						clienteEncontrado = c;
						encontrado = !encontrado;
					}
				}

			} while (elRut == "");

			if (encontrado) {
				if (op1 == 1) {
					menuEditarEstado(clienteEncontrado);
				} else if (op1 == 2) {
					editarDatos(clienteEncontrado);
				}
			} else {
				System.out.println("\n\n\t*** El cliente no existe ***\n\n");

			}
		}
		return listaClientes;
	}

	/*****************************************************************************
	 * MENU EDITAR CLIENTE ................................................... Este
	 * menú entrega las siguientes opciones: - cambiar el estado del ciente de
	 * ACTIVO A INACTIVO. - editar los datos del cliente Este método es llamado por
	 * el método principal de EDITAR.
	 ****************************************************************************/
	public int menuEditarCliente() {
		int op1 = 0;

		System.out.println("\n\n\t--------- EDITAR CLIENTE ---------\n");
		System.out.println("\n\t[1] Cambiar estado del cliente");
		System.out.println("\n\t[2] Editar datos del cliente\n");
		System.out.println("\n\t----------------------------------\n");
		do {
			try {
				System.out.print("\n\tSeleccione una opción del menú :");
				while (!sc.hasNextInt()) {
					System.out.print("\n\tError! \n\tDebe ingresar un número entero :");
					sc.next();
				}
				op1 = sc.nextInt();

			} catch (InputMismatchException e) {
				sc.next();
			}
			System.out.print((op1 == 1) ? "\n\t----------CAMBIAR ESTADO ---------" : "");
			System.out.print((op1 == 2) ? "\n\t---------- EDITAR DATOS ----------" : "");
		} while ((op1 != 1) && (op1 != 2));
		return op1;
	}

	/***********************************************************************************
	 * ...........MENU CAMBIAR ESTADO DEL CLIENTE
	 * 
	 * @param clienteEncontrado
	 *************************************************************************************/
	public void menuEditarEstado(Cliente clienteEncontrado) {
		int opEstado = 0;
		CategoriaEnum nuevoEstado = null;
		System.out.println("\n\tIngrese solo datos numériocs!!\n");
		System.out.println("\n\n\t------ ACTUALIZANDO ESTADO DEL CLIENTE --------\n");
		CategoriaEnum estadoCliente = clienteEncontrado.getNombreCategoria(CategoriaEnum.values());
		nuevoEstado = (estadoCliente == CategoriaEnum.INACTIVO) ? CategoriaEnum.ACTIVO : CategoriaEnum.INACTIVO;
//		System.out.println("nuevo estado " + nuevoEstado);
		System.out.println("\n\t    ESTADO ACTUAL  : " + estadoCliente.toString());
		System.out.println("\n\t[1] Cambiar estado a " + nuevoEstado.toString().toLowerCase());
		System.out.println("\n\t[2] Mantener estado actual");
		System.out.println("\n-----------------------------------------\n");

		/*
		 * validacion de las opciones del menú
		 */
		do {
			try {
				System.out.print("\n\tSeleccione una opción del menú :");
				while (!sc.hasNextInt()) {
					System.out.print("\tError! \n\tDebe ingresar un número entero :");
					sc.next();
				}
				opEstado = sc.nextInt();
			} catch (InputMismatchException e) {
				sc.next();
			}
		} while ((opEstado < 1) && (opEstado > 2));

		/*
		 * proceso de cambio de estado del cliente.
		 */
		if (opEstado == 1) {
			clienteEncontrado.setNombreCategoria(nuevoEstado);

			System.out.println("\n\t*** El estado del cliente ha sido actualizado a : "
					+ clienteEncontrado.getNombreCategoria(CategoriaEnum.values()));

		} else if (opEstado == 2) {
			System.out.println("\n\tSu estado actual es " + estadoCliente + "\n");
		}

		listarRegistro(clienteEncontrado);

	}

	/******************************************************************************
	 * ..................... ACTUALIZANDO DATOS DEL CLIENTES
	 * 
	 * @param clienteEncontrado
	 ***************************************************************************/

	public void editarDatos(Cliente clienteEncontrado) {
		int x = 0;
		String dato = "";
		int datoNum = 0;

		System.out.println("\n\t-----ACTUALIZANDO DATOS DEL CLIENTE------\n");
		
		menuListarRegistro(clienteEncontrado);
		do {
			try {
				System.out.print("\n\tSeleccione una opción del menú:");
				while (!sc.hasNextInt()) {
					System.out.print("\tError! \n\tDebe ingresar un número entero :");
					sc.next();
				}
				x = sc.nextInt();
			} catch (InputMismatchException e) {
				sc.next();
			}
		} while ((x < 1) || (x > 4));

		sc.nextLine();

		switch (x) {
		case 1:
			while (dato.isEmpty()) {
				System.out.print("\n\tRUT CLIENTE : ");
				dato = sc.nextLine();
			}
			clienteEncontrado.setRunCliente(dato);
			break;
		case 2:
			while (dato.isEmpty()) {
				System.out.print("\n\tNOMBRE CLIENTE : ");
				dato = sc.nextLine();
			}
			clienteEncontrado.setNombreCliente(dato);
			break;
		case 3:
			while (dato.isEmpty()) {
				System.out.print("\n\tAPELLIDO CLIENTE : ");
				dato = sc.nextLine();
			}
			clienteEncontrado.setApellidoCliente(dato);
			break;
		case 4:
			while (dato.isEmpty()) {
				System.out.print("\n\tAÑOS COMO CLIENTE : ");
				try {
					dato = sc.nextLine();
					try {
						datoNum = Integer.valueOf(dato);
					} catch (NumberFormatException e) {
						System.out.println("ingrese valores numéricos 1");
					}
				} catch (InputMismatchException e) {
					System.out.println("\n\tError. Ingrese un dato número 2\n");
				}
			}
			clienteEncontrado.setAniosCliente(datoNum);
			break;
		}

		System.out.println("\n\n\t*** Los datos se actualizaron correctamente ***\n");
		menuListarRegistro(clienteEncontrado);
	}

	/**********************************************************************************
	 * LISTADO DE REGISTRO
	 * 
	 * @param clienteEncontrado
	 *********************************************************************************/
	public void listarRegistro(Cliente clienteEncontrado) {
		System.out.println("\t RUT       " + clienteEncontrado.getRunCliente().toString());
		System.out.println("\t NOMBRE    " + clienteEncontrado.getNombreCliente().toString());
		System.out.println("\t APELLIDO  " + clienteEncontrado.getApellidoCliente().toString());
		System.out.println("\t AÑOS      " + clienteEncontrado.getAniosCliente().toString());
		System.out.println("\t ESTADO    " + clienteEncontrado.getNombreCategoria(CategoriaEnum.values()));

	}

	void menuListarRegistro(Cliente clienteEncontrado) {
		System.out.println("\t[1] RUT      " + clienteEncontrado.getRunCliente().toString());
		System.out.println("\t[2] NOMBRE   " + clienteEncontrado.getNombreCliente().toString());
		System.out.println("\t[3] APELLIDO " + clienteEncontrado.getApellidoCliente().toString());
		System.out.println("\t[4] AÑOS     " + clienteEncontrado.getAniosCliente().toString());

	}

	/*
	 * ***********************************************************************
	 * ***********************************************************************
	 */

	/**
	 * @return the listaClientes
	 */
	public List<Cliente> getListaClientes() {
		return listaClientes;
	}

	/**
	 * @param listaClientes the listaClientes to set
	 */
	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

	@Override
	public String toString() {
		return "ClienteServicio [listaClientes=" + listaClientes + "]";
	}

	/**
	 * @return the clienteEncontrado
	 */
	public Cliente getClienteEncontrado() {
		return clienteEncontrado;
	}

	/**
	 * @param clienteEncontrado the clienteEncontrado to set
	 */
	public void setClienteEncontrado(Cliente clienteEncontrado) {
		this.clienteEncontrado = clienteEncontrado;
	}

}// fin de la clase