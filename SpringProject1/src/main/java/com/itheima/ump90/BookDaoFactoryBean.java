package com.itheima.ump90;

import org.springframework.beans.factory.FactoryBean;

public class BookDaoFactoryBean implements FactoryBean<BookDao> {
  @Override
  public boolean isSingleton() {
    return FactoryBean.super.isSingleton();
  }

  @Override
  public BookDao getObject() throws Exception {
    System.out.println("BookDaoFactoryBean");
    return new BookDaoImp();
  }

  @Override
  public Class<?> getObjectType() {
    return BookDao.class;
  }
}
