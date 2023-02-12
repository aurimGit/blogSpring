package spring.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.project.entities.Blog;

@Repository
public interface BlogRepository extends JpaRepository <Blog,Long>{

}
