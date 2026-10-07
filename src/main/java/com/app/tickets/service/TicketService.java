package com.app.tickets.service;

import com.app.tickets.dto.TicketRequestDTO;
import com.app.tickets.dto.TicketResponseDTO;
import com.app.tickets.model.EstatusTicket;
import com.app.tickets.model.Ticket;
import com.app.tickets.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TicketService {

    private final TicketRepository ticketRepository;

    public TicketResponseDTO registrarTicket(TicketRequestDTO requestDTO) {
        String rutaArchivo = guardarArchivo(requestDTO.archivoAdjunto());

        Ticket nuevoTicket = Ticket.builder()
                .nombrePersona(requestDTO.nombrePersona())
                .descripcionProblema(requestDTO.descripcionProblema())
                .fechaRegistro(LocalDateTime.now())
                .estatus(EstatusTicket.ABIERTO)
                .prioridad(requestDTO.prioridad())
                .archivoAdjunto(rutaArchivo)
                .build();

        Ticket ticketGuardado = ticketRepository.save(nuevoTicket);

        return mapToDTO(ticketGuardado);
    }

    private String guardarArchivo(MultipartFile archivo) {
        if (archivo == null || archivo.isEmpty()) {
            return null;
        }

        return "uploads/" + UUID.randomUUID() + "_" + archivo.getOriginalFilename();
    }

    private TicketResponseDTO mapToDTO(Ticket ticket) {
        return new TicketResponseDTO(
                ticket.getId(),
                ticket.getNombrePersona(),
                ticket.getDescripcionProblema(),
                ticket.getFechaRegistro(),
                ticket.getEstatus(),
                ticket.getArchivoAdjunto(),
                ticket.getPrioridad());
    }
}