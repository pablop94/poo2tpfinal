package trabajoFinal;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class InmuebleTest {
	Inmueble inmueble;
	Usuario usuario;
	ArrayList<String> servicios;
	@Before
	public void setUp() throws Exception {
		servicios = new ArrayList<String>();
		servicios.add("Pileta");
		servicios.add("8 baños");
		inmueble = new Inmueble(usuario, "/home", servicios, "Carpa", "Dinamarca", "Tristan Suarez", new Double(5), "Foto fea", new Integer(74));
	}

	@Test
	public void test_constructorInmueble() {
		assertEquals(inmueble.getPropietario(), usuario);
		assertEquals(inmueble.getDireccion(), "/home");
		assertEquals(inmueble.getServicios(), servicios);
		assertEquals(inmueble.getTipoDeInmueble(), "Carpa");
		assertEquals(inmueble.getPais(), "Dinamarca");
		assertEquals(inmueble.getCiudad(), "Tristan Suarez");
		assertEquals(inmueble.getSuperficie(), new Double(5));
		assertEquals(inmueble.getFotos(), "Foto fea");
		assertEquals(inmueble.getCapacidad(), new Integer(74));
		
	}

}
