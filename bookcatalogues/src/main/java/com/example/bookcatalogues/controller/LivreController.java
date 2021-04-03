package com.example.bookcatalogues.controller;

import com.example.bookcatalogues.entity.Genre;
import com.example.bookcatalogues.entity.Livre;
import com.example.bookcatalogues.repository.LivreRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;




@RestController
@RequestMapping(path="/livre")
public class LivreController {
	@Autowired
	private LivreRepository livreRepository;
	
	@PostMapping(path="/livre/add")
	public @ResponseBody String addNewLivre(@RequestParam String titre, @RequestParam String refeni, @RequestParam String auteur, @RequestParam String isbn, @RequestParam Boolean disponibilité, @RequestParam Genre genre) {
		Livre l = new Livre(null, titre, refeni, auteur, isbn, disponibilité, genre);
		l.setTitre(titre);
		l.setRefeni(refeni);
		l.setAuteur(auteur);
		l.setIsbn(isbn);
		l.setDisponibilité(disponibilité);
		l.setGenre(new Genre(null, null));
		livreRepository.save(l);
		
		return "Saved";
	}
	
	@GetMapping(path="/livre/all")
    public @ResponseBody Iterable<Livre> getAllLivres() {
	    // This returns a JSON or XML with the users
	    return livreRepository.findAll();
	  }
	
	@GetMapping(path="/livre/{id}")
	public @ResponseBody Optional<Livre> getLivreById(@PathVariable Integer id){
		return livreRepository.findById(id);
		
	}
	
	@GetMapping(path="/livre/{titre}")
	public @ResponseBody Optional<Livre> getLivreByTitre(@PathVariable("titre") String titre){
		return livreRepository.findByTitre(titre);
		
	}
	
	@GetMapping(path="/livre/{genre}")
	public @ResponseBody Optional<Livre> getLivreByGenre(@PathVariable("genre") Genre genre){
		return livreRepository.findByGenre(genre);
		
	}
	
	@GetMapping(path="/livre/disponibilité/{id}")
	public @ResponseBody boolean checkLivreDispo(@PathVariable("id") Integer id){
		return livreRepository.existsById(id);
		
	}
	
	
	@RequestMapping(method=RequestMethod.PUT, value="/livre/update/{id}")
	public void updateLivre(@RequestBody Livre livre, @PathVariable("id") Integer id) {
		livreRepository.save(livre);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/livre/delete/{id}")
	public void deleteLivre(@RequestBody Livre livre, @PathVariable("id") Integer id) {
		livreRepository.deleteById(id);
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)    
	public ModelAndView save(@ModelAttribute Livre livre){ 
		ModelAndView modelAndView = new ModelAndView();    
	    modelAndView.setViewName("livreForm");        
	    modelAndView.addObject("livre", livre);      
	    return modelAndView;    
	}    
	
	
	
	

}
