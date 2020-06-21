package com.demogradle.gradledemo.generators;

import java.io.Serializable;
import java.util.Properties;
import java.util.stream.Stream;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.Configurable;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;

public class CustomSequenceGenerator implements IdentifierGenerator, Configurable {

	private String prefix;

	@Override
	public void configure(Type type, Properties params, ServiceRegistry serviceRegistry) throws MappingException {
		prefix = params.getProperty("prefix");

	}

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		String query = String.format("select %s  from %s",
				session.getEntityPersister(object.getClass().getName(), object).getIdentifierPropertyName(),
				object.getClass().getSimpleName());
		Stream stream = session.createQuery(query).list().stream();
		Long max = stream.map(x->x.toString().replaceAll(prefix + " - ", "")).mapToLong(x->Long.parseLong(x.toString())).max().orElse(0l);
		return prefix + " - " + (max + 1);
	}

}
