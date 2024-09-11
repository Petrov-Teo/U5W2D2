package PetrovTodor.SpringWebEsercizi.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor
@ToString
public class Post {
    private int id;
    private String categoria;
    private String titolo;
    private String cover;//Immagine
    private String contenuto;
    private double tempoDiLettura;
}
