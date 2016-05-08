package teretana.clan;

import static org.junit.Assert.*;

import java.util.GregorianCalendar;

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
		c.setGodiste(2001);
		assertEquals(2001, c.getGodiste());
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetGodisteManje20Vek() {
		c.setGodiste(1892);
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetGodisteVeceOdTekuceGodine() {
		c.setGodiste(new GregorianCalendar().get(GregorianCalendar.YEAR) + 1);
	}

	@Test
	public void testSetPol() {
		c.setPol('Z');
		assertEquals('Z', c.getPol());
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetPolNeispravan() {
		c.setPol('T');
	}

	@Test
	public void testSetTezina() {
		c.setTezina(80.99);
		assertEquals(80.99, c.getTezina(), 0.0001);
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetTezinaManjeOdNule() {
		c.setTezina(-200);
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetTezinaVecaOdDvestapedeset() {
		c.setTezina(251.9);
	}

	@Test
	public void testSetVisina() {
		c.setVisina(190);
		assertEquals(190, c.getVisina(), 0.0001);
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetVisinaManjaOdNule() {
		c.setVisina(-10);
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetVisinaVecaOdTrista() {
		c.setVisina(320.99);
	}

	@Test
	public void testSetSifra() {
		c.setSifra("korisnik");
		assertEquals("korisnik", c.getSifra());
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetSifraNull() {
		c.setSifra(null);
	}

	@Test
	public void testSetPlacenaClanarina() {
		c.setPlacenaClanarina("Jun 2016");
		assertEquals("Jun 2016", c.getPlacenaClanarina());
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetPlacenaClanarinaNull() {
		c.setPlacenaClanarina(null);
	}

}
