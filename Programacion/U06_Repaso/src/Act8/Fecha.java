package Act8;

public class Fecha {
	//ATRIBUTOS
	private int año = 0; //SI ES NEGATIVO SERÁ ANTES DE CRISTO
	private int mes = 0;
	private int dia = 0;
	private static String separador = "/";
	
	//CONSTRUCTOR
	public Fecha(int año, int mes, int dia) {
		if(validarFecha(año, mes, dia)) {
			this.año = año;
			this.mes = mes;
			this.dia = dia;
		}
	}
	
	//GETTERS Y SETTERS
	public int getAño() {
		return año;
	}
	public int getMes() {
		return mes;
	}
	public int getDia() {
		return dia;
	}
	
	public void setAño(int año) {
		this.año = año;
	}
	public void setMes(int mes) {
		if(validarFecha(this.año, mes, this.dia)) {
			this.mes = mes;
		}
	}
	public void setDia(int dia) {
		if(validarFecha(this.año, this.mes, dia)) {
			this.dia = dia;
		}
	}
	
	//METODOS ESTATICOS
	public static boolean validarFecha(int año, int mes, int dia) {
		//COMPROBAMOS EL MES Y QUE EL DIA NO SEA INFERIOR A 1
		if((mes < 1) || (mes > 12) || (dia < 1)) {
			return false;
		}
		else {
			if(mes != 2) {
				//COMPROBAMOS LOS MESES PARES
				if(mes % 2 == 0) {
					if(dia > 30) {
						return false;
					}
					else {
						return true;
					}
				}
				//LOS MESES IMPARES
				else {
					if(dia > 31) {
						return false;
					}
					else {
						return true;
					}
				}
			}
			//COMPROBAMOS FEBRERO
			else {
				//LOS AñOS QUE SON BISIESTOS
				if(año % 4 == 0) {
					if(dia > 29) {
						return false;
					}
					else {
						return true;
					}
				}
				//LOS AÑOS QUE NO LO SON
				else {
					if(dia > 28) {
						return false;
					}
					else {
						return true;
					}
				}
			}
		}
	}
	
	//METODOS
	public String toString() {
		return dia + separador + mes + separador + año;
	}
	public void diaSiguiente() {
		if(validarFecha(año, mes, dia +1)) {
			dia++;
		}
		else {
			if(validarFecha(año, mes +1, 1)) {
				dia = 1;
				mes++;
			}
			else {
				dia = 1;
				mes = 1;
				año++;
			}
		}
	}
}
