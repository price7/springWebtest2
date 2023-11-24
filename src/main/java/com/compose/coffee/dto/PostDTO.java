package com.compose.coffee.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PostDTO {

    int postNumber;
    String title;
    String writer;
    String contents;
    String postDate;
    int views;
}
