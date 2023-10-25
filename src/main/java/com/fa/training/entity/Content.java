package com.fa.training.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Entity
@Table(name = "content")
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Content {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;


    @Column(name ="title")
    private String  title;

    @Column(name = "brief")
    private String brief ;

    @Column(name = "content")
    private String content;

    @Column(name = "create_date")
    private LocalDateTime createDate;

    @Column(name = "update_date")
    private LocalDateTime  updateDate;

    @Column(name = "sort")
    private String sort;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Member member;


    @Transient
    private Long authorId;


    @Transient
    public void setAuthorId(Long id){
        this.authorId = id;
    }


    @Transient
    private Long getAuthorId(){
        return member.getId();
    }

    @Transient
    public String getFormatCreateDate(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MMMM/yyyy HH:mm", Locale.ENGLISH);
        return getCreateDate().format(formatter);
    }
    @Transient
    public String getFormatUpdateDate(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MMMM/yyyy HH:mm", Locale.ENGLISH);
        return getUpdateDate().format(formatter);

    }
}
