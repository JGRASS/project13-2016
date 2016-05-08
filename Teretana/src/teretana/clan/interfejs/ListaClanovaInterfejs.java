package teretana.clan.interfejs;

import java.util.LinkedList;

import teretana.clan.Clan;

/**
 * Interfejs koji definise koja ponasanja su dozvoljena u klasi ListaClanova
 * 
 * @author Filip Furtula, Edis Sarda, Marko Stanimirovic
 *
 */
public interface ListaClanovaInterfejs {

	/**
	 * Dodaje clana u listu clanova
	 * 
	 * @param c
	 *            Clan
	 * @throws Exception
	 *             ako je clan null
	 */
	public void dodajClana(Clan c) throws Exception;

	/**
	 * Brise clana iz liste clanova
	 * 
	 * @param id
	 *            broj clanske karte
	 * @throws Exception
	 *             ako se clan ne nalazi u listi clanova
	 */
	public void izbrisiClana(String id) throws Exception;

	/**
	 * Menja podatke clana
	 * 
	 * @param c
	 *            Clan
	 * @param brojTelefona
	 *            broj telefona clana
	 * @param adresa
	 *            adresa clana
	 * @param tezina
	 *            tezina clana
	 * @param visina
	 *            visina clana
	 * @param sifra
	 *            sifra clana
	 * @throws Exception
	 *             ako je clan null
	 */
	public void izmeniClana(Clan c, String brojTelefona, String adresa, double tezina, double visina, String sifra)
			throws Exception;

	/**
	 * Menja podatke clana
	 * 
	 * @param index
	 *            redni broj clana u listi
	 * @param brojTelefona
	 *            broj telefona clana
	 * @param adresa
	 *            adresa clana
	 * @param tezina
	 *            tezina clana
	 * @param visina
	 *            visina clana
	 * @param sifra
	 *            sifra clana
	 * @param clanarinaPlacenaDo
	 *            do kog datuma je placena clanarina
	 * @throws Exception
	 *             ako je clan null
	 */
	public void izmeniClana(int index, String brojTelefona, String adresa, double tezina, double visina, String sifra,
			String clanarinaPlacenaDo) throws Exception;

	/**
	 * 
	 * @param index
	 *            redni broj clana u listi
	 * @return clana koji se nalazi na zadatoj poziciju u listi
	 */
	public Clan getClan(int index);

	/**
	 * Popunjava listu clanova
	 * 
	 * @param clanovi
	 *            lista clanova
	 */
	public void dodajClanove(LinkedList<Clan> clanovi);

	/**
	 * 
	 * @return broj clanova liste
	 */
	public int size();

	/**
	 * Metoda ucitava clanove iz zadatog fajla
	 * 
	 * @param putanja
	 *            - putanja do fajla
	 */
	public void ucitajIzFajla(String putanja) throws Exception;

	/**
	 * Metoda upisuje clanove u zadati fajl
	 * 
	 * @param putanja
	 *            - putanja do fajla
	 */
	public void sacuvajUFajl(String putanja) throws Exception;

}
