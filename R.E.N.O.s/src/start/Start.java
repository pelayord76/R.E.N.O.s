package start;

import Robot.Gimnasio;
import Robot.Robot;

public class Start {

	public static void main(String[] args) throws InterruptedException {

		Robot a = new Robot("Atom");
		Robot b = new Robot("Zeus");

		System.out.println(a);
		System.out.println(b);
		
		Robot ganador = Gimnasio.lucha(a, b);
		System.out.println(ganador);
	}

}
