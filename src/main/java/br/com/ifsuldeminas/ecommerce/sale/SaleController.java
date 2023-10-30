package br.com.ifsuldeminas.ecommerce.sale;

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
@RequestMapping("/sale")
public class SaleController {
    
    @Autowired
    private ISaleRepository saleRepository;

    @PostMapping("/")
    public ResponseEntity<Object> create(@RequestBody SaleModel saleModel){
        
        try{
            var saleCreated = this.saleRepository.save(saleModel);

            return ResponseEntity.status(200).body(saleCreated);
        }catch(Exception e){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("error", e.getMessage());

            return ResponseEntity.status(500).body(jsonObject.toString());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Object> readAll(){
        try{
            var sales = this.saleRepository.findAll();

            return ResponseEntity.status(200).body(sales);
        }catch(Exception e){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("error", e.getMessage());
            return ResponseEntity.status(500).body(jsonObject.toString());
        }
    }

    @GetMapping("/")
    public ResponseEntity<Object> read(@RequestParam UUID id){
        try{
            var sale = this.saleRepository.findByIdUser((UUID) id);

            if (sale == null){
                JSONObject jsonObj = new JSONObject();
                jsonObj.put("error", "Sale not found");
                return ResponseEntity.status(404).body(jsonObj.toString());
            }

            return ResponseEntity.status(200).body(sale);
        }catch(Exception e){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("error", e.getMessage());

            return ResponseEntity.status(500).body(jsonObject.toString());
        }
    }

    @GetMapping("/idSale")
    public ResponseEntity<Object> readByIdSale(@RequestParam UUID id){
        try{
            var sale = this.saleRepository.findByIdSale((UUID) id);

            if (sale == null){
                JSONObject jsonObj = new JSONObject();
                jsonObj.put("error", "Sale not found");
                return ResponseEntity.status(404).body(jsonObj.toString());
            }

            return ResponseEntity.status(200).body(sale);
        }catch(Exception e){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("error", e.getMessage());

            return ResponseEntity.status(500).body(jsonObject.toString());
        }
    }

    @PatchMapping("/")
    public ResponseEntity<Object> update(@RequestBody SaleModel saleModel){
        try{

            var sale = this.saleRepository.findByIdSale((UUID) saleModel.getId());

            JSONObject jsonObject = new JSONObject();
            if (sale == null){
                jsonObject.put("error", "Sale not found");
                return ResponseEntity.status(404).body(jsonObject.toString());
            }else if (!sale.getUserId().equals(saleModel.getUserId())){
                jsonObject.put("key", "This sale id isn't from this user");
                return ResponseEntity.status(400).body(jsonObject.toString());
            }

            saleModel.setCreatedAt(sale.getCreatedAt());
            var saleUpdated = this.saleRepository.save(saleModel);
            return ResponseEntity.status(200).body(saleUpdated);
        }catch(Exception e){
            JSONObject jsonObj = new JSONObject();
            jsonObj.put("error", e.getMessage());
            return ResponseEntity.status(500).body(jsonObj.toString());
        }
    }

    @DeleteMapping("/")
    public ResponseEntity<Object> delete(@RequestParam UUID id){
        try{
            JSONObject jsonObj = new JSONObject();
            var sale = this.saleRepository.findByIdSale((UUID) id);
            if (sale == null){
                jsonObj.put("error", "Sale not found");
                return ResponseEntity.status(404).body(jsonObj.toString());
            }

            this.saleRepository.deleteByIdSale((UUID) id);
           
            jsonObj.put("id", id);
            jsonObj.put("message", "Sale deleted successfuly");
            return ResponseEntity.status(200).body(jsonObj.toString());
        }catch(Exception e){
            JSONObject jsonObj = new JSONObject();
            jsonObj.put("error", e.getMessage());
            return ResponseEntity.status(500).body(jsonObj.toString());
        }
    }
}
