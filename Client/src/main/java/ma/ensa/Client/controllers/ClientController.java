package ma.ensa.Client.controllers;


import ma.ensa.Client.entities.Client;
import ma.ensa.Client.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientController {


    @Autowired
    private ClientRepository clientRepository;

    @GetMapping("/clients")
    public List findAll() {
        return clientRepository.findAll();
    }

    @GetMapping("/client/{id}")
    public Client findById(@PathVariable Long id) throws Exception {

        return this.clientRepository.findById(id).orElseThrow(() -> new
                Exception("Client inexistnt"));
    }

}

