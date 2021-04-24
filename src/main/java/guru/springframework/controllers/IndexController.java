package guru.springframework.controllers;


import guru.springframework.model.Category;
import guru.springframework.model.UnitOfMeasure;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.UOIRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private CategoryRepository categoryRepository;
    private UOIRepository uoiRepository;

    public IndexController(CategoryRepository categoryRepository, UOIRepository uoiRepository) {
        this.categoryRepository = categoryRepository;
        this.uoiRepository = uoiRepository;
    }

    @RequestMapping({"/","","index"})
    public String getIndexPage(){

        Optional<Category> categoryOptional  = categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> unitOfMeasureOptional = uoiRepository.findByDescription("Pinch");

        System.out.println("Cat Id is: "+ categoryOptional.get().getId());
        System.out.println("UOI Id is: "+ unitOfMeasureOptional.get().getId());



        return "index";
    }
}
