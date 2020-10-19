package com.conexion;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import com.rabbitmq.client.Channel;

public class Inventario {

	private static final int CHUNK_SIZE=2000;
	private final static String QUEUE_NAME = "inventarioQueue";
	private final static String QUEUE_ERROR_NAME = "inventarioErrorQueue";


	public Inventario() {
		super();
	}
	
	private void particionar(String registros[], Channel channel) throws IOException {
		
		int chunks = (int) Math.floor(registros.length /CHUNK_SIZE);
		
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		channel.queueDeclare(QUEUE_ERROR_NAME, false, false, false, null);
		
        for(int c = 0; c<chunks; c++){
        	
        	String nRegistro [] = Arrays.copyOfRange(registros,c*CHUNK_SIZE, (c + 1)*CHUNK_SIZE);
        	
			
        	for (int i = 0; i < nRegistro.length; i++) {
    			
        		System.out.println(nRegistro[i]);
        		try {
        			
	                channel.basicPublish("", QUEUE_NAME, null, nRegistro[i].getBytes());
	                
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					channel.basicPublish("", QUEUE_ERROR_NAME, null, nRegistro[i].getBytes());
				}
                
    			
    		}
        	
        }
    }
	
	public void readFile(Channel channel) {
		BufferedReader bufferLectura = null;
		String[]campos=new String[10000];;
        try {
            bufferLectura = new BufferedReader(new FileReader("./src/recursos/cargue.csv"));
            String linea = bufferLectura.readLine();
            linea = bufferLectura.readLine();
            int i = 0;
            
            while(linea != null ) {
            	campos[i]=linea;
            	i++;            
            	linea = bufferLectura.readLine();
            }
            
        	particionar(campos, channel);
        	
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferLectura != null) {
                try {
                    bufferLectura.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
	}
}
