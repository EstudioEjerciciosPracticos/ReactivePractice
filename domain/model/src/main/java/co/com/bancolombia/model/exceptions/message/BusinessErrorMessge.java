package co.com.bancolombia.model.exceptions.message;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BusinessErrorMessge {

    INVALID_REQUEST("SFB0000", "Invalid reguest"),
    ACCOUNT_VALIDATION_ERROR("SFB0001", "Account validation error"),
    ACCOUNT_FIND_ERROR("SFB0002", "Account find error"),
    CHANNEL_TRANSACTION_NOT_FOUND("SFB0003", "Channel transaction not found");

    private final String code;
    private final String message;

}
