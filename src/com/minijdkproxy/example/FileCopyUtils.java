package com.minijdkproxy.example;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;


public abstract class FileCopyUtils {
    public static final int BLOCK_SIZE = 4096;

    public FileCopyUtils() {
    }

    public static void copy(File in, File out) throws IOException {
        copy((InputStream)(new BufferedInputStream(new FileInputStream(in))), (OutputStream)(new BufferedOutputStream(new FileOutputStream(out))));
    }

    public static void copy(byte[] in, File out) throws IOException {
        ByteArrayInputStream inStream = new ByteArrayInputStream(in);
        OutputStream outStream = new BufferedOutputStream(new FileOutputStream(out));
        copy((InputStream)inStream, (OutputStream)outStream);
    }

    public static byte[] copyToByteArray(File in) throws IOException {
        return copyToByteArray((InputStream)(new BufferedInputStream(new FileInputStream(in))));
    }

    public static void copy(InputStream in, OutputStream out) throws IOException {
        try {
            byte[] buffer = new byte[4096];
            boolean var3 = true;

            int nrOfBytes;
            while((nrOfBytes = in.read(buffer)) != -1) {
                out.write(buffer, 0, nrOfBytes);
            }

            out.flush();
        } finally {
            try {
                in.close();
            } catch (IOException var13) {
            }

            try {
                out.close();
            } catch (IOException var12) {
            }

        }
    }

    public static void copy(byte[] in, OutputStream out) throws IOException {
        copy((InputStream)(new ByteArrayInputStream(in)), (OutputStream)out);
    }

    public static byte[] copyToByteArray(InputStream in) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        copy((InputStream)in, (OutputStream)out);
        return out.toByteArray();
    }

    public static void copy(Reader in, Writer out) throws IOException {
        try {
            char[] buffer = new char[4096];
            boolean var3 = true;

            int nrOfBytes;
            while((nrOfBytes = in.read(buffer)) != -1) {
                out.write(buffer, 0, nrOfBytes);
            }

            out.flush();
        } finally {
            try {
                in.close();
            } catch (IOException var13) {
            }

            try {
                out.close();
            } catch (IOException var12) {
            }

        }
    }

    public static void copy(String in, Writer out) throws IOException {
        copy((Reader)(new StringReader(in)), (Writer)out);
    }

    public static String copyToString(Reader in) throws IOException {
        StringWriter out = new StringWriter();
        copy((Reader)in, (Writer)out);
        return out.toString();
    }


}