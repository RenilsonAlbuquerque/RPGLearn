package com.shakal.rpg.api.dto.filter;

import java.util.List;

public class CustomPage<T> {

	private List<T> elements;
	private int currentPageNumber;
	private int totalOfPages;
	private int size;
	private boolean first;
	private boolean last;
	
	
	public List<T> getElements() {
		return elements;
	}
	public void setElements(List<T> elements) {
		this.elements = elements;
	}
	public int getCurrentPageNumber() {
		return currentPageNumber;
	}
	public void setCurrentPageNumber(int currentPageNumber) {
		this.currentPageNumber = currentPageNumber;
	}
	public int getTotalOfPages() {
		return totalOfPages;
	}
	public void setTotalOfPages(int totalOfPages) {
		this.totalOfPages = totalOfPages;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public boolean isFirst() {
		return first;
	}
	public void setFirst(boolean first) {
		this.first = first;
	}
	public boolean isLast() {
		return last;
	}
	public void setLast(boolean last) {
		this.last = last;
	}
	
	
	
}
