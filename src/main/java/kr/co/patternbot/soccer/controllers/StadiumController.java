package kr.co.patternbot.soccer.controllers;

import kr.co.patternbot.soccer.services.StadiumService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stadium")
public class StadiumController {
    private final StadiumService service;
}
