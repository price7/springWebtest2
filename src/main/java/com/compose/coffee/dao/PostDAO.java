package com.compose.coffee.dao;

import com.compose.coffee.dto.PostDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface PostDAO {

    List<PostDTO> selectAll(int startNo, int endNo);

    int countAll();

}
