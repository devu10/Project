package test.com.smarttravelcompanion.service;

import test.com.smarttravelcompanion.data.Channel;

/**
 * Created by devu on 2/6/2016.
 */
public interface WeatherServiceCallback {
    void serviceSuccess(Channel channel);

    void serviceFailure(Exception exception);
}
