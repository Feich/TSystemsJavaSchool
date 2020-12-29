package test.dao;

import model.Cargo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class CargoDao {
    private static final AtomicLong AUTO_ID = new AtomicLong(0);
    private static Map<Long, Cargo> cargoes = new HashMap<>();

    static {
        Cargo cargo1 = new Cargo(AUTO_ID.getAndIncrement(), "cargo1", 1.1F, "OK");
        Cargo cargo2 = new Cargo(AUTO_ID.getAndIncrement(), "cargo2", 1.2F, "OK");
        Cargo cargo3 = new Cargo(AUTO_ID.getAndIncrement(), "cargo3", 1.3F, "OK");
    }

    public List<Cargo> allCargoes() {
        return new ArrayList<>(cargoes.values());
    }

    public void add(Cargo cargo) {
        cargo.setId(AUTO_ID.getAndIncrement());
        cargoes.put(cargo.getId(), cargo);
    }

    public static void delete(Cargo cargo) {
        cargoes.remove(cargo.getId());
    }

    public void edit(Cargo cargo) {
        cargoes.put(cargo.getId(), cargo);
    }

    public Cargo getById(long id) {
        return cargoes.get(id);
    }
}
