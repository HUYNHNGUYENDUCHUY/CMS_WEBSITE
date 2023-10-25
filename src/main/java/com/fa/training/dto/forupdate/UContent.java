package com.fa.training.dto.forupdate;


import com.fa.training.entity.Member;
import lombok.*;

import java.time.LocalDateTime;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class UContent {

    private Long id;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private String title;
    private String brief;
    private String content;
    private Long authorId;
}
