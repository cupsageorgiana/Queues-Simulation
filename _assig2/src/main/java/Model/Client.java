package Model;

public class Client {

	private int clientId;
	private int arrivalTime;
	private int processingTime;
	
	public Client(int clientId, int arrivalTime, int processingTime)
	{
		this.clientId=clientId;
		this.arrivalTime=arrivalTime;
		this.processingTime=processingTime;
	}
	
	public void setClientId(int clientId)
	{
		this.clientId=clientId;
	}
	public int getClientId()
	{
		return clientId;
	}
	public void setArrivalTime(int arrivalTime)
	{
		this.arrivalTime=arrivalTime;
	}
	public int getArrivalTime()
	{
		return arrivalTime;
	}
	public void setProcessingTime(int processingTime)
	{
		this.processingTime=processingTime;
	}
	public int getProcessingTime()
	{
		return processingTime;
	}
	public String toString()
	{
		return ("Clientul "+this.getClientId()+" a venit la "+ getArrivalTime()+" si are timpul de procesare "+getProcessingTime());
	}
	public String getString() {
		return ("Client " + this.getClientId());
	}
	
}
