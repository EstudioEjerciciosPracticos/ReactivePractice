package co.com.bancolombia.consumer;

import co.com.bancolombia.model.exceptions.BusinessException;
import co.com.bancolombia.model.exceptions.TechnicalException;
import co.com.bancolombia.model.statusaccount.StatusAccount;
import co.com.bancolombia.model.statusaccount.gateways.StatusAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import static co.com.bancolombia.model.exceptions.message.BusinessErrorMessge.ACCOUNT_FIND_ERROR;
import static co.com.bancolombia.model.exceptions.message.TechnicalErrorMessage.INTERNAL_SERVER_ERROR;

@Service
@RequiredArgsConstructor
public class RestConsumer implements StatusAccountService {
    private final WebClient client;


    @Override
    public Mono<StatusAccount> getStatus(String id) {
        return client
                .get()
                .uri("/mock/prueba3/{id}", id)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, clientResponse -> Mono.error( new BusinessException(ACCOUNT_FIND_ERROR)))
                .onStatus(HttpStatusCode::is5xxServerError, clientResponse -> Mono.error( new TechnicalException(INTERNAL_SERVER_ERROR)))
                .bodyToMono(StatusAccountDto.class)
                .map( dto -> StatusAccount.builder().status(dto.getStatus()).build());
    }

// Possible fallback method
//    public Mono<String> testGetOk(Exception ignored) {
//        return client
//                .get() // TODO: change for another endpoint or destination
//                .retrieve()
//                .bodyToMono(String.class);
//    }

/*    @CircuitBreaker(name = "testPost") // This name should match with settings name in application.yaml
    public Mono<ObjectResponse> testPost() {
        ObjectRequest request = ObjectRequest.builder()
            .val1("exampleval1")
            .val2("exampleval2")
            .build();
        return client
                .post()
                .body(Mono.just(request), ObjectRequest.class)
                .retrieve()
                .bodyToMono(ObjectResponse.class);
    }*/
}
