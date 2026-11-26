package com.retheviper.springbootsample.application.service.board;

import com.retheviper.springbootsample.application.dto.board.CategoryDto;
import com.retheviper.springbootsample.common.constant.message.BoardExceptionMessage;
import com.retheviper.springbootsample.common.exception.BoardException;
import com.retheviper.springbootsample.domain.entity.board.Category;
import com.retheviper.springbootsample.domain.repository.board.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Article category service class. (Implementation)
 *
 * @author retheviper
 */
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    /**
     * Data model converter
     */
    private final ModelMapper mapper;

    /**
     * Category repository
     */
    private final CategoryRepository repository;

    /**
