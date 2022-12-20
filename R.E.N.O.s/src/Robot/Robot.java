package Robot;

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
		this.puntosDeAtaque = (int) (Math.random() * 21);
		this.puntosDeDefensa = (int) (Math.random() * 101);
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