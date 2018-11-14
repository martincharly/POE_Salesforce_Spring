package fr.cantine.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import fr.cantine.beans.Plat;

public class FakePlatDao implements DaoInterface<Plat> {
	
	private Map<Long, Plat> tousLesPlatsDisponibles;
	private static Long lastId = 0L;
	
	
	public Map<Long, Plat> getTousLesPlatsDisponibles() {
		return tousLesPlatsDisponibles;
	}
	
	
	public void setTousLesPlatsDisponibles(Map<Long, Plat> tousLesPlatsDisponibles) {
		this.tousLesPlatsDisponibles = tousLesPlatsDisponibles;
	}
	
	
	@Override
	public Plat createOrUpdate(Plat item) {
		lastId++;
		item.setId(lastId);
		
		tousLesPlatsDisponibles.put(lastId, item);
		
		return item;
	}

	
	@Override
	public Plat findById(Long id) {
		return tousLesPlatsDisponibles.get(id);
	}

	
	@Override
	public List<Plat> findAll() {
		return new ArrayList<Plat>(tousLesPlatsDisponibles.values());
	}

	
	@Override
	public void delete(Long id) {
		tousLesPlatsDisponibles.remove(id);
	}
	
	public void init() {
		lastId = (long) tousLesPlatsDisponibles.values().size();
	}

}
