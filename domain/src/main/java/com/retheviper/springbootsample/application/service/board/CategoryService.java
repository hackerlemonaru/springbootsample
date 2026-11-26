package com.retheviper.springbootsample.application.service.board;

import com.retheviper.springbootsample.application.dto.board.CategoryDto;

import java.util.List;

/**
 * Article category service class.
 *
 * @author retheviper
 */
public interface CategoryService {

    /**
     * Get list of categories.
     *
     * @param id board's ID
     * @return List of category DTO
     */
    List<CategoryDto> listCategory(long boardId);

    /**
     * Get single category by category DTO.
     *
     * @param dto Category DTO
     * @return Category DTO
     */
    CategoryDto getCategory(CategoryDto dto);

    /**
     * Create new category.
