package ua.kiev.prog;

import jakarta.servlet.http.HttpServletRequest;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class RequestToByteArray {
    public static byte [] convert(HttpServletRequest request) throws IOException {
        InputStream is = request.getInputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte [] buf = new byte[10240];
        int r;
        do {
            r = is.read(buf);
            if(r > 0)
                baos.write(buf, 0 , r);
        } while (r != -1);
        return baos.toByteArray();
    }
}
