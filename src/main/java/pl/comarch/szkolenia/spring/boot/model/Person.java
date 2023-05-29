package pl.comarch.szkolenia.spring.boot.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Person {
    private int id;
    private String name;
    private String surname;
}
