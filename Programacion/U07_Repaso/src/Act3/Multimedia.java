package Act3;

public class Multimedia {
	//ATRIBUTOS
	private String titulo;
	private String autor;
	private String formato;
	private double duracion; //EN MINUTOS
	
	private static String formatos[] = new String [] 
			{"wav", "mp3", "midi", "avi", "mov", "mpg", "cdAudio", "DVD"};
	
	//CONSTRUCTOR
	public Multimedia(String titulo, String autor, String formato, double duracion) {
		if(checkFormatos(formato)) {
			this.titulo = titulo;
			this.autor = autor;
			this.formato = formato;
			this.duracion = duracion;
		}
	}
	
	//GETTERS Y SETTERS
	public String getTitulo() {
		return titulo;
	}
	public String getAutor() {
		return autor;
	}
	public String getFormato() {
		return formato;
	}
	public double getDuracion() {
		return duracion;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public void setFormato(String formato) {
		this.formato = formato;
	}
	public void setDuracion(double duracion) {
		this.duracion = duracion;
	}
	
	//METODOS PRIVADOS
	public static boolean checkFormatos(String formato) {
		boolean sw = false;
		for(int i = 0; i < formatos.length; i++) {
			if(formatos[i].equals(formato)) {
				sw = true;
			}
		}
		return sw;
	}
	
	//METODOS
	public boolean equals(Multimedia objeto) {
		if((titulo == objeto.getTitulo()) && (autor == objeto.getAutor())) {
			return true;
		}
		else {
			return false;
		}
	}
}
