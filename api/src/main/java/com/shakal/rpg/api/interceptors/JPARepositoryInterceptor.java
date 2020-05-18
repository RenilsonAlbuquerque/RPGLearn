package com.shakal.rpg.api.interceptors;

import java.io.Serializable;
import java.time.LocalDateTime;



import org.hibernate.type.Type;
import org.springframework.stereotype.Component;
import org.hibernate.EmptyInterceptor; 
import com.shakal.rpg.api.model.BaseEntity;


@Component
public class JPARepositoryInterceptor extends EmptyInterceptor{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2237885467223054782L;

	@Override
	public boolean onSave(Object entity, Serializable id, 
	  Object[] state, String[] propertyNames, Type[] types) {
	     
		if(entity instanceof BaseEntity) {
			if(((BaseEntity) entity).getCreationDate() == null) {
				((BaseEntity) entity).setCreationDate(LocalDateTime.now());
			}
			((BaseEntity) entity).setLastUpdate(LocalDateTime.now());
		}
	    return super.onSave(entity, id, state, propertyNames, types);
	}
}
