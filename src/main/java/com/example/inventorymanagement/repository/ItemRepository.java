package com.example.inventorymanagement.repository;

import com.example.inventorymanagement.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

//Spring Bootが保存,一覧,削除,更新,全部作る
public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findByNameContaining(String keyword);
    List<Item> findByStockLessThanEqual(int stock);
    List<Item> findByCategory(String category);
    
}

