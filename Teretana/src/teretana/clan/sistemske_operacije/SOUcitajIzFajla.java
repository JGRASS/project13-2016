package teretana.clan.sistemske_operacije;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.LinkedList;
import java.util.List;

import teretana.clan.Clan;

public class SOUcitajIzFajla {

	public static LinkedList<Clan> izvrsi(String putanja, List<Clan> clanovi) throws Exception {
		try {
			ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(putanja)));

			final LinkedList<Clan> clanoviIzFajla = (LinkedList<Clan>) in.readObject();

			in.close();

			return clanoviIzFajla;
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

}
