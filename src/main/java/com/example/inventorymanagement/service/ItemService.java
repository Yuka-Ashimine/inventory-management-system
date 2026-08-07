package com.example.inventorymanagement.service;


import com.example.inventorymanagement.repository.ItemRepository;
import org.springframework.stereotype.Service;
import com.example.inventorymanagement.entity.Item;
import java.util.List;
import org.springframework.data.domain.Sort;
import java.util.stream.Collectors;

@Service
public class ItemService {

        //Repositoryオブジェクトを入れる箱
        private final ItemRepository itemRepository;

        public ItemService(ItemRepository itemRepository){
           this.itemRepository = itemRepository;
        }
        public void save(Item item){
            itemRepository.save(item);
        }

        public List<Item> findAll(){
            return itemRepository.findAll();
        }

        public void deleteById(Long id){
            itemRepository.deleteById(id);
        }

        public Item findById(Long id){
            return itemRepository.findById(id).orElse(null);
        }

        public List<Item> searchByName(String keyword){
            return itemRepository.findByNameContaining(keyword);
        }

        public List<Item> findAllBySort(String sort){
            if("low-stock".equals(sort)){
                return itemRepository.findByStockLessThanEqual(5);
            } else if ("price-asc".equals(sort)) {
                return itemRepository.findAll(
                        Sort.by(Sort.Direction.ASC, "price")
                );
            } else if ("stock-desc".equals((sort))) {
                return itemRepository.findAll(
                        Sort.by(Sort.Direction.DESC, "stock")
                );
            } else if ("name-asc".equals(sort)) {
                return itemRepository.findAll(
                        Sort.by(Sort.Direction.ASC, "name")
                );
            }else {
                return itemRepository.findAll();
            }
        }

        public List<String> findAllCategories() {
             return itemRepository.findAll()
                .stream()
                .map(Item::getCategory)
                .distinct()
                .collect(Collectors.toList());
        }

        public List<Item> searchByCategory(String category) {
             return itemRepository.findByCategory(category);
        }
}
