package com.demo.smartjob.mapper;

import com.demo.smartjob.models.dto.PhoneDTO;
import com.demo.smartjob.models.dto.UserDTO;
import com.demo.smartjob.models.dto.UserResponseDTO;
import com.demo.smartjob.models.entity.Phone;
import com.demo.smartjob.models.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.factory.Mappers;
import java.time.Instant;
import java.util.List;
import java.util.UUID;


@Mapper(nullValueCheckStrategy  = NullValueCheckStrategy.ALWAYS,
        imports = {Instant.class})

public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper( UserMapper.class );

    @Mapping(target ="number" , source = "number")
    @Mapping(target ="cityCode" , source = "cityCode")
    @Mapping(target ="countryCode" , source = "countryCode")
    Phone phoneDTotoPhone(PhoneDTO phoneDTO);

    List<Phone> phoneToPhoneDTOList(List<PhoneDTO> phones);

    @Mapping(target = "token", constant = "12344")
    @Mapping(target = "isActive", expression = "java(true)")
    @Mapping(target = "lastLogin", expression = "java(Instant.now())")
    @Mapping(target = "created", expression = "java(Instant.now())")
    @Mapping(target = "modified", expression = "java(Instant.now())")
    @Mapping(target = "phones", source = "phones")
    User userDTOtoUser(UserDTO user);


   UserResponseDTO userToUserResponseDTO(User user);



}
