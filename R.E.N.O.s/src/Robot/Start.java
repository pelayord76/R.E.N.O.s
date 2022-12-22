package Robot;

public class Start {

	public static void main(String[] args) throws InterruptedException {

		Robot a = new Robot("Atom");
		Robot b = new Robot("Zeus");

		System.out.println(a);
		System.out.println(b);
		
		a.lucha(b);
	}

}
