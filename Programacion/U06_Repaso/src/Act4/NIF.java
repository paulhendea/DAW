package Act4;

public class NIF {
	//ATRIBUTOS
	private long DNI;
	private char letter;
	
	//STATIC
	char l[] = new char[]{'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
	
	//CONSTRUCTOR
	public NIF(long dni) {
		if(validaDNI(dni)) {
			DNI = dni;
			letter = calculaLetra(dni);
		}
		else {
			System.err.println("ERROR: DNI no valido");
		}
	}
		
	//METODOS PRIVADOS
	private char calculaLetra(long dni) {
		return l[(int) (dni % 23)];
	}
	private boolean validaDNI(long dni) {
		if ((dni < 10000000) || (dni > 99999999)) {
			return false;
		}
		else {
			return true;
		}
	}
	
	//METODOS
	public String getNIF() {
		String NIF;
		long dni = DNI;
		NIF = Long.toString(dni);
		NIF += letter;
		return NIF;
	}
}
