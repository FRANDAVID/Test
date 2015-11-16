package netty;  
  
import static org.jboss.netty.handler.codec.http.HttpHeaders.Names.CONTENT_TYPE;  
import static org.jboss.netty.handler.codec.http.HttpResponseStatus.BAD_REQUEST;  
import static org.jboss.netty.handler.codec.http.HttpResponseStatus.INTERNAL_SERVER_ERROR;  
import static org.jboss.netty.handler.codec.http.HttpResponseStatus.OK;  
import static org.jboss.netty.handler.codec.http.HttpVersion.HTTP_1_1;  
  
import java.net.InetSocketAddress;  
import java.util.concurrent.Executors;  
  
import org.jboss.netty.bootstrap.ServerBootstrap;  
import org.jboss.netty.buffer.ChannelBuffer;  
import org.jboss.netty.buffer.ChannelBuffers;  
import org.jboss.netty.buffer.DynamicChannelBuffer;  
import org.jboss.netty.channel.Channel;  
import org.jboss.netty.channel.ChannelFutureListener;  
import org.jboss.netty.channel.ChannelHandlerContext;  
import org.jboss.netty.channel.ChannelPipeline;  
import org.jboss.netty.channel.ChannelPipelineFactory;  
import org.jboss.netty.channel.Channels;  
import org.jboss.netty.channel.ExceptionEvent;  
import org.jboss.netty.channel.MessageEvent;  
import org.jboss.netty.channel.SimpleChannelUpstreamHandler;  
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;  
import org.jboss.netty.handler.codec.frame.TooLongFrameException;  
import org.jboss.netty.handler.codec.http.DefaultHttpResponse;  
import org.jboss.netty.handler.codec.http.HttpRequest;  
import org.jboss.netty.handler.codec.http.HttpRequestDecoder;  
import org.jboss.netty.handler.codec.http.HttpResponse;  
import org.jboss.netty.handler.codec.http.HttpResponseEncoder;  
import org.jboss.netty.handler.codec.http.HttpResponseStatus;  
import org.jboss.netty.util.CharsetUtil;  
  



public class TestNetty {  
      
    public static void main(String[] args) {  
        start(8080);  
    }  
  
    public static void start(int port) {  
        // 配置服务器-使用java线程池作为解释线程  
        ServerBootstrap bootstrap = new ServerBootstrap(  
                      new NioServerSocketChannelFactory(  
                        Executors.newCachedThreadPool(),   
                        Executors.newCachedThreadPool()));  
        // 设置 pipeline factory.  
        bootstrap.setPipelineFactory(new ServerPipelineFactory());  
        // 绑定端口  
        bootstrap.bind(new InetSocketAddress(port));  
        System.out.println("admin start on " + port);  
    }  
  
    private static class ServerPipelineFactory implements ChannelPipelineFactory {  
        public ChannelPipeline getPipeline() throws Exception {  
            // Create a default pipeline implementation.  
            ChannelPipeline pipeline = Channels.pipeline();  
            pipeline.addLast("decoder", new HttpRequestDecoder());  
            pipeline.addLast("encoder", new HttpResponseEncoder());  
            // http处理handler  
            pipeline.addLast("handler", new AdminServerHandler());  
            return pipeline;  
        }  
    }  
}  
  
class AdminServerHandler extends SimpleChannelUpstreamHandler {  
  
    @Override  
    public void messageReceived(ChannelHandlerContext ctx, MessageEvent e)   
                              throws Exception {  
        HttpRequest request = (HttpRequest) e.getMessage();  
        String uri = request.getUri();  
        System.out.println("uri:" + uri);  
        HttpResponse response = new DefaultHttpResponse(HTTP_1_1, OK);  
        ChannelBuffer buffer = new DynamicChannelBuffer(2048);  
        buffer.writeBytes("hello!! 你好".getBytes("UTF-8"));  
        response.setContent(buffer);  
//        response.setHeader("Content-Type", "text/html; charset=UTF-8");  
//        response.setHeader("Content-Length", response.getContent().writerIndex());  
        Channel ch = e.getChannel();  
        // Write the initial line and the header.  
        ch.write(response);  
        ch.disconnect();  
        ch.close();  
  
    }  
  
    @Override  
    public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e)   
                              throws Exception {  
        Channel ch = e.getChannel();  
        Throwable cause = e.getCause();  
        if (cause instanceof TooLongFrameException) {  
            sendError(ctx, BAD_REQUEST);  
            return;  
        }  
  
        cause.printStackTrace();  
        if (ch.isConnected()) {  
            sendError(ctx, INTERNAL_SERVER_ERROR);  
        }  
    }  
  
    private void sendError(ChannelHandlerContext ctx, HttpResponseStatus status) {  
        HttpResponse response = new DefaultHttpResponse(HTTP_1_1, status);  
//        response.setHeader(CONTENT_TYPE, "text/plain; charset=UTF-8");  
        response.setContent(ChannelBuffers.copiedBuffer("Failure: "   
                             + status.toString() + "\r\n", CharsetUtil.UTF_8));  
  
        // Close the connection as soon as the error message is sent.  
        ctx.getChannel().write(response).addListener(ChannelFutureListener.CLOSE);  
    }  
}  