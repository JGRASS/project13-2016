package teretana.clan;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import teretana.clan.interfejs.ListaClanovaInterfejs;
import teretana.clan.sistemske_operacije.SODodajClana;
import teretana.clan.sistemske_operacije.SOIzbrisiClana;
import teretana.clan.sistemske_operacije.SOIzbrisiClanaIzListe;
import teretana.clan.sistemske_operacije.SOIzmeniClana;
import teretana.clan.sistemske_operacije.SOIzmeniClanaPoIndeksu;
import teretana.clan.sistemske_operacije.SOSacuvajUFajl;
import teretana.clan.sistemske_operacije.SOUcitajIzFajla;

/**
 * Klasa predstavlja listu Clanova.
 * 
 * @author Filip Furtula, Edis Sarda, Marko Stanimirovic
 *
 */
public class ListaClanova implements ListaClanovaInterfejs {

	/**
	 * Lista clanova
	 */
	private List<Clan> clanovi;

	/**
	 * Konstruktor koji inicijalizuje listu clanova (inicijalizacija se vrsi
	 * samo jedan put)
	 */
	public ListaClanova() {
		if (clanovi == null) {

			clanovi = new LinkedList<>();
		}
	}

	/**
	 * 
	 * @return listu clanova
	 */
	public List<Clan> getListaClanova() {
		if (clanovi == null) {
			return new LinkedList<>();
		} else {
			return clanovi;
		}
	}

	@Override
	public void dodajClana(Clan c) throws Exception {
		SODodajClana.izvrsi(c, clanovi);
	}

	private void izbrisiClanaIzListe(Clan c) throws Exception {
		SOIzbrisiClanaIzListe.izvrsi(c, clanovi);
	}

	@Override
	public void izbrisiClana(String id) throws Exception {
		SOIzbrisiClana.izvrsi(id, clanovi);
	}

	@Override
	public void izmeniClana(Clan c, String brojTelefona, String adresa, double tezina, double visina, String sifra, String clanarinaPlacenaDo)
			throws Exception {
		SOIzmeniClana.izvrsi(clanovi, c, brojTelefona, adresa, tezina, visina, sifra, clanarinaPlacenaDo);
	}

	@Override
	public void izmeniClana(int index, String brojTelefona, String adresa, double tezina, double visina, String sifra,
			String clanarinaPlacenaDo) throws Exception {
		SOIzmeniClanaPoIndeksu.izvrsi(clanovi, index, brojTelefona, adresa, tezina, visina, sifra, clanarinaPlacenaDo);
	}

	@Override
	public Clan getClan(int index) {
		return clanovi.get(index);
	}

	@Override
	public void dodajClanove(LinkedList<Clan> clanovi) {
		this.clanovi = clanovi;
	}

	@Override
	public int size() {
		if (clanovi == null) {
			return 0;
		}
		return clanovi.size();
	}

	@Override
	public void ucitajIzFajla(String putanja) throws Exception {
		try {
			this.clanovi = SOUcitajIzFajla.izvrsi(putanja, clanovi);
		} catch (Exception e) {
			throw new Exception(e);
		}
		
	}

	@Override
	public void sacuvajUFajl(String putanja) throws Exception {
		try {
			SOSacuvajUFajl.izvrsi(putanja, clanovi);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

}
