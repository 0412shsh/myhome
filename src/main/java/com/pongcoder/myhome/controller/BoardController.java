package com.pongcoder.myhome.controller;

import com.pongcoder.myhome.model.Board;
import com.pongcoder.myhome.repository.BoardRepository;
import com.pongcoder.myhome.validator.BoardValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private BoardValidator boardValidator;

    @GetMapping("/list")
    public String list(Model model){
        List<Board> boards = boardRepository.findAll(); // 데이터를 다 가져올 수 있음
        model.addAttribute("boards",boards);

        return "board/list";
    }

    @GetMapping("/form")
    public String form(Model model, @RequestParam(required = false) Long id){
        if(id == null) {
            // 새 보드 클래스를 생성해서 form에 넘겨주기
            model.addAttribute("board", new Board());
        } else {
            //id값이 있을경우 board를 넘겨줄건데 이 board는 조회해와야함
            Board board = boardRepository.findById(id).orElse(null); // 키값을 기준으로 찾을 수 있는 메서드, 조회된 값이 없을 경우 null로 주기
            model.addAttribute("board",board);
        }
        return "board/form";
    }

    @PostMapping("/form")
    public String greetingSubmit(@Valid Board board, BindingResult bindingResult) {
       boardValidator.validate(board,bindingResult);
        if (bindingResult.hasErrors()) {
            return "board/form";
        }
        boardRepository.save(board);
        return "redirect:/board/list"; // 저장후 이동할 페이지, 리다이렉트로 보내버리기
    }
}
