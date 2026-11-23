package com.retheviper.springbootsample.application.dto.board;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * Board article DTO class.
 *
 * @author retheviper
 */
@Data
public class ArticleDto {

    /**
     * Article's ID
     */
    private long id;

    /**
     * Article's title
     */
    private String title;

    /**
     * Article's content
     */
    private String content;

    /**
     * Board that this article belongs
     */
    private BoardDto board;

    /**
