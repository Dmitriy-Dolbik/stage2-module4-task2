package com.mjc.stage2;

import java.net.Proxy;

import com.mjc.stage2.impl.ConnectionPool;
import com.mjc.stage2.impl.ProxyConnection;
import com.mjc.stage2.impl.RealConnection;

public class Test
{
    public static void main(String[] args)
    {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection proxyConnection = connectionPool.getConnection();
        proxyConnection.close();
        System.out.println(connectionPool.getFreeConnectionsCount());


    }
}
