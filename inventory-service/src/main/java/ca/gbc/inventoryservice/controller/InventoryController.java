package ca.gbc.inventoryservice.controller;


import ca.gbc.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    //http:localhost:8083/api/inventory?skuCode=SKU001&quantity=5
   @GetMapping
   @ResponseStatus(HttpStatus.OK)
    public Boolean isInStock(@RequestParam String skuCode, Integer quantity) {
       return inventoryService.isInStock(skuCode, quantity);
    }
}
