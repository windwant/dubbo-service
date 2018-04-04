package org.dubbo.provider.filter;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.remoting.RemotingException;
import com.alibaba.dubbo.remoting.TimeoutException;
import com.alibaba.dubbo.rpc.Filter;
import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Result;
import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.dubbo.rpc.RpcException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by windwant on 2016/12/13.
 */
public class MyDubboFilter implements Filter {
    private static Logger logger = LoggerFactory.getLogger(MyDubboFilter.class);

    public void logFirst(Invocation invocation) {
        StringBuilder sb = new StringBuilder();
        sb.append("enter the " + invocation.getMethodName() + " method, args:[");
        if (invocation.getArguments() != null && invocation.getArguments().length > 0) {
            for (int i = 0; i < invocation.getArguments().length; i++) {
                String argValue = "";
                if (invocation.getArguments()[i] != null) {
                    if (invocation.getArguments()[i] instanceof String) {
                        argValue = (String) invocation.getArguments()[i];
                    }
                    if (invocation.getArguments()[i] instanceof Integer) {
                        int argValueInt = (Integer) invocation.getArguments()[i];
                        argValue = String.valueOf(argValueInt);
                    }
                    if (invocation.getArguments()[i] instanceof Double) {
                        double argValueInt = (Double) invocation.getArguments()[i];
                        argValue = String.valueOf(argValueInt);
                    }
                    if (i < invocation.getArguments().length - 1) {
                        sb.append(argValue + ",");
                    } else {
                        sb.append(argValue);
                    }
                }
            }
        }
        sb.append("].");
        logger.info(sb.toString());
    }

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        boolean isProvider = RpcContext.getContext().isProviderSide();
        URL url = invoker.getUrl();
        Result result = null;
        String loggerName = invoker.getInterface().getSimpleName() + "." + invocation.getMethodName();
        logger.info("dubbo.parameters",
                "application: " + url.getParameter(Constants.APPLICATION_KEY) +
                        ", version: " + url.getParameter(Constants.DUBBO_VERSION_KEY) +
                        "isProvider: " + isProvider +
                        "loggerName: " + loggerName);
        try {
            logFirst(invocation);
            result = invoker.invoke(invocation);
            if (result.hasException()) {
                // 给调用接口出现异常进行打点
                Throwable throwable = result.getException();
                logger.error("server exception occured1 ！ERROR ", throwable);
                if (RpcException.class == throwable.getClass()) {
                    Throwable caseBy = throwable.getCause();
                    if (caseBy != null && TimeoutException.class.isAssignableFrom(caseBy.getClass())) {
                       logger.error("DUBBO_TIMEOUT_ERROR", loggerName);
                    } else {
                        logger.error("DUBBO_REMOTING_ERROR", loggerName);
                    }
                } else if (RemotingException.class.isAssignableFrom(throwable.getClass())) {
                    logger.error("DUBBO_REMOTING_ERROR", loggerName);
                } else {
                    logger.error("DUBBO_BIZ_ERROR", loggerName);
                }
            } else {
                logLast(result, invocation);
            }
        } catch (Exception e) {
            logger.error("server exception occured ！ERROR ", e);
            throw e;
        }
        return result;
    }

    public void logLast(Result result, Invocation invocation) {
        StringBuilder sb = new StringBuilder();
        sb.append("left the " + invocation.getMethodName() + " method, result:[ ");
        if (result.getValue() != null) {
            sb.append("result: " + result.getValue());
        }
        sb.append("].");
        logger.info(sb.toString());
    }
}
