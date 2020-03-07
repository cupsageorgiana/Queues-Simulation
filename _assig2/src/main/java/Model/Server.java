package Model;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Server implements Runnable {

	public BlockingQueue<Client> queue;
	private AtomicInteger waitingPeriod;
	
	public Server()
	{
		queue=new LinkedBlockingQueue<Client>();
		waitingPeriod=new AtomicInteger();
	}
	
	public void setQueue(BlockingQueue<Client> queue)
	{
		this.queue=queue;
	}
	public BlockingQueue<Client> getQueue()
	{
		return queue;
	}
	
	public void setWaitingPeriod(AtomicInteger waitingPeriod)
	{
		this.waitingPeriod=waitingPeriod;
	}
	public int getWaitingPeriod()
	{
		return waitingPeriod.get();
	}
	public void addClient(Client newClient) throws InterruptedException
	{
		queue.put(newClient);
		waitingPeriod.addAndGet(newClient.getProcessingTime());
	}
	
	public void removeClient(Client newClient)
	{
		if (!queue.isEmpty())
		{
		queue.remove(newClient);
		waitingPeriod.getAndDecrement();
		}
	}
	
	public int sizeQueue() 
	{
		return queue.size();
	}
	
   public void run()
	{	
		while(true)
		{
		try
		{
				if (!queue.isEmpty())
				{
					Client c;
					c=queue.peek();
					if (c!= null)
					{
						waitingPeriod.addAndGet(-c.getProcessingTime());
						Thread.sleep(c.getProcessingTime()*1000);
						System.out.println("Clientul "+c.getClientId()+" a plecat ");
						queue.take();	
				    }
				}
			}
				catch(InterruptedException e)
				{
					e.printStackTrace();
				}
				
			}
	}
}