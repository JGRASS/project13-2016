package teretana.clan.sistemske_operacije;

import java.util.List;

import teretana.clan.Clan;

public class SOIzbrisiClana {
	
	public static void izvrsi(String id, List<Clan> clanovi) throws Exception {
		if (id == null) {
			throw new Exception("Izabrana osoba nije clan teretane.");
		}

		for (int i = 0; i < clanovi.size(); i++) {
			if (clanovi.get(i).getBrojClanskeKarte().equals(id)) {
				SOIzbrisiClanaIzListe.izvrsi(clanovi.get(i), clanovi);
			}
		}
	}

}
