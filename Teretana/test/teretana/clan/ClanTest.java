package teretana.clan;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ClanTest {

	Clan c;

	@Before
	public void setUp() throws Exception {
		c = new Clan();
	}

	@After
	public void tearDown() throws Exception {
		c = null;
	}

	@Test
	public void testSetBrojClanskeKarte() {
		c.setBrojClanskeKarte("123");
		assertEquals("123", c.getBrojClanskeKarte());
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetBrojClanskeKarteNull() {
		c.setBrojClanskeKarte(null);
	}

	@Test
	public void testSetIme() {
		c.setIme("Pera");
		assertEquals("Pera", c.getIme());
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetImeNull() {
		c.setIme(null);
	}

	@Test
	public void testSetPrezime() {
		c.setPrezime("Peric");
		assertEquals("Peric", c.getPrezime());
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetPrezimeNull() {
		c.setPrezime(null);
	}

	@Test
	public void testSetBrojTelefona() {
		c.setBrojTelefona("0611111111");
		assertEquals("0611111111", c.getBrojTelefona());
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetBrojTelefonaNull() {
		c.setBrojTelefona(null);
	}

	@Test
	public void testSetAdresa() {
		c.setAdresa("Adresa 1");
		assertEquals("Adresa 1", c.getAdresa());
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetAdresaNull() {
		c.setAdresa(null);
	}

	@Test
	public void testSetGodiste() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetPol() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetTezina() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetVisina() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetSifra() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetPlacenaClanarina() {
		fail("Not yet implemented");
	}

}
