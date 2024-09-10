package PetrovTodor.SpringWebEsercizi.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.net.MalformedURLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@NoArgsConstructor
public class AutorePost {
    private int id;
    private String nome;
    private String cognome;
    private String email;
    private LocalDate dataDiNascita;
    private String avatar;

    public AutorePost(String nome, String cognome, String email, String dataDiNascita) throws MalformedURLException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.dataDiNascita = LocalDate.parse(dataDiNascita);
    }
}
