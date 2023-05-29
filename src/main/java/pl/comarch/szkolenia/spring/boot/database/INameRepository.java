package pl.comarch.szkolenia.spring.boot.database;

import java.util.List;

public interface INameRepository {
    void add(String name);
    List<String> getNames();
}
