package org.example.thymeleafproductspring.controller;

import org.example.thymeleafproductspring.model.Product;
import org.example.thymeleafproductspring.service.ProductService;
import org.example.thymeleafproductspring.service.IProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    private final IProductService productService = new ProductService();

    @GetMapping("")
    public String index(Model model){
        List<Product> productList = productService.findAll();
        model.addAttribute("products", productList);
        return "/index";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("product", new Product());
        return "/create";
    }

    @PostMapping("/save")
    public String save(Product product){
        product.setId((int) (Math.random() * 10000));
        productService.save(product);
        return "redirect:/products";
    }

    @GetMapping("/{id}/edit")
    public String update(@PathVariable int id, Model model){
        model.addAttribute("product", productService.findById(id));
        return "/update";
    }

    @PostMapping("/update")
    public String update(Product product){
        productService.update(product.getId(), product);
        return "redirect:/products";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model){
        model.addAttribute("product", productService.findById(id));
        return "/delete";
    }

    @PostMapping("/delete")
    private String delete(Product product, RedirectAttributes redirect){
        productService.remove(product.getId());
        redirect.addAttribute("success", "Remove product successfully!");
        return "redirect:/products";
    }

    @GetMapping("/{id}/view")
    private String view(@PathVariable int id, Model model){
        model.addAttribute("product", productService.findById(id));
        return "/view";
    }

    @GetMapping("/{name}/search")
    private String search(@PathVariable String name, Model model){
        model.addAttribute("product", productService.findByName(name));
        return "/search";
    }

//    @PostMapping("/search")
//    private String search(@PathVariable)
}
