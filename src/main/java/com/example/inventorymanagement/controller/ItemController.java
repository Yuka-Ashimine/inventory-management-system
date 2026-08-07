package com.example.inventorymanagement.controller;

import com.example.inventorymanagement.entity.Item;
import com.example.inventorymanagement.service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import java.util.List;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class ItemController {
    //設計図     //itemServicesというオブジェクトを入れる箱
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @ModelAttribute("item")
    public Item createItem(){
        return new Item();
    }

    @GetMapping("/")
    public String index(Model model) {
        List<Item> items = itemService.findAll();
        List<String> categories = itemService.findAllCategories();
        model.addAttribute("items", items);
        model.addAttribute("categories", categories);
        return "index";
    }

    @PostMapping("/save")
    public String save(
        @Valid @ModelAttribute("item") Item item,
        BindingResult bindingResult,
        Model model,
        RedirectAttributes redirectAttributes
    ) {

        if(bindingResult.hasErrors()){
            List<Item> items = itemService.findAll();
            List<String> categories = itemService.findAllCategories();

            model.addAttribute("items",items);
            model.addAttribute("categories",categories);

            return "index";
        }

        itemService.save(item);

        redirectAttributes.addFlashAttribute(
                "message",
                "商品を登録しました"
        );
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String delete(
            Long id,
            RedirectAttributes redirectAttributes) {
        itemService.deleteById(id);
        redirectAttributes.addFlashAttribute(
                "message",
                "備品を削除しました"
        );
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        Item item = itemService.findById(id);
        model.addAttribute("item", item);
        return "edit";
    }

    @PostMapping("/update")
    public String update(
            @Valid @ModelAttribute("item")Item item,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes) {

        if(bindingResult.hasErrors()){
           return "edit";
        }
        itemService.save(item);

        redirectAttributes.addFlashAttribute(
                "message",
                "備品を更新しました"
        );
        return "redirect:/";
    }

    @GetMapping("/search")
    public String search(String keyword, Model model) {

        List<Item> items = itemService.searchByName(keyword);
        List<String> categories = itemService.findAllCategories();

        model.addAttribute("items", items);
        model.addAttribute("categories", categories);
        return "index";
    }

    @GetMapping("/sort")
    public String sort(String sort,Model model){
       List<Item> items = itemService.findAllBySort(sort);
       List<String> categories = itemService.findAllCategories();
       model.addAttribute("items", items);
       model.addAttribute("categories", categories);
       return "index";
    }

    @GetMapping("/category")
    public String category(String category,Model model){
        List<Item> items = itemService.searchByCategory(category);
        List<String> categories = itemService.findAllCategories();

        model.addAttribute("items", items);
        model.addAttribute("categories", categories);

        return "index";
    }


}