package com.jwt.example.Service;

import com.jwt.example.Entitties.Users;
import com.jwt.example.repository.Userrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class Userservice {
    //private List<Users> store = new ArrayList<>();

//    public Userservice() {
//        store.add(new Users("123",
//                "kashish hora",
//                "kashishhora28@gmail.com"));
//        store.add(new Users("456",
//                "khush hora",
//                "khushihora45@gmail.com"));
//        store.add(new Users("789",
//                "khushboo hora",
//                "khushboo90@gmail.com"));
//        store.add(new Users("765",
//                "Nancy hora",
//                "Nancy@gmail.com"));
//
    @Autowired
    private Userrepository userrepository;
    @Autowired
    private PasswordEncoder passwordEncoder;




    public List<Users> getUsers(){
        return userrepository.findAll();
    }


public Users createUser(Users user){
    user.setUserId(UUID.randomUUID().toString());
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    return userrepository.save(user);

}
}

