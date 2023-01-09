package Robot;

import java.util.concurrent.TimeUnit;

public class Robot {

	private String nombre;
	protected int puntosDeVida;
	protected int puntosDeAtaque;
	protected int puntosDeDefensa;

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
	public Robot lucha(Robot otro) throws InterruptedException {

		// variable para determinar quien empieza pegando, con 0 ataca "this", con 1
		// ataca "otro".
		int turno = (int) (Math.random() * 2);

		// el bucle se repetira hasta que uno de los dos robots se quede sin vida.
		while (this.puntosDeVida > 0 && otro.puntosDeVida > 0) {

			int numeroA = (int) (Math.random() * 101);

			if (turno == 0) {
				// si el numero aleatorio supera la defensa rival comienza el proceso de ataque.
				if (numeroA > otro.puntosDeDefensa && otro.puntosDeVida > 0 && this.puntosDeVida > 0) {

					TimeUnit.SECONDS.sleep(2);

					// en caso de que los puntos de ataque sean mayores a la vida restante, se le
					// restará solo la vida que le queda al robot.
					if (otro.puntosDeVida < this.puntosDeAtaque) {

						this.puntosDeAtaque = otro.puntosDeVida;
					}

					otro.puntosDeVida -= this.puntosDeAtaque;

					TimeUnit.SECONDS.sleep(2);

				}

				turno = 1;
			}
			// en caso de que el numero no supere la defensa, no atacará y aparte se sacara
			// un mensaje por pantalla que avise del fallo.
			if (numeroA <= otro.puntosDeDefensa && otro.puntosDeVida > 0 && this.puntosDeVida > 0) {

				TimeUnit.SECONDS.sleep(2);

			}

			// se hace lo mismo con el caso del otro robot.
			int numeroB = (int) (Math.random() * 101);

			if (turno == 1) {

				if (numeroB > this.puntosDeDefensa && this.puntosDeVida > 0 && otro.puntosDeVida > 0) {

					TimeUnit.SECONDS.sleep(2);

					if (this.puntosDeVida < otro.puntosDeAtaque) {

						otro.puntosDeAtaque = this.puntosDeVida;
					}

					this.puntosDeVida -= otro.puntosDeAtaque;

					TimeUnit.SECONDS.sleep(2);

				}
				turno = 0;
			}

			if (numeroB <= this.puntosDeDefensa && this.puntosDeVida > 0 && otro.puntosDeVida > 0) {

				TimeUnit.SECONDS.sleep(2);

			}
		}

		// cuando la vida de uno de los dos se ponga a 0, saldrá un mensaje por pantalla
		// que anuncie al ganador.
		if (this.puntosDeVida <= 0) {

			TimeUnit.SECONDS.sleep(2);

			return otro;
		}

		else {

			TimeUnit.SECONDS.sleep(2);

			return this;

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