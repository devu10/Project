package test.com.smarttravelcompanion.listener;

import test.com.smarttravelcompanion.data.Channel;

/**
 * Created by devu on 2/6/2016.
 */
public interface WeatherServiceListener {

    void serviceSuccess(Channel channel);

    void serviceFailure(Exception exception);
}
