/*
信息:
*/
package yd.com.core.dao.imp;

import org.apache.poi.hssf.record.formula.functions.T;
import org.hibernate.Query;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import yd.com.core.dao.BaseDao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class BaseDaoImp<T> extends HibernateDaoSupport implements BaseDao<T> {
    Class<T> tClass;
    public BaseDaoImp(){
     ParameterizedType parameterizedType=(ParameterizedType)this.getClass().getGenericSuperclass();
     tClass=(Class<T>)parameterizedType.getActualTypeArguments()[0];
    }
    @Override
    public void save(T entity) {
       getHibernateTemplate().save(entity);
    }

    @Override
    public void update(T entity) {
      getHibernateTemplate().update(entity);
    }

    @Override
    public void deleteById(Serializable id) {
      getHibernateTemplate().delete(findById(id));
    }

    @Override
    public List<T> findAll() {
       Query query=currentSession().createQuery("FROM "+tClass.getSimpleName());
        return query.list();
    }

    @Override
    public T findById(Serializable id) {
        return getHibernateTemplate().get(tClass,id);
    }
}
