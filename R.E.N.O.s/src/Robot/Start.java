package Robot;

// import java.util.concurrent.TimeUnit;

public class Start {

	public static void main(String[] args) throws InterruptedException {

		/*
		
		// FORMA DE HACER QUE EL PROGRAMA "DUERMA" EN MEDIO DE LA EJECUCION: (descomentar java.utils para usar)
		
		// bucle infinito:
		while (true) {
			
			// orden para que pare, unidad (que elijo segundos) y la cantidad de segundos entre accion y accion:
			TimeUnit.SECONDS.sleep(1);
			
			// accion a ejecutar:
			System.out.println("Hola");
		}
		
		*/
		
		Robot a = new Robot();
		a.setNombre("Atom");
		a.setPuntosDeVida(200);
		a.setPuntosDeAtaque(-30);
		a.setPuntosDeDefensa(65);
		
		Robot b = new Robot();
		b.setNombre("Zeus");
		b.setPuntosDeVida(300);
		b.setPuntosDeAtaque(15);
		b.setPuntosDeDefensa(80);
		
		System.out.println(a);
		System.out.println(b);

	}

}