package Act3;

public class Pelicula extends Multimedia {
	//ATRIBUTOS
	private String actorPrincipal;
	private String actrizPrincipal;
	
	//CONSTRUCTOR
	public Pelicula(String titulo, String autor, String formato, double duracion, 
			String actorPrincipal, String actrizPrincipal) {
		super(titulo, autor, formato, duracion);
		if(checkActores(actorPrincipal, actrizPrincipal)) {
			this.actorPrincipal = actorPrincipal;
			this.actrizPrincipal = actrizPrincipal;
		}
	}
	
	//GETTERS Y SETTERS
	public String getActor() {
		return actorPrincipal;
	}
	public String getActriz() {
		return actrizPrincipal;
	}
	
	public void setActor(String actorPrincipal) {
		if(checkActores(actorPrincipal, actrizPrincipal)) {
			this.actorPrincipal = actorPrincipal;
		}
	}
	public void setActriz(String actrizPrincipal) {
		if(checkActores(actorPrincipal, actrizPrincipal)) {
			this.actrizPrincipal = actrizPrincipal;
		}
	}
	
	//METODOS PRIVADOS
	public static boolean checkActores(String actorPrincipal, String actrizPrincipal) {
		if((actorPrincipal == null) && (actrizPrincipal == null)) {
			return false;
		}
		else {
			return true;
		}
	}
	
	//METODOS
	public String toString() {
		if(actorPrincipal == null) {
			return String.format("Título : %s%n", super.getTitulo())
					+ String.format("Autor: %s%n", super.getAutor())
					+ String.format("Formato: %s%n", super.getFormato())
					+ String.format("Duración: %.2f%n", super.getDuracion())
					+ String.format("Actriz principal: %s%n", actrizPrincipal);
		}
		else if(actrizPrincipal == null) {
			return String.format("Título : %s%n", super.getTitulo())
					+ String.format("Autor: %s%n", super.getAutor())
					+ String.format("Formato: %s%n", super.getFormato())
					+ String.format("Duración: %.2f%n", super.getDuracion())
					+ String.format("Actor principal: %s%n", actorPrincipal);
		}
		else {
			return String.format("Título : %s%n", super.getTitulo())
					+ String.format("Autor: %s%n", super.getAutor())
					+ String.format("Formato: %s%n", super.getFormato())
					+ String.format("Duración: %.2f%n", super.getDuracion())
					+ String.format("Actor principal: %s%n", actorPrincipal)
					+ String.format("Actriz principal: %s%n", actrizPrincipal);
		}
				
	}
}
