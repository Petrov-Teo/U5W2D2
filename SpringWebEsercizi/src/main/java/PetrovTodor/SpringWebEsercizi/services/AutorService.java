package PetrovTodor.SpringWebEsercizi.services;

import PetrovTodor.SpringWebEsercizi.entities.AutorePost;
import PetrovTodor.SpringWebEsercizi.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AutorService {

    private List<AutorePost> autorePostList = new ArrayList<>();

    public List<AutorePost> findAll() {
        return this.autorePostList;
    }

    public AutorePost saveAutorePost(AutorePost body) {
        this.autorePostList.add(body);
        return body;
    }

    public AutorePost findById(int autoreId) {
        AutorePost found = null;
        for (AutorePost autorePost : this.autorePostList) {
            if (autorePost.getId() == autoreId) {
                found = autorePost;

            }
        }
        if (found == null) throw new NotFoundException(autoreId);
        return found;
    }

    public AutorePost findByIdAndUpdite(int autoreId, AutorePost body) {
        AutorePost found = null;
        findById(autoreId);
        found.setNome(body.getNome());
        found.setCognome(body.getCognome());
        found.setEmail(body.getEmail());
        found.setDataDiNascita(body.getDataDiNascita());
        return found;
    }
}
