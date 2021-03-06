package com.memory.mina.client;

import com.memory.mina.entity.IMMessage;
import com.memory.mina.entity.SysMessage;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Auther: cui.Memory
 * @Date: 2018/11/19 0019 13:51
 * @Description:
 */
public class MinaClientHandler extends IoHandlerAdapter {
    private static final Logger logger = LoggerFactory.getLogger(MinaClientHandler.class);

    @Override
    public void sessionCreated(IoSession session) throws Exception {
        super.sessionCreated(session);
    }

    @Override
    public void sessionOpened(IoSession session) throws Exception {
        super.sessionOpened(session);
    }

    @Override
    public void sessionClosed(IoSession session) throws Exception {
        super.sessionClosed(session);
    }

    @Override
    public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
        super.sessionIdle(session, status);
    }

    @Override
    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
        logger.info("client-exceptionCaught");
        super.exceptionCaught(session, cause);
    }

    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
        super.messageReceived(session, message);
        if(message instanceof IMMessage){
            logger.info("IMMessage: {}", ((IMMessage)message).getContent());
        }else if(message instanceof SysMessage){
            logger.info("SysMessage: {}", ((SysMessage)message).getContent());
        }else {
            logger.info("heartbeat: {}", message.toString());
        }
    }

    @Override
    public void messageSent(IoSession session, Object message) throws Exception {
        super.messageSent(session, message);
    }
}
