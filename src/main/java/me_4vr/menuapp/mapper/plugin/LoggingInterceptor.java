package me_4vr.menuapp.mapper.plugin;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

@Intercepts({
  @Signature(
      type = Executor.class,
      method = "query",
      args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})
})
public class LoggingInterceptor implements Interceptor {

  Logger logger = LoggerFactory.getLogger(LoggingInterceptor.class);

  @Override
  public Object intercept(Invocation invocation) throws Throwable {
    MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
    logger.info(
        "source sql : {}",
        mappedStatement.getSqlSource().getBoundSql(invocation.getArgs()[1]).getSql());
    return invocation.proceed();
  }

  @Override
  public void setProperties(Properties properties) {
    logger.info("plugin properties : {}", properties.toString());
  }
}
