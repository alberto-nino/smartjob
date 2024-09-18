package com.demo.smartjob.models.dto;

import com.demo.smartjob.validations.ValidEmail;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.SecondaryTable;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {

	private Long id;

	@NotEmpty(message = "The name could be not NULL VALUE or EMPTY VALUE")
	private String name;

	@NotEmpty(message = "The email could be not NULL VALUE or EMPTY VALUE")
	@ValidEmail
	private String email;

	@NotEmpty(message = "The password could be not NULL VALUE or EMPTY VALUE")
	private String password;

	private List<PhoneDTO> phones;
}
