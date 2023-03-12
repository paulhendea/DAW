package Act3;

public class asignatura {
	//ATRIBUTOS
	private int codigo;
	private String nombre;
	private int curso;
	
	//CONSTRUCTOR
	public asignatura(int codigo, String nombre, int curso) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.curso = curso;
	}
	
	//GETTERS
	public int getCodigo() {
		return codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public int getCurso() {
		return curso;
	}
	
	//METODOS
	public void mostrarInfo() {
		System.out.printf("Código: %d%n", codigo);
		System.out.printf("Nombre: %s%n", nombre);
		System.out.printf("Curso: %d%n", curso);
		System.out.println();
	}
}
