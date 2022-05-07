package dao;

import java.util.ArrayList;
import java.util.List;

import data.Commercant;

public class ComRepo {
	public static List<Commercant> coms = new ArrayList<Commercant>();
	public static void save(Commercant c) {
		ComRepo.coms.add(c);
	}
}
