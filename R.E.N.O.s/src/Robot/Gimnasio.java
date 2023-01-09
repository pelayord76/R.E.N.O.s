package Robot;

import java.util.concurrent.TimeUnit;

public class Gimnasio {

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
	public static Robot lucha(Robot robot0, Robot robot1) throws InterruptedException {

		// variable para determinar quien empieza pegando, con 0 ataca "this", con 1
		// ataca "otro".
		int turno = (int) (Math.random() * 2);

		// el bucle se repetira hasta que uno de los dos robots se quede sin vida.
		while (robot0.puntosDeVida > 0 && robot1.puntosDeVida > 0) {

			int numeroA = (int) (Math.random() * 101);

			if (turno == 0) {
				// si el numero aleatorio supera la defensa rival comienza el proceso de ataque.
				if (numeroA > robot1.puntosDeDefensa && robot1.puntosDeVida > 0 && robot0.puntosDeVida > 0) {

					TimeUnit.SECONDS.sleep(2);

					// en caso de que los puntos de ataque sean mayores a la vida restante, se le
					// restará solo la vida que le queda al robot.
					if (robot1.puntosDeVida < robot0.puntosDeAtaque) {

						robot0.puntosDeAtaque = robot1.puntosDeVida;
					}

					robot1.puntosDeVida -= robot0.puntosDeAtaque;

					TimeUnit.SECONDS.sleep(2);

				}

				turno = 1;
			}
			// en caso de que el numero no supere la defensa, no atacará y aparte se sacara
			// un mensaje por pantalla que avise del fallo.
			if (numeroA <= robot1.puntosDeDefensa && robot1.puntosDeVida > 0 && robot0.puntosDeVida > 0) {

				TimeUnit.SECONDS.sleep(2);

			}

			// se hace lo mismo con el caso del otro robot.
			int numeroB = (int) (Math.random() * 101);

			if (turno == 1) {

				if (numeroB > robot0.puntosDeDefensa && robot0.puntosDeVida > 0 && robot1.puntosDeVida > 0) {

					TimeUnit.SECONDS.sleep(2);

					if (robot0.puntosDeVida < robot1.puntosDeAtaque) {

						robot1.puntosDeAtaque = robot0.puntosDeVida;
					}

					robot0.puntosDeVida -= robot1.puntosDeAtaque;

					TimeUnit.SECONDS.sleep(2);

				}
				turno = 0;
			}

			if (numeroB <= robot0.puntosDeDefensa && robot0.puntosDeVida > 0 && robot1.puntosDeVida > 0) {

				TimeUnit.SECONDS.sleep(2);

			}
		}

		// cuando la vida de uno de los dos se ponga a 0, saldrá un mensaje por pantalla
		// que anuncie al ganador.
		if (robot0.puntosDeVida <= 0) {

			TimeUnit.SECONDS.sleep(2);

			return robot1;
		}

		else {

			TimeUnit.SECONDS.sleep(2);

			return robot0;

		}
	}

}
