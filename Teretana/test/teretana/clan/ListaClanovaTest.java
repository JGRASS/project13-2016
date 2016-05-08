package teretana.clan;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ListaClanovaTest {

	ListaClanova lc;
	List<Clan> clanovi;

	@Before
	public void setUp() throws Exception {
		lc = new ListaClanova();

		clanovi = new LinkedList<>();
		Clan c1 = new Clan();
		Clan c2 = new Clan();

		c1.setAdresa("Adresa 1");
		c1.setBrojClanskeKarte("123");
		c1.setBrojTelefona("064123123");
		c1.setGodiste(1965);
		c1.setIme("Pera");
		c1.setPrezime("Djokic");
		c1.setPlacenaClanarina("jul 2016");
		c1.setPol('M');
		c1.setSifra("pera");
		c1.setTezina(80);
		c1.setVisina(180);

		c2.setAdresa("Adresa 2");
		c2.setBrojClanskeKarte("124");
		c2.setBrojTelefona("064123124");
		c2.setGodiste(1969);
		c2.setIme("Jovana");
		c2.setPrezime("Milanovic");
		c2.setPlacenaClanarina("jun 2016");
		c2.setPol('Z');
		c2.setSifra("jovana");
		c2.setTezina(65);
		c2.setVisina(165);

		clanovi.add(c1);
		clanovi.add(c2);

		lc.dodajClanove((LinkedList<Clan>) clanovi);
	}

	@After
	public void tearDown() throws Exception {
		lc = null;
	}

	@Test
	public void testDodajClana() {
		Clan c3 = new Clan();
		c3.setAdresa("Adresa 3");
		c3.setBrojClanskeKarte("124");
		c3.setBrojTelefona("064123124");
		c3.setGodiste(1969);
		c3.setIme("Tijana");
		c3.setPrezime("Tijanic");
		c3.setPlacenaClanarina("avgust 2016");
		c3.setPol('Z');
		c3.setSifra("tijana");
		c3.setTezina(65);
		c3.setVisina(169);
		try {
			lc.dodajClana(c3);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(c3, lc.getListaClanova().get(2));
	}

	@Test(expected = java.lang.Exception.class)
	public void testDodajClanaNull() throws Exception {
		try {
			lc.dodajClana(null);
		} catch (Exception e) {
			throw new Exception();
		}
	}

	@Test
	public void testIzbrisiClana() {
		try {
			lc.izbrisiClana("123");
			clanovi.remove(0);
			assertEquals(lc.getListaClanova(), clanovi);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(expected = java.lang.Exception.class)
	public void testIzbrisiClanaNePostoji() throws Exception {
		try {
			lc.izbrisiClana(null);
		} catch (Exception e) {
			throw new Exception();
		}
	}

	@Test
	public void testIzmeniClana() {
		Clan c1 = new Clan();
		try {
			lc.izmeniClana(lc.getListaClanova().get(0), "123123123", "A 1", 100.00, 190, "asd", "Jul 2016");
			c1.setAdresa("A 1");
			c1.setBrojClanskeKarte("123");
			c1.setBrojTelefona("123123123");
			c1.setGodiste(1965);
			c1.setIme("Pera");
			c1.setPrezime("Djokic");
			c1.setPlacenaClanarina("Jul 2016");
			c1.setPol('M');
			c1.setSifra("asd");
			c1.setTezina(100.00);
			c1.setVisina(190);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(lc.getListaClanova().get(0), c1);
	}

	@Test
	public void testIzmeniClanaPoIndeksu() {
		Clan c1 = new Clan();
		try {
			lc.izmeniClanaPoIndeksu(0, "123123123", "A 1", 100.00, 190, "asd", "Jul 2016");
			c1.setAdresa("A 1");
			c1.setBrojClanskeKarte("123");
			c1.setBrojTelefona("123123123");
			c1.setGodiste(1965);
			c1.setIme("Pera");
			c1.setPrezime("Djokic");
			c1.setPlacenaClanarina("Jul 2016");
			c1.setPol('M');
			c1.setSifra("asd");
			c1.setTezina(100.00);
			c1.setVisina(190);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(lc.getListaClanova().get(0), c1);
	}

	@Test
	public void testDodajClanove() {
		assertEquals(lc.getListaClanova(), clanovi);
	}

}
