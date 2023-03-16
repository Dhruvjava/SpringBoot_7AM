package com.cb.gen;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class MyCustomGenerator implements IdentifierGenerator {
    @Override
    public Object generate(SharedSessionContractImplementor session, Object object)
                    throws HibernateException {
        String pref = "DHRUV-K-";
        int rnd = new Random().nextInt();
        rnd = Math.abs(rnd);
        String dt = new SimpleDateFormat("ddMMMyy").format(new Date());
        return pref+dt+":"+rnd;
    }
}
