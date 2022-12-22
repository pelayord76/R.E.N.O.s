package Robot;

import java.util.concurrent.TimeUnit;

public class Robot {

	private String nombre;
	private int puntosDeVida;
	private int puntosDeAtaque;
	private int puntosDeDefensa;

	// constructor parametrizado:
	// el nombre será el unico atributo que se necesitara para construirlo.
	// los puntos de vida seran siempre 100.
	// los puntos de ataque y defensa se generaran automaticamente.
	public Robot(String nombre) {

		this.nombre = nombre;
		this.puntosDeVida = 100;
		// el ataque tendra un valor entre 0 y 20.
		this.puntosDeAtaque = (int) (Math.random() * 21);
		// la defensa tendra un valor entre 0 y 100.
		this.puntosDeDefensa = (int) (Math.random() * 101);
	}

	/**
	 * metodo que hace que dos robots peleen entre ellos, en cada turno sacarán un
	 * numero aleatorio entre 0 y 100, si este supera el valor defensivo del rival,
	 * conseguirá lanzar el ataque causándole tanto daño como puntos de ataque
	 * tenga.
	 * 
	 * @param otro: contrincante contra el que se pegara el primer robot.
	 * @throws InterruptedException habrá una pausa de 2 segundos entre accion y
	 *                              accion para que se pueda seguir el transcurso de
	 *                              la pelea a una velocidad razonable.
	 */
	public void lucha(Robot otro) throws InterruptedException {

		System.out.println("Va a comenzar la pelea entre " + this.nombre + " y " + otro.nombre + "!!");

		// el bucle se repetira hasta que uno de los dos robots se quede sin vida.
		while (this.puntosDeVida > 0 && otro.puntosDeVida > 0) {

			int numeroA = (int) (Math.random() * 101);

			// si el numero aleatorio supera la defensa rival comienza el proceso de ataque.
			if (numeroA > otro.puntosDeDefensa && otro.puntosDeVida > 0 && this.puntosDeVida > 0) {

				TimeUnit.SECONDS.sleep(2);

				// en caso de que los puntos de ataque sean mayores a la vida restante, se le
				// restará solo la vida que le queda al robot.
				if (otro.puntosDeVida < this.puntosDeAtaque) {

					this.puntosDeAtaque = otro.puntosDeVida;
				}

				System.out.println(this.nombre + " le ha quitado " + this.puntosDeAtaque + " puntos de vida a "
						+ otro.nombre + "!");

				otro.puntosDeVida -= this.puntosDeAtaque;

				TimeUnit.SECONDS.sleep(2);

				System.out.println("Vida restante de " + otro.nombre + ": " + otro.puntosDeVida + ".");
			}

			// en caso de que el numero no supere la defensa, no atacará y aparte se sacara
			// un mensaje por pantalla que avise del fallo.
			if (numeroA <= otro.puntosDeDefensa && otro.puntosDeVida > 0 && this.puntosDeVida > 0) {

				TimeUnit.SECONDS.sleep(2);

				System.out.println(otro.nombre + " ha evitado el ataque de " + this.nombre + "!!");

			}

			// se hace lo mismo con el caso del otro robot.
			int numeroB = (int) (Math.random() * 101);

			if (numeroB > this.puntosDeDefensa && this.puntosDeVida > 0 && otro.puntosDeVida > 0) {

				TimeUnit.SECONDS.sleep(2);

				if (this.puntosDeVida < otro.puntosDeAtaque) {

					otro.puntosDeAtaque = this.puntosDeVida;
				}

				System.out.println(otro.nombre + " le ha quitado " + otro.puntosDeAtaque + " puntos de vida a "
						+ this.nombre + "!");

				this.puntosDeVida -= otro.puntosDeAtaque;

				TimeUnit.SECONDS.sleep(2);

				System.out.println("Vida restante de " + this.nombre + ": " + this.puntosDeVida + ".");
			}

			if (numeroB <= this.puntosDeDefensa && this.puntosDeVida > 0 && otro.puntosDeVida > 0) {

				TimeUnit.SECONDS.sleep(2);

				System.out.println(this.nombre + " ha evitado el ataque de " + otro.nombre + "!!");
			}
		}

		// cuando la vida de uno de los dos se ponga a 0, saldrá un mensaje por pantalla
		// que anuncie al ganador.
		if (this.puntosDeVida <= 0) {

			TimeUnit.SECONDS.sleep(2);

			System.out.println(this.nombre + " se ha debilitado!! " + otro.nombre + " se lleva la victoria!!");
		}

		if (otro.puntosDeVida <= 0) {

			TimeUnit.SECONDS.sleep(2);

			System.out.println(otro.nombre + " se ha debilitado!! " + this.nombre + " se lleva la victoria!!");
		}
	}

	// getters y setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPuntosDeVida() {
		return puntosDeVida;
	}

	public void setPuntosDeVida(int puntosDeVida) {
		this.puntosDeVida = puntosDeVida;
	}

	public int getPuntosDeAtaque() {
		return puntosDeAtaque;
	}

	public void setPuntosDeAtaque(int puntosDeAtaque) {

		this.puntosDeAtaque = puntosDeAtaque;

		// protejo los setters de puntos de ataque y defensa para que no sobrepasen los
		// limites establecidos en el enunciado.

		if (this.puntosDeAtaque <= 0) {
			this.puntosDeAtaque = 1;
		}

		if (this.puntosDeAtaque > 20) {
			this.puntosDeAtaque = 20;
		}
	}

	public int getPuntosDeDefensa() {
		return puntosDeDefensa;
	}

	public void setPuntosDeDefensa(int puntosDeDefensa) {

		this.puntosDeDefensa = puntosDeDefensa;

		if (this.puntosDeDefensa <= 0) {
			this.puntosDeDefensa = 1;
		}

		if (this.puntosDeDefensa > 100) {
			this.puntosDeDefensa = 100;
		}
	}

	@Override
	public String toString() {
		return "Robot [Nombre=" + nombre + ", Vida=" + puntosDeVida + ", Ataque=" + puntosDeAtaque + ", Defensa="
				+ puntosDeDefensa + "]";
	}
}