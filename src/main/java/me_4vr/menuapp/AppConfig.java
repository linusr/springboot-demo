package me_4vr.menuapp;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.convert.DataSizeUnit;
import org.springframework.boot.convert.DurationUnit;
import org.springframework.util.unit.DataSize;
import org.springframework.util.unit.DataUnit;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

@Validated
@ConfigurationProperties("app")
public class AppConfig {

    /**
     * URL of the database server.
     * The Default value is jdbc://.
     * The allowed values are valid JDBC string.
     */
    @NotNull
    @NotEmpty
    private String dbURL;

    @NotNull
    @DurationUnit(ChronoUnit.SECONDS)
    private Duration sessionTimeout = Duration.ofSeconds(30);

    @NotNull
    @DataSizeUnit(DataUnit.MEGABYTES)
    private DataSize maxSize = DataSize.ofMegabytes(2);


    public String getDbURL() {
        return dbURL;
    }

    public Duration getSessionTimeout() {
        return sessionTimeout;
    }

    public DataSize getMaxSize() {
        return maxSize;
    }

    public void setDbURL(String dbURL) {
        this.dbURL = dbURL;
    }

    public void setSessionTimeout(Duration sessionTimeout) {
        this.sessionTimeout = sessionTimeout;
    }

    public void setMaxSize(DataSize maxSize) {
        this.maxSize = maxSize;
    }
}
