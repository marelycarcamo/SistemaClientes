/**
 * 
 */
package modelo;

/**
 * @author marely
 *
 */
public class Cliente {
private String runCliente;
private String nombreCliente;
private String apellidoCliente;
private Integer aniosCliente;
private CategoriaEnum nombreCategoria;
public Cliente(String runCliente, String nombreCliente, String apellidoCliente, Integer aniosCliente,
		CategoriaEnum nombreCategoria) {
	super();
	this.runCliente = runCliente;
	this.nombreCliente = nombreCliente;
	this.apellidoCliente = apellidoCliente;
	this.aniosCliente = aniosCliente;
	this.nombreCategoria = nombreCategoria;

}
public Cliente() {
	// constructor vacio
}
public String getRunCliente() {
	return runCliente;
}
public void setRunCliente(String runCliente) {
	this.runCliente = runCliente;
}
public String getNombreCliente() {
	return nombreCliente;
}
public void setNombreCliente(String nombreCliente) {
	this.nombreCliente = nombreCliente;
}
public String getApellidoCliente() {
	return apellidoCliente;
}
public void setApellidoCliente(String apellidoCliente) {
	this.apellidoCliente = apellidoCliente;
}
public Integer getAniosCliente() {
	return aniosCliente;
}
public void setAniosCliente(Integer aniosCliente) {
	this.aniosCliente = aniosCliente;
}
public CategoriaEnum getNombreCategoria(CategoriaEnum[] categoriaEnums) {
	return nombreCategoria;
}
public void setNombreCategoria(CategoriaEnum nombreCategoria) {
	this.nombreCategoria = nombreCategoria;
}

@Override
public String toString() {
	return "Cliente [runCliente=" + runCliente + ", nombreCliente=" + nombreCliente + ", apellidoCliente="
			+ apellidoCliente + ", aniosCliente=" + aniosCliente + ", nombreCategoria=" + nombreCategoria
			+ "]";
}








}
