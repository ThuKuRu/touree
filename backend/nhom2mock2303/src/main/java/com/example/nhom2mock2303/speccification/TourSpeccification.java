package com.example.nhom2mock2303.speccification;


import com.example.nhom2mock2303.entity.Tour;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;


public class TourSpeccification implements Specification<Tour> {
	
	private String field;
	private String operator;
	private Object value;
	
	@Override
	public Predicate toPredicate(Root<Tour> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
		if (operator.equals("LIKE")) {
			if (field.equals("tour")) {
				
				return criteriaBuilder.like(root.get(field).get("name"), "%" + value.toString() + "%");
			} else {
				
				return criteriaBuilder.like(root.get(field), "%" + value.toString() + "%");
			}
			
		}
		return null;
	}
	
	public TourSpeccification(String field, String operator, Object value) {
		super();
		this.field = field;
		this.operator = operator;
		this.value = value;
	}
	
}
