package com.retheviper.springbootsample.application.service.board;

import com.retheviper.springbootsample.application.dto.board.BoardDto;
import com.retheviper.springbootsample.common.constant.message.BoardExceptionMessage;
import com.retheviper.springbootsample.common.exception.BoardException;
import com.retheviper.springbootsample.domain.entity.board.Board;
import com.retheviper.springbootsample.domain.repository.board.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Board service class. (Implementation)
 *
 * @author retheviper
 */
