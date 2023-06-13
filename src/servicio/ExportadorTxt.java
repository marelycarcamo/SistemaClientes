package servicio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;
import java.util.Scanner;

import modelo.CategoriaEnum;
import modelo.Cliente;

public class ExportadorTxt implements IExportador {
	Scanner sc = new Scanner(System.in);

	private String clienteTexto = "";

	@Override
	public int menuExportarFormato() {

		// TODO Auto-generated method stub
		System.out.println("\n----------Exportar Datos-------------");
		System.out.println();
		System.out.println("Seleccione el formato a exportar ");
		System.out.println();
		System.out.println("\t[1] formato CSV");
		System.out.println("\t[2] formato TXT");
		System.out.println("\nIngrese una opción para exportar: ");//
		int n = sc.nextInt();
		return n;
	}

	@Override
	public int menuTipoSistema() {
		// TODO Auto-generated method stub
		System.out.println("\n\n----------Exportar Datos-------------\n");
		System.out.println("{1} Exportar datos en Linux o Mac");
		System.out.println("[2] Exportar datos en Windows");
		System.out.println("\nIngrese una opción para exportar: ");//
		int x = sc.nextInt();
		return x;
	}

	@Override
	public String rutaArchivo(int tipoSistema) {
		String ruta, leeRuta;
		sc.nextLine();
		String so = (tipoSistema == 1) ? "Linux o Mac" : "Windows";
		System.out.println("------- Exportar datos en " + so + "-------");
		System.out.println("Ingrese la ruta donde desea ingresar el archivo 'DBClientes.txt'");

		System.out.println("\nejemplo: ");

		System.out.println(tipoSistema == 1 ? "home/usuario/Desktop" : "c://home/usuario/equipo/Desktop");

		leeRuta = sc.nextLine();
		System.out.println("--------------------------------------------");

		// TODO Auto-generated method stub
		return leeRuta;
	}

	private String Path(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void exportar(List<Cliente> listaClientes, String path) {
		System.out.println("en el método exportar");
		File file = new File(path);

		for (Cliente c : listaClientes) {
			clienteTexto += c.getRunCliente() + "," + c.getNombreCliente() + "," + c.getApellidoCliente() + ","
					+ c.getAniosCliente() + "," + c.getNombreCategoria(CategoriaEnum.values()) + "\n";
		}

		try {

			if (file.exists()) {
				System.out.println("El archivo ya existe, se sobreescribirá");
			} else {
				file.createNewFile();
				FileWriter fw = new FileWriter(file);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(clienteTexto);
				bw.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void exportar() {
		// TODO Auto-generated method stub

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

	@Override
	public List<Cliente> cargarDatos(List<Cliente> listaClientes) {
		// TODO Auto-generated method stub
		return null;
	}

}
