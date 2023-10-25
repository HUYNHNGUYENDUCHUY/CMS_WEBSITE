package com.fa.training.service.templates;

import com.fa.training.dto.forcreate.CContent;
import com.fa.training.dto.forupdate.UContent;
import com.fa.training.dto.list.LiContent;

import java.time.LocalDateTime;
import java.util.List;

public interface IContentService {

    List<LiContent> getAllByAuthorIdAndTitle(Long id ,String title);

    void save(CContent contentDto);
    void save(UContent contentDto);


    List<LiContent> getByAuthorId(Long id);

    UContent getById(Long id);

    void updateById(UContent contentDto,Long id);

}
