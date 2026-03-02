package co.com.bancolombia.model.exceptions.message;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TechnicalErrorMessage {

    API_INTERNAL_ERROR ("MST001","An internal controlled error has occurred in the API server."),
    ERROR_CONSUMING_DATABASE ("MST002","Error consuming database."),
    INTERNAL_SERVER_ERROR ("MST003","Internal server error. Please try again later. "),
    API_TIMEOUT ("MST004","API did not respond in expected time.");

    private final String code;
    private final String message;

}
