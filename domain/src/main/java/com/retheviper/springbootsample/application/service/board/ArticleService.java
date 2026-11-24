package com.retheviper.springbootsample.application.service.board;

import com.retheviper.springbootsample.application.dto.board.ArticleDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Board article service class.
 *
 * @author retheviper
 */
public interface ArticleService {

    /**
     * Get list of board articles.
     *
     * @param pageable pageable
     * @return List of board article DTO
     * @oaran boardId Board ID of article belongs
     */
    Page<ArticleDto> listArticle(long boardId, Pageable pageable);

    /**
     * Get list of board articles with keyword.
     * <p>
     * Search keword has several types as createdBy(author), title, content, category.
     *
     * @param boardId     Board ID of article belongs
