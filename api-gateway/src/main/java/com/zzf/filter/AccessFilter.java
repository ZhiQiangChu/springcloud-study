package com.zzf.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: zzf
 * @date: 2017/12/25
 * @time: 19:34
 * @description : 网关过滤器
 */
@Component
public class AccessFilter extends ZuulFilter {

    private static Logger log = LoggerFactory.getLogger(AccessFilter.class);

    /**
     * 判断该过滤器是否需要被执行。
     * 这里我们直接返回了 true，
     * 因此该过滤器对所有请求都会生效
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * filterType：返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型，具体如下：
     * pre：路由之前
     * routing：路由之时
     * post： 路由之后
     * error：发送错误调用
     * filterOrder：过滤的顺序
     * shouldFilter：这里可以写逻辑判断，是否要过滤，本文true,永远过滤。
     * run：过滤器的具体逻辑。可用很复杂，包括查sql，nosql去判断该请求到底有没有权限访问
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 这个方法是标志多个过滤器的执行的顺序
     * @return
     */
    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public Object run() {

        /**
         * 获取当前的上下文
         */
        RequestContext ctx  = RequestContext.getCurrentContext();
        HttpServletRequest request= ctx.getRequest();

        log.info("send {} request to {}",request.getMethod(),request.getRequestURL().toString());
        String accessToken = request.getParameter("accessToken");

        if(accessToken == null && accessToken != ""){

            log.warn("access token is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            return null;
        }

        // 有token 就会路由到相关的服务上去
        log.info("access token ok");
        return null;
    }
}
