package com.app.tickets.dto;

import org.springframework.web.multipart.MultipartFile;
import com.app.tickets.model.PrioridadTicket;

public record TicketRequestDTO(
        String nombrePersona,
        String descripcionProblema,
        PrioridadTicket prioridad,
        MultipartFile archivoAdjunto) {
}