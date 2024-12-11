package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.example.demo.model.Persona;

/*
 la etiqueta @request funciona como el request del servlet del anterior proyecto,
 guarda variables con sus valores.
 */

@Controller
@RequestMapping("/")
public class MetodosController {
	
	private static final Log LOG = LogFactory.getLog(MetodosController.class);
	
	/*
	@GetMapping("/")
	public String redirect1() {
		return "redirect:/ejemplopost/form";
	}
	*/
	@GetMapping("/")
	public RedirectView redirect2() {
		return new RedirectView("/ejemplopost/form");
	}
	
	@GetMapping(value = "/Metodo1")
	public String Metodo1() {
		LOG.info("Ingreso a la Vista 1");
		return "Vista1";
	}
	
	@GetMapping(value = "/Metodo2")
	public ModelAndView Metodo2() {
		LOG.info("Ingreso a la Vista 2");
		ModelAndView mav = new ModelAndView("Vista2");
		List<Persona> p = Get_Personas();
;		mav.addObject("p", p);
		return mav;
	}
	
	@GetMapping(value = "/Metodo3")
	public ModelAndView Metodo3(@RequestParam(name="nombre") String nombre) {
		ModelAndView mav = new ModelAndView("Vista3");
		mav.addObject("nombre", nombre);
		return mav;
	}
	
	@GetMapping(value = "/Metodo4/{nombre}")
	public ModelAndView Metodo4(@PathVariable(name="nombre") String nombre) {
		ModelAndView mav = new ModelAndView("Vista4");
		mav.addObject("nombre", nombre);
		return mav;
	}
	
	private List<Persona> Get_Personas(){
		List<Persona> p = new ArrayList<>();
		p.add(new Persona("Leonardo", "985 654 256"));
		p.add(new Persona("Francisco", "935 454 723"));
		p.add(new Persona("Leonardo", "956 888 123"));
		
		return p;
	}
	
}
