package com.ssafy.ws.util;

import java.util.HashMap;
import java.util.Map;

public class Pagination {

	private int totalItemCount;
	private int itemsPerPage, pagesPerGroup;
	private int currentPage;

	private int currentPageFirstItem;
	private int currentPageLastItem;
	private int offset;
	private int limit;
	
	private int totalPageCount;
	private int firstPage;
	private int lastPage;
	private int previousPage;
	private int nextPage;
	private int previousFivePage;
	private int nextFivePage;

	private int totalGroupCount;
	private int currentGroup;
	private int firstGroup;
	private int lastGroup;
	private int previousGroup;
	private int nextGroup;
	
	private int currentGroupFirstPage;
	private int currentGroupLastPage;
	private int nextGroupFirstPage;
	private int previousGroupLastPage;
	
	private boolean previousPageActivated;
	private boolean nextPageActivated;
	private boolean previousFivePageActivated;
	private boolean nextFivePageActivated;
	private boolean previousGroupActivated;
	private boolean nextGroupActivated;
	private boolean firstPageActivated;
	private boolean lastPageActivated;
	
	
	public Pagination(int totalItemCount, int itemsPerPage, int pagesPerGroup, int currentPage) {

		this.totalItemCount = totalItemCount;
		this.itemsPerPage = itemsPerPage;
		this.pagesPerGroup = pagesPerGroup;
		this.currentPage = currentPage;
		
		this.currentPageFirstItem = (currentPage - 1) * itemsPerPage + 1;
		this.currentPageLastItem = (currentPage - 1) * itemsPerPage + itemsPerPage;
		
		this.offset = (currentPage - 1) * itemsPerPage;
		this.limit = itemsPerPage;
		
		this.totalPageCount = (totalItemCount - 1) / itemsPerPage + 1;
		this.firstPage = 1;
		this.lastPage = this.totalPageCount;
		this.previousPage = currentPage - 1;
		this.nextPage = currentPage + 1;		
		
		this.previousFivePage = currentPage - 5;
		this.nextFivePage = currentPage + 5;
		
		this.totalGroupCount = (this.totalPageCount - 1) / pagesPerGroup + 1;
		this.currentGroup = (currentPage - 1) / pagesPerGroup  + 1;
		this.firstGroup = 1;
		this.lastGroup = this.totalGroupCount;
		this.previousGroup = this.currentGroup - 1;
		this.nextGroup = this.currentGroup + 1;
		
		this.currentGroupFirstPage = (this.currentGroup - 1) * pagesPerGroup + 1;
		this.currentGroupLastPage = (this.currentGroup - 1) * pagesPerGroup + pagesPerGroup;
		this.currentGroupLastPage = Math.min(this.currentGroupLastPage, this.lastPage);
		
		this.nextGroupFirstPage = (this.nextGroup - 1) * pagesPerGroup + 1;
		this.previousGroupLastPage = (this.previousGroup - 1) * pagesPerGroup + pagesPerGroup;

		
		
		this.previousPageActivated = this.previousPage >= this.firstPage;
		this.nextPageActivated = this.nextPage <= this.lastPage;
		this.previousFivePageActivated = this.currentPage - 5 >= this.firstPage;
		this.nextFivePageActivated = this.currentPage + 5 <= this.lastPage;
		this.previousGroupActivated = this.previousGroup >= this.firstGroup;
		this.nextGroupActivated = this.nextGroup <= this.lastGroup;
		this.firstPageActivated = this.firstPage != this.currentPage;
		this.lastPageActivated = this.lastPage != this.currentPage;
	}
	
	public Map<String, String> getMap(){
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("currentGroupFirstPage", String.valueOf(this.currentGroupFirstPage));
		map.put("currentGroupLastPage", String.valueOf(this.currentGroupLastPage));
		
		map.put("firstPage", String.valueOf(this.firstPage));
		map.put("lastPage", String.valueOf(this.lastPage));
		map.put("previousPage", String.valueOf(this.previousPage));
		map.put("nextPage", String.valueOf(this.nextPage));
		
		map.put("nextGroupFirstPage", String.valueOf(this.nextGroupFirstPage));
		map.put("previousGroupLastPage", String.valueOf(this.previousGroupLastPage));
		map.put("nextFivePage", String.valueOf(this.nextFivePage));
		map.put("previousFivePage", String.valueOf(this.previousFivePage));
		
		map.put("previousPageActivated", String.valueOf(this.previousPageActivated));
		map.put("nextPageActivated", String.valueOf(this.nextPageActivated));
		map.put("previousFivePageActivated", String.valueOf(this.previousFivePageActivated));
		map.put("nextFivePageActivated", String.valueOf(this.nextFivePageActivated));
		map.put("previousGroupActivated", String.valueOf(this.previousGroupActivated));
		map.put("nextGroupActivated", String.valueOf(this.nextGroupActivated));
		map.put("firstPageActivated", String.valueOf(this.firstPageActivated));
		map.put("lastPageActivated", String.valueOf(this.lastPageActivated));
		
		return map;
	}
	
	public int getOffset() {
		return offset;
	}

	public int getLimit() {
		return limit;
	}	

	public int getCurrentPageFirstItem() {
		return currentPageFirstItem;
	}

	public int getCurrentPageLastItem() {
		return currentPageLastItem;
	}

	public int getTotalPageCount() {
		return totalPageCount;
	}

	public int getFirstPage() {
		return firstPage;
	}

	public int getLastPage() {
		return lastPage;
	}

	public int getPreviousPage() {
		return previousPage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public int getCurrentGroup() {
		return currentGroup;
	}

	public int getFirstGroup() {
		return firstGroup;
	}

	public int getLastGroup() {
		return lastGroup;
	}

	public int getPreviousGroup() {
		return previousGroup;
	}

	public int getNextGroup() {
		return nextGroup;
	}

	public int getCurrentGroupFirstPage() {
		return currentGroupFirstPage;
	}

	public int getCurrentGroupLastPage() {
		return currentGroupLastPage;
	}

	public int getNextGroupFirstPage() {
		return nextGroupFirstPage;
	}

	public int getPreviousGroupLastPage() {
		return previousGroupLastPage;
	}

	public boolean isPreviousPageActivated() {
		return previousPageActivated;
	}

	public boolean isNextPageActivated() {
		return nextPageActivated;
	}

	public boolean isPreviousFivePageActivated() {
		return previousFivePageActivated;
	}

	public boolean isNextFivePageActivated() {
		return nextFivePageActivated;
	}

	public boolean isPreviousGroupActivated() {
		return previousGroupActivated;
	}

	public boolean isNextGroupActivated() {
		return nextGroupActivated;
	}

	public boolean isFirstPageActivated() {
		return firstPageActivated;
	}

	public boolean isLastPageActivated() {
		return lastPageActivated;
	}
	
}
