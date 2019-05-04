package br.com.gilmario.crudSpringBot.service;

import java.util.List;

import br.com.gilmario.crudSpringBot.model.Post;
import br.com.gilmario.crudSpringBot.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service //Define a classe como um bean do Spring
public class PostService {

    @Autowired
    private PostRepository repository; //Injeta o repositório

    //Retorna uma lista com todos posts inseridos
    public List<Post> findAll() {
        return repository.findAll();
    }

    //Retorno um post a partir do ID
    public Post findOne(Long id) {
        return repository.findOne(id);
    }

    //Salva ou atualiza um post
    public Post save(Post post) {
        return repository.saveAndFlush(post);
    }

    //Exclui um post
    public void delete(Long id) {
        repository.delete(id);
    }

}