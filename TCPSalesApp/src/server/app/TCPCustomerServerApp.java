package server.app;

import java.io.DataInputStream;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import model.Customer;
import server.controller.CustomerDataManager;

public class TCPCustomerServerApp {
	
public static void main(String[] args) {
		
		int portNo = 8088;
		
		CustomerDataManager manager = new CustomerDataManager();
		
		System.out.println("\n\tExecuting TCPCustomerServerApp");
		
		try {
			
			System.out.println("\tWaiting for next request");
			
			// 1. Bind to a +port
			ServerSocket serverSocket = new ServerSocket(portNo); 
			
			// 2. Server need to continually run to listen to request
			while (true) {
				
				// 3. Accept request from client
				Socket clientSocket = serverSocket.accept();
				
				// 4. Process request - create input stream to read request
				// Request - customer id:int
				InputStream is = clientSocket.getInputStream();
				DataInputStream dis = new DataInputStream(is);
				
				// Read customer id from client
				int customerId = dis.readInt();
				System.out.println("\tRequest for customer id: " + customerId);
				
				// Get customer
				Customer customer = manager.getCustomer(customerId);
				
				// 5. Respond to client
				OutputStream os  = clientSocket.getOutputStream();
				ObjectOutputStream oos = new ObjectOutputStream(os);
				oos.writeObject(customer);
				System.out.print("\tSending customer: " + customer.getCustomerId()
						+ " " + customer.getCustName());
				
			}
			
		} catch (Exception ex) {
			
			ex.printStackTrace();
		}
		
	}


}
