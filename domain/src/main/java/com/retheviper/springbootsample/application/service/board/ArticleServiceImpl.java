package com.retheviper.springbootsample.application.service.board;

import com.retheviper.springbootsample.application.dto.board.ArticleDto;
import com.retheviper.springbootsample.application.dto.board.CategoryDto;
import com.retheviper.springbootsample.common.constant.message.BoardExceptionMessage;
import com.retheviper.springbootsample.common.exception.BoardException;
import com.retheviper.springbootsample.domain.entity.board.Article;
import com.retheviper.springbootsample.domain.repository.board.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Board article service class. (Implementation)
 *
 * @author retheviper
 */
@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {

    /**
     * Data model converter
     */
    private final ModelMapper mapper;

    /**
     * Board article repository
     */
    private final ArticleRepository repository;

    /**
     * Board service
     */
    private final BoardService boardService;

    /**
     * Category service
     */
    private final CategoryService categoryService;

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public Page<ArticleDto> listArticle(final long boardId, final Pageable pageable) {
        return this.repository.findByBoardIdIs(pageable, boardId).map(this::createDto);
