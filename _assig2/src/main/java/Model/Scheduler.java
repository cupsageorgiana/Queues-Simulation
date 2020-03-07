package Model;

import java.util.ArrayList;
import java.util.List;

public class Scheduler {
	
	private List<Server> servers;
	private int maxNoServers;
	private int maxClientsPerServer;
	
	public Scheduler(int maxNoServers)
	{
		this.setMaxNoServers(maxNoServers);
		servers=new ArrayList<Server>(maxNoServers);
		for (int i=0;i<maxNoServers;i++)
		{
			Server s=new Server();
			servers.add(s);
			Thread t=new Thread(s);
			t.start();
		}
	}

	public int getMaxClientsPerServer() {
		return maxClientsPerServer;
	}

	public void setMaxClientsPerServer(int maxClientsPerServer) {
		this.maxClientsPerServer = maxClientsPerServer;
	}

	public int getMaxNoServers() {
		return maxNoServers;
	}

	public void setMaxNoServers(int maxNoServers) {
		this.maxNoServers = maxNoServers;
	}
	
	public void dispatchClient(Client c) throws InterruptedException
	{
	      Server s=new Server();
	        int max=Integer.MAX_VALUE;
	        for (int i=0;i<maxNoServers;i++){
	            if(servers.get(i).getWaitingPeriod()<max){
	                s=servers.get(i);
	                max=servers.get(i).getWaitingPeriod();
	            }
	        }
	        System.out.println("Clientul "+c.getClientId()+" a fost adaugat in coada!");
	        s.addClient(c);

	}
		
	public List<Server> getServers()
	{
		return servers;
	}
}