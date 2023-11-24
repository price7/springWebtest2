package com.compose.coffee.control;

import com.compose.coffee.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
public class BoardController {

    @Autowired
    PostService postService;

    @GetMapping("board")
    public String board(Model model, @RequestParam(name = "page", defaultValue = "1")int page) {

        // 페이지당 게시물 수
        int pageSize = 10;

        // 현재 페이지에 해당하는 시작 번호 계산
        int startNo = (page - 1) * pageSize + 1;

        // 현재 페이지에 해당하는 끝 번호 계산
        int endNo = startNo + pageSize - 1;

        log.info("StartNo: " + startNo);
        log.info("EndNo: " + endNo);

        log.info(page + " : 현재 페이지");

        model.addAttribute("board", postService.selectAll(startNo, endNo));

        //////

        // 총 게시물의 수
        int totalPost = postService.countAll();
        
        log.info(totalPost + " : 총 게시물의 수");


        // 총 페이지의 수
        int totalPage = totalPost/pageSize;
        
        log.info(totalPage + " : 총 페이지의 수");

        model.addAttribute("totalPost", totalPost);
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("currentPage", page);

        return "board";
    }
}
