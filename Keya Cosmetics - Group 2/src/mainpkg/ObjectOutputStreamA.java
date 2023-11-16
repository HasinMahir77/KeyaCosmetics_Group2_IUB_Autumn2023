/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 *
 * @author hasin
 */
public class ObjectOutputStreamA extends ObjectOutputStream {

    public ObjectOutputStreamA(OutputStream out) throws IOException {
        super(out);
    }

    
    @Override
    public void writeStreamHeader() throws IOException{
    }
    
}
