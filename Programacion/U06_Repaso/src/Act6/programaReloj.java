package Act6;

import java.util.ArrayList;

public class programaReloj {

	public static void main(String[] args) {
		ArrayList<Reloj> relojes = new ArrayList<Reloj>();
		relojes.add(new Reloj(12,8,5));
		relojes.add(new Reloj());
		relojes.add(new Reloj(5,45,1));
		relojes.add(new Reloj(22,34,59));
		
		for(int i = 0; i < relojes.size(); i++) {
			Reloj r = (Reloj) relojes.get(i);
			System.out.printf("Reloj %d%n--------%n", i+1);
			r.print12();
			r.print24();
			System.out.println();
		}
	}
}
