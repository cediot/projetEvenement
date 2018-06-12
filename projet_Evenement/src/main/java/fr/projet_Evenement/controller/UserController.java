package fr.projet_Evenement.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.projet_Evenement.lib.User;


@RestController
public class UserController {
		@GetMapping("/User")
		public List<Object> allUsers(){
				List<Object> users = new ArrayList<>();
				
				User u1= new User();
				return users;
		}
				
}
