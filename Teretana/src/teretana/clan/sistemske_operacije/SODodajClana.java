package teretana.clan.sistemske_operacije;

import java.util.List;

import teretana.clan.Clan;

public class SODodajClana {
	
	public static void izvrsi(Clan c, List<Clan> clanovi) throws Exception {
		if (c == null) {
			throw new Exception("Greska. Nije prosledjen clan.");
		}

		clanovi.add(c);
	}

}
