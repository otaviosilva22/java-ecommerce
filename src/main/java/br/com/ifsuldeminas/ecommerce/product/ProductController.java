package br.com.ifsuldeminas.ecommerce.product;

import java.util.UUID;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/product")
public class ProductController {
    
    @Autowired
    private IProductRepository productRepository;


    @PostMapping("/")
    public ResponseEntity<Object> create(@RequestBody ProductModel productModel){

        try{
            var productCreated = this.productRepository.save(productModel);
            return ResponseEntity.status(200).body(productCreated);
        }catch(Exception e){
            JSONObject jsonObj = new JSONObject();
            jsonObj.put("error", e.getMessage());
            return ResponseEntity.status(500).body(jsonObj.toString());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Object> readAll(){
        try{
            var products = this.productRepository.findAll();

            return ResponseEntity.status(200).body(products);
        }catch(Exception e){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("error", e.getMessage());
            return ResponseEntity.status(500).body(jsonObject.toString());
        }
    }

    @GetMapping("/")
    public ResponseEntity<Object> read(@RequestParam UUID id){

        try{
            var product = this.productRepository.findByIdProduct((UUID) id);

            if (product == null){
                JSONObject jsonObj = new JSONObject();
                jsonObj.put("error", "Product not foud");
                return ResponseEntity.status(404).body(jsonObj.toString());
            }

            return ResponseEntity.status(200).body(product);
            
        }catch(Exception e){
            JSONObject jsonObj = new JSONObject();
            jsonObj.put("error", e.getMessage());
            return ResponseEntity.status(500).body(jsonObj.toString());
        }
    }

    @PatchMapping("/")
    public ResponseEntity<Object> update(@RequestBody ProductModel productModel){
        try{
            var product = this.productRepository.findByIdProduct((UUID) productModel.getId());
            JSONObject jsonObj = new JSONObject();
            if (product == null){
                jsonObj.put("error", "Product not found");
                return ResponseEntity.status(404).body(jsonObj.toString());
            }

            var productUpdated = this.productRepository.save(productModel);
            return ResponseEntity.status(200).body(productUpdated);
        }catch(Exception e){
            JSONObject jsonObj = new JSONObject();
            jsonObj.put("error", e.getMessage());
            return ResponseEntity.status(500).body(jsonObj.toString());
        }
    }

    @DeleteMapping("/")
    public ResponseEntity<Object> delete(@RequestParam UUID id){
        try{

            var product = this.productRepository.findByIdProduct((UUID) id);
            JSONObject jsonObj = new JSONObject();
            if (product == null){
                jsonObj.put("error", "Product not found");
                return ResponseEntity.status(404).body(jsonObj.toString());
            }

            this.productRepository.deleteByIdProduct((UUID) id);
            
            jsonObj.put("id", id);
            jsonObj.put("message", "Product deleted successfuly");
            return ResponseEntity.status(200).body(jsonObj.toString());
        }catch(Exception e){
            JSONObject jsonObj = new JSONObject();
            jsonObj.put("error", e.getMessage());
            return ResponseEntity.status(500).body(jsonObj.toString());
        }
    }
}
