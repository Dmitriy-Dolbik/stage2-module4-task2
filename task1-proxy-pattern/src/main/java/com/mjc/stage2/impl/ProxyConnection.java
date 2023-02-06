package com.mjc.stage2.impl;


import com.mjc.stage2.Connection;

public class ProxyConnection implements Connection
{
    private RealConnection realConnection;
    private ConnectionPool connectionPool;
    private boolean isClosed = false;

    public ProxyConnection(RealConnection realConnection) {
        this.realConnection = realConnection;
        this.connectionPool = ConnectionPool.getInstance();
    }

    public void reallyClose() {
        realConnection.close();
    }

    @Override
    public void close()
    {
        if (!isClosed){
            connectionPool.releaseConnection(this);
            isClosed = true;
        }

    }

    @Override
    public boolean isClosed()
    {
        return realConnection.isClosed();
    }
}
