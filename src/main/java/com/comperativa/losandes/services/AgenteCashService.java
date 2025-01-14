package com.comperativa.losandes.services;

import com.comperativa.losandes.models.dto.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Instant;

@Service
public class AgenteCashService {
    private final WebClient webClient;
    @Value("${spring.webclient.oauth.auth-path}")
    private String authPath;
    @Value("${spring.webclient.oauth.username}")
    private String user;
    @Value("${spring.webclient.oauth.password}")
    private String pass;
    @Value("${spring.webclient.api-key.value}")
    private String valueApiKey;
    @Value("${spring.webclient.services-path}")
    private String servicesPath;
    @Value("${spring.webclient.pagos-simulacion-path}")
    private String pagosSimulacionPath;
    @Value("${spring.webclient.pagos-servicios-path}")
    private String pagosServiciosPath;
    @Value("${spring.webclient.pagos-extornar-path}")
    private String pagosExtornarPath;
    private String token; // Token actual
    private Instant tokenExpiration; // Hora de expiración del token
    private static final String AUTHORIZATION = "Authorization";
    private static final String BEARER = "Bearer ";
    private static final String X_API_KEY = "x-api-key";

    public AgenteCashService(WebClient webClient) {
        this.webClient = webClient;
    }

    // Método para obtener un nuevo token y actualizar el estado del token
    private synchronized void refreshAuthToken() {
        AuthRequestDTO authRequest = new AuthRequestDTO();
        authRequest.setAuth("login");
        authRequest.setUsername(user);
        authRequest.setPassword(pass);

        AuthResponseDTO authResponse = webClient.post()
                .uri(authPath)
                .bodyValue(authRequest)
                .retrieve()
                .bodyToMono(AuthResponseDTO.class)
                .block();

        if (authResponse != null && authResponse.getStatusCode() == 200) {
            this.token = authResponse.getToken();
            this.tokenExpiration = Instant.now().plusSeconds(authResponse.getExpiresIn()); // Supone que `expiresIn` está en segundos
        } else {
            throw new RuntimeException("No se pudo obtener el token");
        }
    }

    // Verificar si el token está expirado y refrescarlo si es necesario
    private synchronized void ensureValidToken() {
        if (token == null || tokenExpiration == null || Instant.now().isAfter(tokenExpiration)) {
            refreshAuthToken();
        }
    }

    private ServiceResponseDTO obtenerServiciosAgente(String nombre) {
        ensureValidToken(); // Asegurarse de que el token sea válido
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path(servicesPath)
                        .queryParam("nombre", nombre)
                        .build())
                .header(AUTHORIZATION, BEARER + token)
                .header(X_API_KEY, valueApiKey)
                .retrieve()
                .bodyToMono(ServiceResponseDTO.class)
                .block();
    }

    private DetalleServiceResponseDTO obtenerDetalleServiciosAgente(String id) {
        ensureValidToken(); // Asegurarse de que el token sea válido
        String ruta = String.format("%s/%s", servicesPath, id);
        return webClient.post()
                .uri(ruta)
                .header(AUTHORIZATION, BEARER + token)
                .header(X_API_KEY, valueApiKey)
                .retrieve()
                .bodyToMono(DetalleServiceResponseDTO.class)
                .block();
    }

    private DetalleReciboResponseDTO obtenerDetalleReciboAgente(AgencyDTO agencyDTO, String id, String valor, String ers) {
        ensureValidToken(); // Asegurarse de que el token sea válido
        String ruta = String.format("%s/%s/detalle", servicesPath, id);
        return webClient.post()
                .uri(uriBuilder -> uriBuilder
                        .path(ruta)
                        .queryParam("valor", valor)
                        .queryParam("ers", ers)
                        .build())
                .bodyValue(agencyDTO)
                .header(AUTHORIZATION, BEARER + token)
                .header(X_API_KEY, valueApiKey)
                .retrieve()
                .bodyToMono(DetalleReciboResponseDTO.class)
                .block();
    }

    private SimulacionPagoResponseDTO simularPagoAgente(SimulacionPagoRequestDTO simulacionPagoRequestDTO) {
        ensureValidToken(); // Asegurarse de que el token sea válido
        return webClient.post()
                .uri(pagosSimulacionPath)
                .bodyValue(simulacionPagoRequestDTO)
                .header(AUTHORIZATION, BEARER + token)
                .header(X_API_KEY, valueApiKey)
                .retrieve()
                .bodyToMono(SimulacionPagoResponseDTO.class)
                .block();
    }

    private PagoServicioRequestDTO pagoServicioAgente(SimulacionPagoRequestDTO simulacionPagoRequestDTO) {
        ensureValidToken(); // Asegurarse de que el token sea válido
        return webClient.post()
                .uri(pagosServiciosPath)
                .bodyValue(simulacionPagoRequestDTO)
                .header(AUTHORIZATION, BEARER + token)
                .header(X_API_KEY, valueApiKey)
                .retrieve()
                .bodyToMono(PagoServicioRequestDTO.class)
                .block();
    }

    private ExtornarResponseDTO extornarAgente(ExtornarRequestDTO extornarRequestDTO) {
        ensureValidToken(); // Asegurarse de que el token sea válido
        return webClient.post()
                .uri(pagosExtornarPath)
                .bodyValue(extornarRequestDTO)
                .header(AUTHORIZATION, BEARER + token)
                .header(X_API_KEY, valueApiKey)
                .retrieve()
                .bodyToMono(ExtornarResponseDTO.class)
                .block();
    }

    public ServiceResponseDTO obtenerServicios(String nombre) {
        return this.obtenerServiciosAgente(nombre);
    }

    public DetalleServiceResponseDTO obtenerDetalleServicios(String id) {
        return this.obtenerDetalleServiciosAgente(id);
    }

    public DetalleReciboResponseDTO obtenerDetalleRecibo(AgencyDTO agencyDTO, String id, String valor, String ers) {
        return this.obtenerDetalleReciboAgente(agencyDTO, id, valor, ers);
    }

    public SimulacionPagoResponseDTO simularPago(SimulacionPagoRequestDTO simulacionPagoRequestDTO) {
        System.out.println(this.simularPagoAgente(simulacionPagoRequestDTO));
        return this.simularPagoAgente(simulacionPagoRequestDTO);
    }

    public PagoServicioRequestDTO pagoServicio(SimulacionPagoRequestDTO simulacionPagoRequestDTO) {
        return this.pagoServicioAgente(simulacionPagoRequestDTO);
    }

    public ExtornarResponseDTO extonar(ExtornarRequestDTO extornarRequestDTO) {
        return this.extornarAgente(extornarRequestDTO);
    }
}
