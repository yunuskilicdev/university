package com.kilic.yunus.university.mapper;

import com.kilic.yunus.university.data.SearchDto;
import com.kilic.yunus.university.data.model.Professor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SearchMapper {

    SearchDto professorDto(Professor professor);
}
