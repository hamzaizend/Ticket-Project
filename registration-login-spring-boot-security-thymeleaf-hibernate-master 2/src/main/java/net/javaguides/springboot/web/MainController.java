package net.javaguides.springboot.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import net.javaguides.springboot.model.Ticket;
import net.javaguides.springboot.service.ticketService;



@Controller
public class MainController {
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	/*@GetMapping("/")
	public String home() {
		return "index";
	}*/
	
	@Autowired
	private ticketService tService ;
	
	
	
	

	 
	 
	 
	@RequestMapping("/")
	public String viewHomePage(Model model) {
	    List<Ticket> listTickets = tService.listAll();
	    model.addAttribute("listTickets", listTickets);
	     
	    return "index";
	}
	
	@RequestMapping("/new")
	public String showNewTicketPage(Model model) {
	    Ticket ticket = new Ticket();
	    model.addAttribute("Ticket", ticket);
	     
	    return "new_Ticket";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveTicket(@ModelAttribute("Ticket") Ticket ticket) {
	    tService.save(ticket);
	     
	    return "redirect:/";
	}
	
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditTicketPage(@PathVariable(name = "id") int id) {
	    ModelAndView mav = new ModelAndView("edit_Ticket");
	    Ticket ticket = tService.get(id);
	    mav.addObject("Ticket", ticket);
	     
	    return mav;
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteTicket(@PathVariable(name = "id") Long id) {
	    tService.delete(id);
	    return "redirect:/";       
	}
	
	
}
