package org.sid.lightecom.dao;

import org.sid.lightecom.entities.Category;
import org.sid.lightecom.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin("*")

@RepositoryRestResource //pour utiliser WS generique
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
