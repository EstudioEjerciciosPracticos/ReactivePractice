package co.com.bancolombia.api.dto;

import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Builder;

@NoArgsConstructor
@Getter
public class RegisterAccountReqDto {

    private String name;
    private String statusId;


}
