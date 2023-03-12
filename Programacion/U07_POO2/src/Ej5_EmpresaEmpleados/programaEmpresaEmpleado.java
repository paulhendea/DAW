package Ej5_EmpresaEmpleados;

public class programaEmpresaEmpleado {

	public static void main(String[] args) {
		Empresa lays = new Empresa("Lays", "12345678A");
		Empresa mercadona = new Empresa("Mercadona", "12345678B", "+34 123 456 789", "C/ lays original");
		
		mercadona.añadirEmpelado(new Empleado("Ramón Macaco", "60897846X", 999, "2018-01-01", "688 23 69 73", "C/ macaco n.4"));
		lays.añadirEmpelado(new Empleado("Vicent Cric", "36908902C", 1499, "1994-03-03", "600 14 51 02", "C/ papas fritas n.15"));
		lays.añadirEmpelado(new Empleado("George De Lacalle", "74743310A", 599.99));
		mercadona.añadirEmpelado(new Empleado("No se", "12398412", 999));
		mercadona.eliminarEmpleado(1);
		
		System.out.println("Mercadona \n-------");
		mercadona.mostrarEmpleados();
		mercadona.mostrarSueldos();
		System.out.printf("Total sueldos brutos: %.2f€%n%n", mercadona.calcularTotalSueldosBrutos());
		System.out.printf("Total sueldos netos: %.2f€%n%n", mercadona.calcularTotalSueldosNetos());
		
		System.out.println("Lays \n-------");
		lays.mostrarEmpleados();
		lays.mostrarSueldos();
		System.out.printf("Total sueldos brutos: %.2f€%n%n", lays.calcularTotalSueldosBrutos());
		System.out.printf("Total sueldos netos: %.2f€%n%n", lays.calcularTotalSueldosNetos());
	}
}
