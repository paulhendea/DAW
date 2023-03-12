package Act5;

public class programaClienteEmpleado {

	public static void main(String[] args) {
		Persona cliente = new Persona("12345678A", "Paul Hendea");
		cliente.setEsCliente(true);
		cliente.setHorasTrabajadas(40);
		cliente.setSaldo(999.99);
		
		System.out.println(cliente);
	}

}
