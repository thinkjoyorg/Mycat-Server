package org.opencloudb.util;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by xjli on 16-1-16.
 */
public class ZkIpUtil {


    private final static String domain = "mc.zk.thinkjoy.cn";

    public static String zkIp() {
        try {
            return InetAddress.getByName(domain).getHostAddress();
        } catch (UnknownHostException e) {
            return null;
        }

    }
}
