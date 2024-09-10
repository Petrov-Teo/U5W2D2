package PetrovTodor.SpringWebEsercizi.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;


@Getter
@Setter
@NoArgsConstructor
@ToString
public class Post {
    private int id;
    private String categoria;
    private String titolo;
    private URL cover;
    private String contenuto;
    private double tempoDiLettura;

    public Post(int id, String categoria, String titolo, String cover, String contenuto, double tempoDiLettura) throws MalformedURLException {
        Random random = new Random();
        this.id = random.nextInt(0, 99999);
        this.categoria = categoria;
        this.titolo = titolo;
        this.cover = new URL(cover);
        this.contenuto = contenuto;
        this.tempoDiLettura = tempoDiLettura;
    }
}
