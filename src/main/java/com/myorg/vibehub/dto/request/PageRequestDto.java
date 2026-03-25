package com.myorg.vibehub.dto.request;

import com.myorg.vibehub.enums.PageCatagory;
import lombok.Data;

@Data
public class PageRequestDto {


    // This is the data that control layer is going to receive from the client

    private String name;
    private PageCatagory pageCatagory;
    private String Description;
    private String password;
}
