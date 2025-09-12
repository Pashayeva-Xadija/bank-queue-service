package com.queue.serviceimpl;

import com.queue.dto.CreateTicketRequest;
import com.queue.dto.TicketResponse;
import com.queue.enums.TicketStatus;
import com.queue.exception.BadRequestException;
import com.queue.exception.NotFoundException;
import com.queue.mapper.TicketMapper;
import com.queue.model.Desk;
import com.queue.model.ServiceType;
import com.queue.model.Ticket;
import com.queue.repository.DeskRepository;
import com.queue.repository.ServiceTypeRepository;
import com.queue.repository.TicketRepository;
import com.queue.service.TicketService;
import com.queue.util.TicketNumberGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepo;
    private final ServiceTypeRepository serviceTypeRepo;
    private final DeskRepository deskRepo;
    private final TicketMapper mapper;

    @Override
    public TicketResponse open(CreateTicketRequest req) {
        ServiceType st = serviceTypeRepo.findById(req.getServiceTypeId())
                .orElseThrow(() -> new NotFoundException("ServiceType not found"));
        String number = TicketNumberGenerator.generate();
        Ticket t = Ticket.builder()
                .number(number)
                .status(TicketStatus.OPEN)
                .serviceType(st)
                .build();
        return mapper.toDto(ticketRepo.save(t));
    }

    @Override
    @Transactional
    public TicketResponse callNext(Long deskId) {
        Desk desk = deskRepo.findById(deskId).orElseThrow(() -> new NotFoundException("Desk not found"));
        // sadə: həmin masanın ilk OPEN bileti (servis növündən asılı olmayaraq)
        Ticket t = ticketRepo.findAllByStatus(TicketStatus.OPEN).stream().findFirst()
                .orElseThrow(() -> new BadRequestException("No open tickets"));
        t.setDesk(desk);
        t.setStatus(TicketStatus.CALLED);
        return mapper.toDto(t);
    }

    @Override
    public TicketResponse start(Long ticketId) {
        Ticket t = getTicket(ticketId);
        t.setStatus(TicketStatus.IN_PROGRESS);
        return mapper.toDto(ticketRepo.save(t));
    }

    @Override
    public TicketResponse finish(Long ticketId) {
        Ticket t = getTicket(ticketId);
        t.setStatus(TicketStatus.FINISHED);
        return mapper.toDto(ticketRepo.save(t));
    }

    @Override
    public TicketResponse cancel(Long ticketId) {
        Ticket t = getTicket(ticketId);
        t.setStatus(TicketStatus.CANCELED);
        return mapper.toDto(ticketRepo.save(t));
    }

    @Override
    public List<TicketResponse> monitor() {
        return ticketRepo.findAll().stream().map(mapper::toDto).toList();
    }

    private Ticket getTicket(Long id){
        return ticketRepo.findById(id).orElseThrow(() -> new NotFoundException("Ticket not found"));
    }
}
