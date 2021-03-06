package com.example.demo.controller;

import com.example.demo.model.DateListModel;
import com.example.demo.service.ReadFileService;
import com.example.demo.service.SetDateAndTimeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/input")
public class InputTextController {
    @Autowired
    SetDateAndTimeService setDateAndTimeService;

    @Autowired
    ReadFileService readFile;

    @RequestMapping(value="/inputTextFile", method=RequestMethod.POST)
    public Object inputTextFile(@RequestPart MultipartFile file){
        DateListModel json = readFile.ReadFile(file);
        return setDateAndTimeService.setDate(json);

    }

    @RequestMapping(value="/inputJson", method=RequestMethod.POST)
    public Object inputJson(@RequestBody DateListModel json){
        return setDateAndTimeService.setDate(json);
    }
}
