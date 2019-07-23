package com.shakal.rpg.api.specification;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Join;


import org.springframework.data.jpa.domain.Specification;

import com.shakal.rpg.api.model.Monster;
import com.shakal.rpg.api.model.MonsterRace;

public class MonsterSpecification {
	
	public static Specification<Monster> searchMonster(String search){
		
		return new Specification<Monster>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<Monster> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				List<Predicate> predicates = new ArrayList<Predicate>();
				
				Join<Monster,MonsterRace> raceJoin = root.join("race");
				
				predicates.add( criteriaBuilder.or(criteriaBuilder.like(raceJoin.get("name"),"%" + search + "%")));
				return criteriaBuilder.or(predicates.toArray(new Predicate[predicates.size()]));
			}
		};
	}

}
