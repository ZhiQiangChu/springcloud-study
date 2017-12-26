package com.zzf.filter;

import com.netflix.zuul.ZuulFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: zzf
 * @date: 2017/12/26
 * @time: 11:50
 * @description : do some thing
 */
@Component
public class ThrowExceptionFilter extends ZuulFilter {

    private static Logger log = LoggerFactory.getLogger(ThrowExceptionFilter.class);

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 2;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {

        // This is a pre filter, it will throw a RuntimeException
        log.info("This is a pre filter, it will throw a RuntimeException");
        return null;
    }

    private void doSomeThing(){
        throw new RuntimeException("Exist some errors ...");
    }
}
