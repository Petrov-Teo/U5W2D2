package PetrovTodor.SpringWebEsercizi.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Random;

@Getter
@Setter
@NoArgsConstructor
public class AutorePost {
    private int id;
    private String nome;
    private String cognome;
    private String email;
    private LocalDate dataDiNascita;
    private URL avatar;

    public AutorePost(String nome, String cognome, String email, LocalDate dataDiNascita, URL avatar) throws MalformedURLException {
        Random random = new Random();
        this.id = random.nextInt(0, 90000);
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.dataDiNascita = dataDiNascita;
        this.avatar = new URL("http://localhost:3001/users/?name=" + nome + "+" + cognome);
    }
}
