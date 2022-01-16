package net.javaguides.springboot.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.model.Ticket;
import net.javaguides.springboot.repository.ticketRepository;



@Service
@Transactional
public class ticketService {
	
	@Autowired
	private ticketRepository  rep ;
	
	public List<Ticket> listAll(){
		return rep.findAll();
	}
	
	public void save(Ticket t) {
		rep.save(t);
	}
	
	public void delete(Long id) {
		rep.deleteById(id);
	}
	
	 public Ticket get(long id) {
	        return rep.findById(id).get();
	    }

}
