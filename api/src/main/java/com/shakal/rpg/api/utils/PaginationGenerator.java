package com.shakal.rpg.api.utils;

import java.util.List;

import org.springframework.data.domain.Page;

import com.shakal.rpg.api.dto.filter.CustomPage;

public class PaginationGenerator {
	public static CustomPage<?> convertPage(Page inputPage){
		CustomPage result = new CustomPage();
				result.setElements(inputPage.getContent());
				result.setCurrentPageNumber(inputPage.getNumber() +1);
				result.setTotalOfPages(inputPage.getTotalPages());
				result.setSize(inputPage.getSize());
				result.setFirst(inputPage.isFirst());
				result.setLast(inputPage.isLast());
				
		return result;
	}
	public static CustomPage<?> convertPage(Page inputPage, List<Object> elements){
		CustomPage result = new CustomPage();
		result.setElements(elements);
		result.setCurrentPageNumber(inputPage.getNumber() +1);
		result.setTotalOfPages(inputPage.getTotalPages() +1);
		result.setSize(inputPage.getSize());
		result.setFirst(inputPage.isFirst());
		result.setLast(inputPage.isLast());
		
		return result;

	}
	public static CustomPage<?> createPage(List elements){
		CustomPage result = new CustomPage();
		result.setElements(elements);
		result.setSize(elements.size());
		
		return result;
	}

}
