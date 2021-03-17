package org.sid.lightecom;

import net.bytebuddy.utility.RandomString;
import org.sid.lightecom.dao.CategoryRepository;
import org.sid.lightecom.dao.ProductRepository;
import org.sid.lightecom.entities.Category;
import org.sid.lightecom.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Random;
import java.util.RandomAccess;

@SpringBootApplication
public class LightEcomApplication implements CommandLineRunner {

    @Autowired //injection des dependenace je le dis injecte moi cette interface sans que j'ai fait une
    //implementation auparavant
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;


    public static void main(String[] args) {
        SpringApplication.run(LightEcomApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        categoryRepository.save(new Category(null,"ordinateur",null,null,null));
        categoryRepository.save(new Category(null,"Imprimante",null,null,null));
        categoryRepository.save(new Category(null,"SmartPhone",null,null,null));

        Random rnd = new Random();
        categoryRepository.findAll().forEach(c->{

            for (int i = 0; i <10 ; i++) {

                Product p = new Product();
                p.setName(RandomString.make(18));
                p.setCurrentPrice(100+rnd.nextInt(10000));
                p.setAvailable(rnd.nextBoolean());
                p.setPromotion(rnd.nextBoolean());
                p.setCategory(c);
                p.setSelected((rnd.nextBoolean()));
                p.setPhotoName("unknown.png");

                productRepository.save(p);
            }


        });

    }
}
