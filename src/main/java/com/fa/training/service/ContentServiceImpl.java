package com.fa.training.service;

import com.fa.training.dto.forcreate.CContent;
import com.fa.training.dto.forupdate.UContent;
import com.fa.training.dto.list.LiContent;
import com.fa.training.entity.Content;
import com.fa.training.entity.Member;
import com.fa.training.repository.IContentRepository;
import com.fa.training.service.templates.IContentService;
import com.fa.training.service.templates.IMemberService;
import com.fa.training.utils.ICheck;
import com.fa.training.utils.IGetData;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;


@Service
public class ContentServiceImpl implements IContentService {
    @Autowired
    private IContentRepository contentRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private IGetData getData;
    @Autowired
    private IMemberService memberService;

    @Override
    public List<LiContent> getAllByAuthorIdAndTitle(Long id ,String title) {
       return contentRepository.findAllByAuthorIdAndTitle(id,title);
    }

    @Override
    public void save(CContent contentDto) {
        contentDto.setCreateDate(LocalDateTime.now());
        Content content =modelMapper.map(contentDto, Content.class);
        content.setMember(modelMapper.map(memberService.getByUsername(getData.getUsernameFromContextHolder()),Member.class));
        contentRepository.save(content);
    }

    @Override
    public void save(UContent contentDto) {
        contentRepository.save(modelMapper.map(contentDto, Content.class));
    }

    @Override
    public List<LiContent> getByAuthorId(Long id) {
        return contentRepository.findAllByAuthorId(id);
    }

    @Override
    public UContent getById(Long id) {
        return modelMapper.map(contentRepository.findAllById(id),UContent.class);
    }

    @Override
    @Transactional
    public void updateById(UContent contentDto,Long id) {
        LocalDateTime dateTime = LocalDateTime.now();
        contentRepository.updateById(contentDto.getTitle(),contentDto.getBrief(),contentDto.getContent(),dateTime,id);
    }


}
