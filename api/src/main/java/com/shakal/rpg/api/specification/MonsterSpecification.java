package com.shakal.rpg.api.specification;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.shakal.rpg.api.model.Monster;

public class MonsterSpecification {
	
	public static Specification<Monster> searchMonster(String search){
		
		return new Specification<Monster>() {
			@Override
			public Predicate toPredicate(Root<Monster> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				List<Monster> predicates = new ArrayList<Monster>();
				
				predicates.add((Monster) criteriaBuilder.or(criteriaBuilder.like(root.get("name"),"%" + search + "%")));
				return criteriaBuilder.or(predicates.toArray(new Predicate[predicates.size()]));
			}
		};
	}

}
