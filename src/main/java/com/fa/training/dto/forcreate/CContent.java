package com.fa.training.dto.forcreate;

import com.fa.training.entity.Member;
import lombok.*;

import java.time.LocalDateTime;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CContent {


    private String title;
    private String brief;
    private String content;
    private LocalDateTime createDate;
    private Long authorId;

}
