package com.xiekun;

import com.xiekun.handler.AbsIntegerEncoder;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.embedded.EmbeddedChannel;
import org.junit.Test;

public class AbsIntegerEncoderTest {
    @Test
    public void testEncode(){
        ByteBuf buf = Unpooled.buffer();
        for (int i = 0; i < 10; i++) {
            buf.writeInt(i * -1);
        }

        EmbeddedChannel channel = new EmbeddedChannel(new AbsIntegerEncoder());
        channel.writeOutbound(buf);
        channel.finish();

        for (int i = 0; i < 10; i++) {
            System.out.println((Integer) channel.readOutbound());
        }
    }
}
