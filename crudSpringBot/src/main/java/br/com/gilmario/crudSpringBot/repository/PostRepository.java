package br.com.gilmario.crudSpringBot.repository;

import br.com.gilmario.crudSpringBot.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PostRepository extends JpaRepository<Post, Long> { }
