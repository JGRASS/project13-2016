package teretana.clan.sistemske_operacije;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;

import teretana.clan.Clan;

public class SOSacuvajUFajl {
	
	public static void izvrsi(String putanja, List<Clan> clanovi) throws Exception {
		try {
			ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(putanja)));

			out.writeObject((LinkedList<Clan>) clanovi);

			out.close();
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

}
