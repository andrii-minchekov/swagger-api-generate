package com.example.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Andrii Minchekov
 * @since 12/22/17.
 */

@Getter
@Setter
@AllArgsConstructor
@ApiModel
@NoArgsConstructor
public class Customer {
    @ApiModelProperty(notes = "The database generated product ID")
    private Integer id;
    @ApiModelProperty(notes = "Customer identification")
    @NotNull
    @Size(min=1, max=100)
    private String name;

    @ApiModelProperty(notes = "Customer age")
    @Min(1)
    @Max(150)
    private Integer age;

    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }
}