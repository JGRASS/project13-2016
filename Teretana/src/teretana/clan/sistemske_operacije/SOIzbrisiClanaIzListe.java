package teretana.clan.sistemske_operacije;

import java.util.List;

import teretana.clan.Clan;

public class SOIzbrisiClanaIzListe {
	
	public static void izvrsi(Clan c, List<Clan> clanovi) throws Exception {
		if (clanovi.contains(c))
			clanovi.remove(c);
		else
			throw new Exception("Izabrana osoba nije clan teretane.");
	}

}
