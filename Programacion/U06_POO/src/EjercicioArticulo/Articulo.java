package EjercicioArticulo;

public class Articulo {
	//ATRIBUTOS
	private String nombre;
	private float precio; //SIN IVA
	private int cuantosQuedan;
	private int tipoIva; //ENTRE 0 Y 2
	private static final int IVA[] = {21, 10, 4};
	
	//CONSTRUCTOR
	public Articulo(String nombre, float precio, int tipoIva, int cuantosQuedan) {
		if ((precio < 0.0) || (tipoIva < 0) || (tipoIva > 2) || (cuantosQuedan < 0)) {
			System.err.println("ERROR: valores incorrectos");
		}
		else {
			this.nombre = nombre;
			this.precio = precio;
			this.tipoIva = tipoIva;
			this.cuantosQuedan = cuantosQuedan;
		}
	}
	
	//GETTERS Y SETTERS
	public String getNombre() {
		return nombre;
	}
	public float getPrecio() {
		return precio;
	}
	public int getIva() {
		return tipoIva;
	}
	public int getCuantosQuedan() {
		return cuantosQuedan;
	}
	public void setNombre(String n) {
		nombre = n;
	}
	public void setPrecio(float p) {
		if(p < 0.0) {
			System.err.println("ERROR: valores incorrectos");
		}
		else {
			precio = p;
		}
	}
	public void setIva(int i) {
		if ((i < 0) || (i > 2)) {
			System.err.println("ERROR: valores incorrectos");
		}
		else {
			tipoIva = i;
		}
	}
	public void setCuantosQuedan(int cq) {
		if (cq < 0) {
			System.err.println("ERROR: valores incorrectos");
		}
		else {
			cuantosQuedan = cq;
		}
	}
	
	//METODOS
	public void imprimir() {
		System.out.printf("%s - Precio: %.2f€ - IVA: %d%% - Disponibles: %d%n", 
				nombre, precio, IVA[tipoIva], cuantosQuedan);
	}
	public float getPVP() {
		return ( precio * (1f + IVA[tipoIva] / 100) );
	}
	public float getPVPDescuento(float descuento) {
		return ( getPVP() * (1f - descuento / 100) );
	}
	public boolean vender(int n) {
		if (n < cuantosQuedan) {
			cuantosQuedan -= n;
			return true;
		}
		else {
			return false;
		}
	}
	public boolean almacenar(int n) {
		if (n > 0) {
			cuantosQuedan += n;
			return true;
		}
		else {
			return false;
		}
	}
}
