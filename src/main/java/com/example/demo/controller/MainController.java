package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Interest;
import com.example.demo.model.Login;
import com.example.demo.model.Payload;
import com.example.demo.model.User;
import com.example.demo.model.User_Interests;
import com.example.demo.repository.InterestRepo;
import com.example.demo.repository.UserInterestRepo;
import com.example.demo.repository.UserRepository;


@RestController
@CrossOrigin("*")
public class MainController {

  @Autowired
private UserRepository userRepository;
  @Autowired
private InterestRepo interest_repo;
  
  @Autowired
private UserInterestRepo userinterest_repo;
  
@PostMapping(path="/addUser") 
public boolean addNewUser (@RequestBody User user)
{
User  u = userRepository.findByEmail(user.getEmail());

if(u==null)
{
userRepository.save(user);
}
else 
{
	return false;
}
return true;
	
}

@PostMapping(path="/addInterest") 
public @ResponseBody String addNInterest (@RequestBody Interest i
) {

interest_repo.save(i);
return "Saved";
}



//@PostMapping(path="/addPayload") 
//public @ResponseBody String addPayload (@RequestBody Payload p
//) {
//
//
//int u =userRepository.findIdByEmail(p.getEmail());
//
//for (int p1 : p.getInterest_ids()) {
//	User_Interests ui = new User_Interests(u,p1);
//	userinterest_repo.save(ui);
//}
//return "Saved";
//}

@PostMapping(path="/addPayload") 
public @ResponseBody String addPayload (@RequestBody Payload p
) {


int u =userRepository.findIdByEmail(p.getEmail());
System.out.println(u);
for (int p1 : p.getInterest_ids()) {
	List <Integer> i= userinterest_repo.findUserInterestExists(u, p1);
	if(i.size()!=0)
	{
		System.out.println("Exists");
		return "Already exists";
	}
	else
	{
		User_Interests ui = new User_Interests(u,p1);

		userinterest_repo.save(ui);
	}
	}
return "saved";
}


@PostMapping(path="/login") 
public @ResponseBody boolean addNewUser (@RequestBody Login login)
{
	
	User  u = userRepository.findByEmail(login.getEmail());
	
if(u!=null)
{
	if(!(login.getPassword().equals(u.getPassword())))
	{
		System.out.println("Wrong password");
		return false;
	}
	else
	{
		return true;
	}

}
	else 
		return false;
}

@GetMapping(path="/{email}/interests")
public List<Integer> findInterests(@PathVariable String email){
	

	int x=userRepository.findIdByEmail(email);
	//System.out.println(userinterest_repo.findByUserId(x) +"    "+x);
	return userinterest_repo.findByUserId(x);
		
} 

@GetMapping(path="/all")
public @ResponseBody Iterable<User> getAllUsers() {
return userRepository.findAll();
}

  @GetMapping("/hello")
  public  String hello() {
  
    return "hello";
  }


@DeleteMapping(path="/{email}/{id}")
public boolean deleteInterest(@PathVariable String email,@PathVariable int id) {
	
	User u=userRepository.findByEmail(email);
	//System.out.println(u);
	User_Interests ui=userinterest_repo.findByUid(u.getId(),id);
	//System.out.println(ui);
	
	if(ui==null)
	{
		return false;
	}
	else {
		userinterest_repo.delete(ui);
		return true;
	}
//return true;
	
}
}


