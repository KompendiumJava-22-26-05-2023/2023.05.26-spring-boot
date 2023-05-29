package pl.comarch.szkolenia.spring.boot.database;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class NamesRepository implements INameRepository {
    private final List<String> names = new ArrayList<>();

    public NamesRepository() {
        this.names.add("Janusz");
        this.names.add("Zbyszek");
        this.names.add("Wiesiek");
        this.names.add("Karol");
        this.names.add("Mateusz");
    }

    @Override
    public void add(String name) {
        this.names.add(name);
    }

    @Override
    public List<String> getNames() {
        return this.names;
    }
}
