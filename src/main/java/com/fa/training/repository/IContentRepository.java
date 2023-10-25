package com.fa.training.repository;


import com.fa.training.dto.forcreate.CMember;
import com.fa.training.dto.forupdate.UContent;
import com.fa.training.dto.list.LiContent;
import com.fa.training.entity.Content;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface IContentRepository extends JpaRepository<Content, Long > {


    @Query("Select c From Content c where c.member.id =:id and c.title =:title")
    List<LiContent> findAllByAuthorIdAndTitle(Long id,String title);
    @Query("select c from Content c where c.member.id =:id")
    List<LiContent> findAllByAuthorId(Long id);
    Content findAllById(Long id);

    @Modifying
    @Query("update Content c set c.title =:title ,c.brief =:brief,c.content =:content," +
            "c.updateDate =:updateDate where c.id =:id")
    void updateById(String title, String brief, String content, LocalDateTime updateDate,Long id);


}
