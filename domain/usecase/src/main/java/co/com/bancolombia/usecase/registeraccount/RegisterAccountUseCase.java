package co.com.bancolombia.usecase.registeraccount;

import co.com.bancolombia.model.account.Account;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RequiredArgsConstructor
public class RegisterAccountUseCase {

    public Mono<Account> register(String name, String statusId){

        return legalValidation(name)
                .flatMap(legal -> disponibilityValidation())
                .flatMap(disponibility -> getStatus(name))
                .map(status -> Account.newAccount(0, name, status))
                .flatMap(this::finalValidation)
                .flatMap(this::saveAccount);


    }


    private Mono<String> legalValidation(String accountName) {
        return Mono.just(accountName).delayElement(Duration.ofSeconds(2));
    }


    private Mono<Integer> disponibilityValidation() {
            return Mono.just(9).delayElement(Duration.ofSeconds(2));
    }


    private Mono<String> getStatus(String accountName) {
        return Mono.just("OK");
    }

    private Mono<Account> finalValidation(Account account) {
        return Mono.just(account);
    }


    private Mono<Account> saveAccount(Account account) {
        return Mono.just(account);
    }
}
