package com.retheviper.springbootsample.application.service.board;

import com.retheviper.springbootsample.application.dto.board.CommentDto;

import java.util.List;

/**
 * Article comment service class.
 *
 * @author retheviper
 */
public interface CommentService {

    /**
     * Get list of comments.
     *
     * @return List of comment DTO
     */
    List<CommentDto> listComment(long articleId);

    /**
