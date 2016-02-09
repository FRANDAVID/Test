package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

/**
 * Created by wwh on 15-7-25.
 * http://blog.csdn.net/wwh578867817/article/details/47071417
 */
public class NioSocket {
    //字符序列和字节序列的编码和解码
    private Charset charset = Charset.forName("UTF-8");

    void run(String ip, int port) throws IOException {
        try {
            //创建服务端套接字
            ServerSocketChannel server = ServerSocketChannel.open();
            //绑定ip和端口
            server.socket().bind(new InetSocketAddress(ip, port));
            //设置非阻塞
            server.configureBlocking(false);
            //创建selector事件选择器
            Selector selector = Selector.open();
            //将自己的监听套接字注册到selector上，监听 accept事件
            //SelectionKey代表SelectableChannel和Selector的关系，Selectable是Selector可监听的事件channel.
            server.register(selector, SelectionKey.OP_ACCEPT);
            while(selector.select() > 0){
                //selector.select()返回事件
                for(SelectionKey sk : selector.selectedKeys()) {
                    //从事件集合中删除正要处理的事件
                    selector.selectedKeys().remove(sk);
                    //判断事件的类型，依次处理
                    if(sk.isAcceptable()){
                        //如果事件为接受连接accpet事件
                        System.out.println("accpet 事件");
                        //调用accept接受请求连接
                        SocketChannel client = server.accept();
                        //设置为非阻塞
                        client.configureBlocking(false);
                        //向selector上注册读事件
                        client.register(selector, SelectionKey.OP_READ);
                        //将sk对应的channel设置为准备接受其他请求
                        sk.interestOps(SelectionKey.OP_ACCEPT);
                    }
                    if(sk.isReadable()){
                        //如果事件为可读事件
                        System.out.println("read 事件");
                        SocketChannel client = (SocketChannel)sk.channel();
                        //定义缓冲区
                        ByteBuffer buffer = ByteBuffer.allocate(1024);
                        String mesg = "";
                        try {
                            while (client.read(buffer) > 0) {
                                buffer.flip();
                                mesg += charset.decode(buffer);
                            }
                            System.out.println("收到：" + mesg);
                            sk.interestOps(SelectionKey.OP_READ);
                        }catch (IOException e){
                            //如果出现异常，则取消当前的client连接
                            sk.cancel();
                            if(sk.channel() != null){
                                sk.channel().close();
                            }
                        }
                        //回复给发来消息的client
                        client.write(charset.encode(mesg));
                        System.out.println("回复：" + mesg);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        NioSocket Server = new NioSocket();
        Server.run("localhost", 10000);
    }
}