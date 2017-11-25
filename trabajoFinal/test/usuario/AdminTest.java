package usuario;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AdminTest {

	private Admin admin;

	@Before
	public void setUp() throws Exception {
		admin = new Admin("nombre", "mail@mail.com", "42222424");
	}

	@Test
	public void test_constructor() {
		assertEquals(admin.obtenerNombre(), "nombre");
		assertEquals(admin.obtenerMail(), "mail@mail.com");
		assertEquals(admin.obtenerTelefono(), "42222424");
	}

}
