package com.theaterapi.service;

import com.theaterapi.model.Ticket;
import com.theaterapi.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {
    private TicketRepository ticketRepository;

    @Autowired
    public TicketService(TicketRepository ticketRepository){
        this.ticketRepository = ticketRepository;
    }

    //Get all Ticket Detail
    public List<Ticket> retrieveTickets() {
        return ticketRepository.findAll();
    }

    public List<Ticket> retrieveTicketsByUsername(String username) {
        return ticketRepository.findByUsername(username);
    }

    public Optional<Ticket> retrieveTicket(String id) {
        return ticketRepository.findById(id);
    }

    public Ticket createTicket(Ticket ticket){
        return ticketRepository.save(ticket);
    }

    public boolean deleteTicket(String id) {
        if(ticketRepository.existsById(id)){
            ticketRepository.deleteById(id);
            return true;
        }
        else {
            return false;
        }
    }



}
