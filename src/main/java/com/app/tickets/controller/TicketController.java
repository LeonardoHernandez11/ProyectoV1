package com.app.tickets.controller;

import com.app.tickets.dto.TicketRequestDTO;
import com.app.tickets.dto.TicketResponseDTO;
import com.app.tickets.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tickets")
@RequiredArgsConstructor
public class TicketController {

    private final TicketService ticketService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<TicketResponseDTO> registrarTicket(@ModelAttribute TicketRequestDTO requestDTO) {
        TicketResponseDTO response = ticketService.registrarTicket(requestDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}