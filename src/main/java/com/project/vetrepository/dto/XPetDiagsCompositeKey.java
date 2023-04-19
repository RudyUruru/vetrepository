package com.project.vetrepository.dto;

import java.io.Serializable;

public class XPetDiagsCompositeKey implements Serializable {
    private Long pet;
    private Long visit;
    private Long diagnosis;
}
