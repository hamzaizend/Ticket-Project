package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.model.Ticket;



@Repository
public interface ticketRepository extends JpaRepository<Ticket, Long>{

}

