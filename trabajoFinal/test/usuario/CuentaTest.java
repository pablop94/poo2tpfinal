package usuario;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

public class CuentaTest {

	private Cuenta cuenta;

	@Before
	public void setUp() throws Exception {
		cuenta = new Usuario("pepe", "mail", "42277777", mock(Rol.class));
	}

	@Test
	public void test_constructor() {
		assertEquals(cuenta.obtenerNombre(), "pepe");
		assertEquals(cuenta.obtenerMail(), "mail");
		assertEquals(cuenta.obtenerTelefono(), "42277777");
	}

}
