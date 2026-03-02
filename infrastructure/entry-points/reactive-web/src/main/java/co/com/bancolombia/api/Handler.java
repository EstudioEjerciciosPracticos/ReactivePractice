package co.com.bancolombia.api;

import co.com.bancolombia.api.dto.RegisterAccountReqDto;
import co.com.bancolombia.model.account.Account;
import co.com.bancolombia.usecase.registeraccount.RegisterAccountUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class Handler {

    private final RegisterAccountUseCase registerAccountUseCase;

    public Mono<ServerResponse> listenGETUseCase(ServerRequest serverRequest) {

        return serverRequest.bodyToMono(RegisterAccountReqDto.class)
                .flatMap(request -> registerAccountUseCase.register(request.getName(), request.getStatusId()))
                .flatMap(account -> ServerResponse.ok().bodyValue(account));

    }

    public Mono<ServerResponse> listenGETOtherUseCase(ServerRequest serverRequest) {
        // useCase2.logic();
        return ServerResponse.ok().bodyValue("");
    }

    public Mono<ServerResponse> listenPOSTUseCase(ServerRequest serverRequest) {
        // useCase.logic();
        return ServerResponse.ok().bodyValue("");
    }
}
