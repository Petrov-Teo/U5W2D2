package PetrovTodor.SpringWebEsercizi.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(int id) {
        super("UPSSSS, l'elemento " + id + "non trovato! Ritenta saraì più fortunato!");
    }
}
