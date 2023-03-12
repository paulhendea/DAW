package Act6;

public class Reloj {
	//ATRIBUTOS
	private int horas;
	private int minutos;
	private int segundos;
	private static String separador = ":";
	
	//CONSTRUCTORES
	public Reloj() {
		horas = 0;
		minutos = 0;
		segundos = 0;
	}
	public Reloj(int h, int m, int s) {
		if(validarHoras(h) && validarMinSeg(m) && validarMinSeg(s)) {
			horas = h;
			minutos = m;
			segundos = s;
		}
		else {
			System.err.println("ERROR: Hora incorrecta");
		}
	}
	
	//GETTERS Y SETTERS
	public int getH() {
		return horas;
	}
	public int getM() {
		return minutos;
	}
	public int getS() {
		return segundos;
	}
	
	public boolean setH(int h) {
		if(validarHoras(h)) {
			horas = h;
			return true;
		}
		else {
			return false;
		}
	}
	public boolean setM(int m) {
		if(validarMinSeg(m)) {
			minutos = m;
			return true;
		}
		else {
			return false;
		}
	}
	public boolean setS(int s) {
		if(validarMinSeg(s)) {
			segundos = s;
			return true;
		}
		else {
			return false;
		}
	}
	
	//METODOS PRIVADOS
	private boolean validarHoras(int h) {
		if((h < 0) || (h > 23)) {
			return false;
		}
		else {
			return true;
		}
	}
	private boolean validarMinSeg(int n) {
		if((n < 0) || (n > 59)) {
			return false;
		}
		else {
			return true;
		}
	}
	
	//METODOS
	public void print24() {
		System.out.printf("24H: %02d%s%02d%s%02d%n", 
				horas, separador, minutos, separador, segundos);
	}
	public void print12() {
		if(horas == 0) {
			System.out.printf("12H: %02d%s%02d%s%02d AM%n", 
					horas+12, separador, minutos, separador, segundos);
		}
		else if(horas < 12) {
			System.out.printf("12H: %02d%s%02d%s%02d AM%n", 
					horas, separador, minutos, separador, segundos);
		}
		else if(horas == 12) {
			System.out.printf("12H: %02d%s%02d%s%02d PM%n", 
					horas, separador, minutos, separador, segundos);
		}
		else {
			System.out.printf("12H: %02d%s%02d%s%02d PM%n", 
					horas-12, separador, minutos, separador, segundos);
		}
	}
	public boolean setHora(int h, int m) {
		if(validarHoras(h) && validarMinSeg(m)) {
			horas = h;
			minutos = m;
			
			return true;
		}
		else {
			return false;
		}
	}
	public boolean setHora(int h, int m, int s) {
		if(validarHoras(h) && validarMinSeg(m) && validarMinSeg(s)) {
			horas = h;
			minutos = m;
			segundos = s;
			
			return true;
		}
		else {
			return false;
		}
	}
}
