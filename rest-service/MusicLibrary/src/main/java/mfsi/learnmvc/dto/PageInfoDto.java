package mfsi.learnmvc.dto;

import org.springframework.data.domain.Sort;

public class PageInfoDto {

	private Integer page;
	
	private Integer size;
	
	private String sort;
	
	private Sort.Direction order;
}
