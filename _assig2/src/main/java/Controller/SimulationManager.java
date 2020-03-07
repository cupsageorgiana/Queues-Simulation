package Controller;

import java.util.ArrayList;
import java.util.Random;
import Model.Client;
import Model.Scheduler;
import View.SimulationFrame;

public class SimulationManager implements Runnable {

	public int timeLimit;
	public int minProcessingTime;
	public int maxProcessingTime;
	public int minArrivalTime;
	public int maxArrivalTime;
	public int NoOfServers;
	public int NoOfClients;
	Random randomGenerator = new Random();
	public int id=0;
	public Scheduler scheduler;
	private SimulationFrame frame;
	private ArrayList<Client> generatedClients;
	
	public SimulationManager(SimulationFrame frame)
	{
		
		this.timeLimit=frame.getSimTime();
		this.minProcessingTime=frame.getMinPT();
		this.maxProcessingTime=frame.getMaxPT();
		this.NoOfServers=frame.getNoOfQueues();
		this.minArrivalTime=frame.getMinAT();
		this.maxArrivalTime=frame.getMaxAT();
		
		scheduler=new Scheduler(NoOfServers);
		generatedClients=new ArrayList<Client>();
		this.frame=frame;
		frame.displayData(scheduler.getServers());
	}
		
	public void generateClient(int id,int arrivalTime, int processingTime) throws InterruptedException {
		
		Client c = new Client (id, arrivalTime, processingTime);
		generatedClients.add(c);
		System.out.println("ID: " + c.getClientId() + "AT: " + c.getArrivalTime() + "PT: " + c.getProcessingTime());
		scheduler.dispatchClient(c);
		frame.displayTextOnLogger("Clientul "+c.getClientId()+" a venit la "+ c.getArrivalTime()+" si are timpul de procesare "+c.getProcessingTime());
	}
	public void run()
	{
		int currentTime =0;
		int time = randomGenerator.nextInt(maxArrivalTime - minArrivalTime ) + minArrivalTime;
		
		while(currentTime < timeLimit * maxProcessingTime ) {
			if(currentTime < timeLimit)
			{
				if (currentTime == time) {
				int PT = randomGenerator.nextInt(maxProcessingTime - minProcessingTime) + minProcessingTime;
				id ++;
				try {
					generateClient(id,currentTime,PT);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				time = randomGenerator.nextInt(maxArrivalTime - minArrivalTime ) + minArrivalTime + currentTime;
				}
			}
			currentTime++;
			try
			{
				Thread.sleep(1000);
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
			System.out.println("CurrentTime: "+currentTime);
			frame.displayData(scheduler.getServers());
		}
		frame.displayData(scheduler.getServers());
	}
}