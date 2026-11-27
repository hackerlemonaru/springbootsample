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
     * Board service
     */
    private final BoardService boardService;

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public List<CategoryDto> listCategory(final long boardId) {
        return StreamSupport.stream(this.repository.findByBoardIdIs(boardId).spliterator(), false)
                .map(this::createDto)
                .collect(Collectors.toList());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public CategoryDto getCategory(final CategoryDto dto) {
        return createDto(getEntity(dto.getId()));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public CategoryDto createCategory(final CategoryDto dto) {
        checkAlreadyExists(dto);
        return save(this.mapper.map(dto, Category.class));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public CategoryDto updateCategory(final CategoryDto dto) {
        checkExists(dto.getId());
        checkAlreadyExists(dto);
        dto.setBoard(this.boardService.getBoard(dto.getBoard()));
        final Category entity = getEntity(dto.getId());
        this.mapper.map(dto, entity);
        return save(entity);
    }

    /**
     * {@inheritDoc}
     */
    public void checkExists(final long id) {
        if (!this.repository.existsById(id)) {
            throw new BoardException(BoardExceptionMessage.E003.getValue());
        }
