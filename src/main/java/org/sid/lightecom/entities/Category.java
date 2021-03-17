package org.sid.lightecom.entities;

import com.sun.codemodel.internal.fmt.JSerializedObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
//pour ke ça soit une entity jpa
@Data @NoArgsConstructor @AllArgsConstructor
//setters,getters,constructors
public class Category implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
   //id est un primary key
    private Long id;
    private String name;
    private String description;
    private String photo;
    @OneToMany(mappedBy = "category")
    private Collection<Product> products;


    
}
