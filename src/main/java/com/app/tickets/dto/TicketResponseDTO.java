package com.app.tickets.dto;

import com.app.tickets.model.EstatusTicket;
import com.app.tickets.model.PrioridadTicket;
import java.time.LocalDateTime;

public record TicketResponseDTO(
        Long id,
        String nombrePersona,
        String descripcionProblema,
        LocalDateTime fechaRegistro,
        EstatusTicket estatus,
        String archivoAdjunto,
        PrioridadTicket prioridad) {
}