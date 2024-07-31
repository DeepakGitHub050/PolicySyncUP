package com.dksapp.policysyncup.Controller.DTOs;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class IncEnvPol {
    private String incident;
    private String env;
    private List<String> policies;
}
