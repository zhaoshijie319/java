package net.netty.server;

import net.netty.model.Command;
import org.jboss.netty.channel.*;

public class ServerHandler extends SimpleChannelHandler {

    @Override
    public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
        System.out.println("channelConnected");
    }

    @Override
    public void channelDisconnected(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
        System.out.println("channelDisconnected");
    }

    @Override
    public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) throws Exception {
        if (e.getMessage() instanceof Command) {
            Command command = (Command) e.getMessage();
            System.out.println("对象:" + command.getActionName());
        }

        // 向客户端发送收到结果
        Command command = new Command();
        command.setActionName("Hello Client.");
        e.getChannel().write(command);
    }

    @Override
    public void writeRequested(ChannelHandlerContext ctx, MessageEvent e) throws Exception {
        System.out.println("writeRequested");
        super.writeRequested(ctx, e);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e) throws Exception {
        System.out.println("exceptionCaught");
        e.getCause().printStackTrace();
        Channel ch = e.getChannel();
        ch.close();
    }
}