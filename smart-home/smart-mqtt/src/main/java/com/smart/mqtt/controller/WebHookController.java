package com.smart.mqtt.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Lico-Tom
 * 2024/3/22 0:13
 * @version V1.0
 */
@RestController
@RequestMapping("/v1/mqtt")
public class WebHookController {

    private final static Map<String, Boolean> CLIENT_STATUS = new HashMap<>();

    private final String CLIENT_ID = "clientid";

    private final String ACTION = "action";

    private final String CLIENT_CONNECTED_STATUS = "client_connected";

    private final String CLIENT_DISCONNECTED_STATUS = "client_disconnected";



    /**
     * connected
     * {
     *     "username": "foo",
     *     "ts": 1625572213873,
     *     "sockport": 1883,
     *     "proto_ver": 4,
     *     "proto_name": "MQTT",
     *     "keepalive": 60,
     *     "ipaddress": "127.0.0.1",
     *     "expiry_interval": 0,
     *     "connected_at": 1625572213873,
     *     "connack": 0,
     *     "clientid": "emqtt-8348fe27a87976ad4db3",
     *     "clean_start": true
     * }
     *
     * disconnected
     * {
     *     "username": "foo",
     *     "ts": 1625572213873,
     *     "sockport": 1883,
     *     "reason": "tcp_closed",
     *     "proto_ver": 4,
     *     "proto_name": "MQTT",
     *     "ipaddress": "127.0.0.1",
     *     "disconnected_at": 1625572213873,
     *     "clientid": "emqtt-8348fe27a87976ad4db3"
     * }
     * @param params
     */
    @PostMapping("/webhook")
    public void hook(@RequestBody Map<String, Object> params) {
        String clientid = (String) params.get(CLIENT_ID);
        String action = (String) params.get(ACTION);
        if (CLIENT_CONNECTED_STATUS.equals(action)) {
            CLIENT_STATUS.put(clientid, true);
        }
        if (CLIENT_DISCONNECTED_STATUS.equals(action)) {
            CLIENT_STATUS.put(clientid, false);
        }

    }
}
