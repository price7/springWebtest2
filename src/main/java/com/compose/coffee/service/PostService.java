package com.compose.coffee.service;

import com.compose.coffee.dao.PostDAO;
import com.compose.coffee.dto.PostDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {


    @Autowired
    PostDAO postDAO;

    public List<PostDTO> selectAll(int startNo, int endNo) {return postDAO.selectAll(startNo, endNo);};

    public int countAll() {return postDAO.countAll();};

}
