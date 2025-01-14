package com.comperativa.losandes.controllers;

import com.comperativa.losandes.models.dto.*;
import com.comperativa.losandes.services.AgenteCashService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/b2cash")
@Slf4j
public class AgenteCashController {
    private final AgenteCashService agenteCashService;

    public AgenteCashController(AgenteCashService agenteCashService) {
        this.agenteCashService = agenteCashService;
    }

    @GetMapping(value = "/servicios", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServiceResponseDTO> obtenerServicios(@RequestParam String nombre) {
        return ResponseEntity.ok().body(agenteCashService.obtenerServicios(nombre));
    }

    @GetMapping(value = "/servicios/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DetalleServiceResponseDTO> obtenerDetalleServicios(@PathVariable String id) {
        return ResponseEntity.ok().body(agenteCashService.obtenerDetalleServicios(id));
    }

    @PostMapping(value = "/servicios/{id}/detalle", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DetalleReciboResponseDTO> obtenerDetalleRecibo(
            @PathVariable String id,
            @RequestParam String valor,
            @RequestParam(required = false) String ers,
            @RequestBody AgencyDTO agencyDTO
    ) {
        return ResponseEntity.ok().body(agenteCashService.obtenerDetalleRecibo(agencyDTO, id, valor, ers));
    }

    @PostMapping(value = "/pagos/simulacion", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SimulacionPagoResponseDTO> simularPago(
            @RequestBody SimulacionPagoRequestDTO simulacionPagoRequestDTO
    ) {
        return ResponseEntity.ok().body(agenteCashService.simularPago(simulacionPagoRequestDTO));
    }

    @PostMapping(value = "/pagar", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PagoServicioRequestDTO> pagarServicio(
            @RequestBody SimulacionPagoRequestDTO simulacionPagoRequestDTO
    ) {
        return ResponseEntity.ok().body(agenteCashService.pagoServicio(simulacionPagoRequestDTO));
    }

    @PostMapping(value = "/extornar", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ExtornarResponseDTO> extornar(
            @RequestBody ExtornarRequestDTO extornarRequestDTO
    ) {
        return ResponseEntity.ok().body(agenteCashService.extonar(extornarRequestDTO));
    }
}
