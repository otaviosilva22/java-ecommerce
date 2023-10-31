package br.com.ifsuldeminas.saleproject.saleProduct;

import java.util.UUID;

import org.apache.catalina.connector.Response;
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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifsuldeminas.saleproject.product.IProductRepository;
import br.com.ifsuldeminas.saleproject.sale.ISaleRepository;


@RestController
@RequestMapping("/saleProduct")
public class SaleProductController {
    
    @Autowired
    private ISaleProductRepository saleProductRepository;

    @Autowired
    private ISaleRepository saleRepository;

    @Autowired
    private IProductRepository productRepository;

    @PostMapping("/")
    public ResponseEntity<Object> create(@RequestBody SaleProductModel saleProductModel){
        
        try{

            var sale = this.saleRepository.findByIdSale((UUID) saleProductModel.getSaleId());

            JSONObject jsonObject = new JSONObject();

            if (sale == null){
                jsonObject.put("error", "Sale not found");
                return ResponseEntity.status(404).body(jsonObject.toString());
            }

            var product = this.productRepository.findByIdProduct((UUID) saleProductModel.getProductId());

            if (product == null){
                jsonObject.put("error", "Product not found");
                return ResponseEntity.status(404).body(jsonObject.toString());
            }

            if (product.getQuantity() < saleProductModel.getQuantity()){
                jsonObject.put("error", "Invalid quantity");
                return ResponseEntity.status(400).body(jsonObject.toString());
            }

            product.setQuantity(product.getQuantity() - saleProductModel.getQuantity());
            sale.setTotal(sale.getTotal() + (saleProductModel.getQuantity() * product.getPrice()));

            var productUpdated = this.productRepository.save(product);
            var saleUpdated = this.saleRepository.save(sale);
            var saleCreated = this.saleProductRepository.save(saleProductModel);

            return ResponseEntity.status(200).body(saleCreated);
        }catch(Exception e){
            JSONObject jsonObj = new JSONObject();
            jsonObj.put("error", e.getMessage());
            return ResponseEntity.status(500).body(jsonObj.toString());
        }
        
    }

    @GetMapping("/all")
    public ResponseEntity<Object> readAll(){
        try{
            var saleProducts = this.saleProductRepository.findAll();

            return ResponseEntity.status(200).body(saleProducts);
        }catch(Exception e){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("error", e.getMessage());
            return ResponseEntity.status(500).body(jsonObject.toString());
        }
    }

    @GetMapping("/")
    public ResponseEntity<Object> read(@RequestParam UUID id){
        try{
            var saleProduct = this.saleProductRepository.findByIdSaleProduct((UUID) id);

            JSONObject jsonObject = new JSONObject();
            if (saleProduct == null){
                jsonObject.put("error", "Sale product not found");
                return ResponseEntity.status(404).body(jsonObject.toString());
            }

            return ResponseEntity.status(200).body(saleProduct);
        }catch(Exception e){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("error", e.getMessage());
            return ResponseEntity.status(500).body(jsonObject.toString());
        }
    }

    @PatchMapping("/")
    public ResponseEntity<Object> update(@RequestBody SaleProductModel saleProductModel){
        try{

            var saleProductCreated = this.saleProductRepository.findByIdSaleProduct((UUID) saleProductModel.getId());

            JSONObject jsonObject = new JSONObject();
            if (saleProductCreated == null){
                jsonObject.put("error", "Sale product not found");
                return ResponseEntity.status(404).body(jsonObject.toString());
            }

            var sale = this.saleRepository.findByIdSale(saleProductCreated.getSaleId());
            var product = this.productRepository.findByIdProduct(saleProductCreated.getProductId());


            sale.setTotal(sale.getTotal() - (saleProductCreated.getQuantity() * product.getPrice()));
            
            
            product.setQuantity((product.getQuantity() + saleProductCreated.getQuantity()));
            
            
            if (product.getQuantity() < saleProductModel.getQuantity()){
                jsonObject.put("error", "Invalid quantity");
                return ResponseEntity.status(400).body(jsonObject.toString());
            }

            sale.setTotal(sale.getTotal() + (saleProductModel.getQuantity() * product.getPrice()));
            product.setQuantity(product.getQuantity() - saleProductModel.getQuantity());
            var saleUpdated = this.saleRepository.save(sale);
            var productUpdated = this.productRepository.save(product);

            saleProductModel.setCreatedAt(saleProductCreated.getCreatedAt());
            var saleProductUpdated = this.saleProductRepository.save(saleProductModel);

            return ResponseEntity.status(200).body(saleProductUpdated);
        }catch(Exception e){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("error", jsonObject.toString());
            return ResponseEntity.status(500).body(jsonObject.toString(0));
        }
    }

    @DeleteMapping("/")
    public ResponseEntity<Object> delete(@RequestParam UUID id){
        try{

            var saleProductCreated = this.saleProductRepository.findByIdSaleProduct((UUID) id);

            JSONObject jsonObject = new JSONObject();
            if (saleProductCreated == null){
                jsonObject.put("error", "Sale product not found");
                return ResponseEntity.status(404).body(jsonObject.toString());
            }

            var sale = this.saleRepository.findByIdSale(saleProductCreated.getSaleId());
            var product = this.productRepository.findByIdProduct(saleProductCreated.getProductId());

            sale.setTotal(sale.getTotal() - (saleProductCreated.getQuantity() * product.getPrice()));
            var saleUpdated = this.saleRepository.save(sale);

            product.setQuantity(product.getQuantity() + saleProductCreated.getQuantity());
            var productUpdated = this.productRepository.save(product);

            this.saleProductRepository.deleteByIdSaleProduct((UUID) saleProductCreated.getId());

            jsonObject.put("message", "Sale product deleted successfuly");
            return ResponseEntity.status(200).body(jsonObject.toString());
        }catch(Exception e){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("error", jsonObject.toString());
            return ResponseEntity.status(500).body(jsonObject.toString(0));
        }
    }
}