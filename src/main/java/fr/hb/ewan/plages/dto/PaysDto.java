package fr.hb.ewan.plages.dto;

import javax.validation.constraints.Size;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@Data
@FieldDefaults(level=AccessLevel.PRIVATE)
public class PaysDto {

    @Size(min=2, max=2, message="Le code du pays doit comporter au minimum {min} caractères")
    String code;

    @Size(min=2, max=2, message="Le nom du pays doit comporter au minimum {min} caractères")
    String nom;
}