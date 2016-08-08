package com.wmblog.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by wangjunling on 2016/8/5.
 */
@Controller("article")
public class ArticleController
{
    private Logger logger = LoggerFactory.getLogger(ArticleController.class);

    @RequestMapping("/detail/{id}")
    public String detail(@PathVariable Long id, Model model)
    {
        Path path = Paths.get("res/article1.md");
        try (BufferedReader reader = Files.newBufferedReader(path); Stream<String> lines = reader.lines())
        {
            String article = lines.map(String::valueOf).collect(Collectors.joining("\n"));
            model.addAttribute("article", article);
        }
        catch (IOException e)
        {
            logger.error("read article error!", e);
        }

        return "detail";
    }
}
