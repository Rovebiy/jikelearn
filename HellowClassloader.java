package com.shisu.demo;



import java.util.Base64;

public class HellowClassloader extends ClassLoader {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        new HellowClassloader().findClass("com.shisu.demo.ClassLoaderOutTest").newInstance();
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String helloBase64 ="yv66vgAAADQAHAoABgAOCQAPABAIABEKABIAEwcAFAcAFQEABjxpbml0PgEAAygpVgEABENvZGUBAA9MaW5lTnVtYmVyVGFibGUBAAg8Y2xpbml0PgEAClNvdXJjZUZpbGUBABdDbGFzc0xvYWRlck91dFRlc3QuamF2YQwABwAIBwAWDAAXABgBABhIZWxsbyBDbGFzcyBJbml0aWFsaXplZCEHABkMABoAGwEAIWNvbS9zaGlzdS9kZW1vL0NsYXNzTG9hZGVyT3V0VGVzdAEAEGphdmEvbGFuZy9PYmplY3QBABBqYXZhL2xhbmcvU3lzdGVtAQADb3V0AQAVTGphdmEvaW8vUHJpbnRTdHJlYW07AQATamF2YS9pby9QcmludFN0cmVhbQEAB3ByaW50bG4BABUoTGphdmEvbGFuZy9TdHJpbmc7KVYAIQAFAAYAAAAAAAIAAQAHAAgAAQAJAAAAHQABAAEAAAAFKrcAAbEAAAABAAoAAAAGAAEAAAADAAgACwAIAAEACQAAACUAAgAAAAAACbIAAhIDtgAEsQAAAAEACgAAAAoAAgAAAAUACAAGAAEADAAAAAIADQ==";

//        String Base64 = encode(helloBase64);
        byte[] bytes = decode(helloBase64);
        return defineClass(name,bytes,0,bytes.length);
    }
    //加密
    private String encode(String base64) {
        byte[] bytes = base64.getBytes();
        return Base64.getEncoder().encodeToString(bytes);
    }
    //解密
    private byte[] decode(String base64) {
        return Base64.getDecoder().decode(base64);
    }

}
