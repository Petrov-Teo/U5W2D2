package PetrovTodor.SpringWebEsercizi.services;

import PetrovTodor.SpringWebEsercizi.entities.AutorePost;
import PetrovTodor.SpringWebEsercizi.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class AutorService {

    private List<AutorePost> autorePostList = new ArrayList<>();

    public List<AutorePost> findAll() {
        return this.autorePostList;
    }

    public AutorePost saveAutorePost(AutorePost body) {
        Random random = new Random();
        body.setId(random.nextInt(99999));
        body.setAvatar("http://localhost:3001/users/?name=" + body.getNome() + "+" + body.getCognome());
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

    public AutorePost findByIdAndUpdate(int autoreId, AutorePost body) {
        AutorePost found = null;
        for (AutorePost autorePost : this.autorePostList) {
            if (autorePost.getId() == autoreId) {
                found = autorePost;
            }
        }
        if (found == null) throw new NotFoundException(autoreId);
        found.setNome(body.getNome());
        found.setCognome(body.getCognome());
        found.setEmail(body.getEmail());
        found.setDataDiNascita(body.getDataDiNascita());
        return found;
    }

    public void findByIdAndDelete(int autoreId) {
        AutorePost found = null;
        for (AutorePost autorePost : this.autorePostList) {
            if (autorePost.getId() == autoreId) {
                found = autorePost;
                break;
            }
        }
        if (found == null) {
            throw new NotFoundException(autoreId);
        }
        this.autorePostList.remove(found);
    }
}
