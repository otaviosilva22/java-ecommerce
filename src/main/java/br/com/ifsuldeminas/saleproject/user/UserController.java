package br.com.ifsuldeminas.saleproject.user;

import java.util.UUID;

import org.apache.catalina.valves.JsonAccessLogValve;
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


@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private IUserRepository userRepository;

    @PostMapping("/")
    public ResponseEntity create(@RequestBody UserModel userModel){
        try{
            var userCreated = this.userRepository.save(userModel);

            return ResponseEntity.status(200).body(userCreated);
        }catch(Exception e){
            JSONObject jsonObj = new JSONObject();
            jsonObj.put("error", e.getMessage());
            return ResponseEntity.status(500).body(jsonObj.toString());
        }
        
    }

    @GetMapping("/all")
    public ResponseEntity<Object> readAll(){
        try{
            var users = this.userRepository.findAll();

            return ResponseEntity.status(200).body(users);
        }catch(Exception e){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("error", e.getMessage());
            return ResponseEntity.status(500).body(jsonObject.toString());
        }
    }

    @GetMapping("/")
    public ResponseEntity<Object> read(@RequestParam UUID id){
        try{
            var user = this.userRepository.findByUserId((UUID) id);

            if (user == null){
                JSONObject jsonObj = new JSONObject();
                jsonObj.put("error", "User not found");
                return ResponseEntity.status(404).body(jsonObj.toString());
            }

            return ResponseEntity.status(200).body(user);

        }catch(Exception e){
            JSONObject jsonObj = new JSONObject();
            jsonObj.put("error", e.getMessage());
            return ResponseEntity.status(500).body(jsonObj.toString());
        }
    }

    @PatchMapping("/")
    public ResponseEntity<Object> update(@RequestBody UserModel userModel){
        try{

            var user = this.userRepository.findByUserId((UUID) userModel.getId());

            if (user == null){
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("error", "User not found");
                return ResponseEntity.status(404).body(jsonObject.toString());
            }

            userModel.setCreatedAt(user.getCreatedAt());
            var userUpdated = this.userRepository.save(userModel);
            
            return ResponseEntity.status(200).body(userUpdated);
        }catch(Exception e){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("error", e.getMessage());
            return ResponseEntity.status(500).body(jsonObject.toString());
        }
    }

    @DeleteMapping("/")
    public ResponseEntity<Object> delete(@RequestParam UUID id){
        try{
            var user = this.userRepository.findByUserId((UUID) id);

            JSONObject jsonObject = new JSONObject();
            if (user == null){
                jsonObject.put("error", "User not found");
                return ResponseEntity.status(404).body(jsonObject.toString());
            }

            this.userRepository.deleteByUserId(id);

            jsonObject.put("message", "User deleted successfuly");
            return ResponseEntity.status(200).body(jsonObject.toString());
        }catch(Exception e){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("error", e.getMessage());
            return ResponseEntity.status(500).body(jsonObject.toString());
        }
    }
}
