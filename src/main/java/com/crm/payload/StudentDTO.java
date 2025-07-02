package com.crm.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDTO {
    private Long id;
    private String name;
    private String email;
    private String mobile;
}
