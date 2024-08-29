package com.example.employeemanagement.controller.request;

import lombok.*;


@Builder()
@Data
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class EmployeePaginationDetails {

    @Builder.Default
    private int pageSize=-1;
    @Builder.Default
    private int pageNumber=-1;
    @Builder.Default
    private String sort="ASC";
    @Builder.Default
    private String sortDirection="id";

}
