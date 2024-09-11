package PetrovTodor.SpringWebEsercizi.services;

import PetrovTodor.SpringWebEsercizi.entities.Post;
import PetrovTodor.SpringWebEsercizi.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class PostService {

    private List<Post> postList = new ArrayList<>();

    public List<Post> findAll() {
        return this.postList;
    }

    public Post savePost(Post body) {
        Random random = new Random();
        body.setId(random.nextInt(99999));
        if (body.getTempoDiLettura() == 0.0) {
            int wordCount = body.getContenuto().split(" ").length;
            double tempoDiLetturaStimato = (double) wordCount / 100;
            body.setTempoDiLettura(tempoDiLetturaStimato); // Arrotonda a 2 decimali
        }
        postList.add(body);
        return body;
    }

    public Post findPostById(int postId) {
        Post found = null;
        for (Post post : this.postList) {
            if (post.getId() == postId) {
                found = post;
            }
        }
        if (found == null) throw new NotFoundException(postId);
        return found;
    }

    public Post findPostByIdAndUpdate(int postId, Post body) {
        Post found = this.postList.stream()
                .filter(post -> post.getId() == postId)
                .findFirst()
                .orElseThrow(() -> new NotFoundException(postId));

        found.setCategoria(body.getCategoria());
        found.setTitolo(body.getTitolo());
        found.setCover(body.getCover());
        found.setContenuto(body.getContenuto());
        return found;
    }

    public void findAndDelete(int postId) {
        Post found = this.postList.stream()
                .filter(post -> post.getId() == postId)
                .findFirst()
                .orElseThrow(() -> new NotFoundException(postId));
        this.postList.remove(found);
    }
}
