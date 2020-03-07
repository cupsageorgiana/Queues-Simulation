package View;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.*;

import Controller.SimulationManager;
import Model.Client;
import Model.Server;


	public class SimulationFrame extends JFrame{
		private static final long serialVersionUID= 1L;
		JPanel panel = new JPanel();
		JFrame frame=new JFrame();
		private int width = 600, height = 600;
		SimulationManager manager;
		private int minProcessTime;
		private int maxProcessTime;
		private int minArrivalTime;
		private int maxArrivalTime;
		private int noOfQueue;
		private int simulationTime;
		
		JFrame frame1 = new JFrame();
		JPanel pframe = new JPanel();
		
		private JLabel minAT=new JLabel ("Min Arrival Time");
		private JLabel maxAT=new JLabel ("Max Arrival Time");
		private JLabel minPT=new JLabel ("Min Processing Time");
		private JLabel maxPT=new JLabel ("Max Processing Time");
		private JLabel simTime=new JLabel ("Simulation Time");
	    private JLabel NoOfQueues=new JLabel ("Number of queues");
	    private JTextField minAT_txt=new JTextField (3);
	    private JTextField maxAT_txt=new JTextField (3);
	    private JTextField minPT_txt=new JTextField (3);
	    private JTextField maxPT_txt=new JTextField (3);
	    private JTextField simTime_txt=new JTextField (3);
	    private JTextField NoOfQueues_txt=new JTextField (3);
	    private JButton StartBtn=new JButton("Start");
	    private TextArea textArea; 
	    private JScrollPane scrollPane;
	    
		public SimulationFrame () {
			this.add(panel);
			this.manager=manager;
			this.setSize(width,height);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			panel.setBackground(Color.white);
			this.setLocationRelativeTo(null);
			this.setVisible(true);
			
		textArea = new TextArea(50,50);
		textArea.setText("");
		scrollPane = new JScrollPane();
		frame1.add(pframe);
		textArea.setSize(100,100);
		pframe.setSize(150,150);
		pframe.add(textArea);
		pframe.setBackground(Color.white);
		
			JPanel p1=new JPanel();
			   p1.setLayout(new FlowLayout());
			   p1.add(minAT);
			   p1.add(minAT_txt);
			   p1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			  
			    p1.setLayout(new FlowLayout());
			    p1.add(maxAT);
			    p1.add(maxAT_txt);
			    p1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			    
			    JPanel p2=new JPanel();
				   p2.setLayout(new FlowLayout());
				   p2.add(minPT);
				   p2.add(minPT_txt);
				   p2.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
				  
				    p2.setLayout(new FlowLayout());
				    p2.add(maxPT);
				    p2.add(maxPT_txt);
				    p2.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
				   				    
					   JPanel p4=new JPanel();
					   p4.setLayout(new FlowLayout());
					   p4.add(NoOfQueues);
					   p4.add(NoOfQueues_txt);
					   p4.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
					   
					   JPanel p5=new JPanel();
					   p5.setLayout(new FlowLayout());
					   p5.add(simTime);
					   p5.add(simTime_txt);
					   p5.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

					   JPanel p6=new JPanel();
					   p6.setLayout(new FlowLayout());
					   p6.add(StartBtn);
					   p6.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
					   
			    
			    final JPanel pf=new JPanel();
		        pf.setLayout(new BoxLayout(pf,BoxLayout.Y_AXIS));
		        pf.add(p1);
		        pf.add(p2);
		        pf.add(p4);
		        pf.add(p5);
		        pf.add(p6);
		        pf.setBackground(Color.white);
		        p1.setBackground(Color.white);
		        p2.setBackground(Color.white);
		        p4.setBackground(Color.white);
		        p5.setBackground(Color.white);
		        p6.setBackground(Color.white);
		        
		        frame.setContentPane(pf);
		        frame.pack();
		        frame.setTitle("Manager");
		        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        frame.setSize(600,400);
		        frame.setVisible(true);
		        
		        frame1.setVisible(true);
		        frame1.setTitle("Logger");
		        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        frame1.setSize(600,700);
		       
		       StartBtn.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						minProcessTime=Integer.parseInt(minPT_txt.getText());
						maxProcessTime=Integer.parseInt(maxPT_txt.getText());
						minArrivalTime=Integer.parseInt(minAT_txt.getText());
						maxArrivalTime=Integer.parseInt(maxAT_txt.getText());
						simulationTime=Integer.parseInt(simTime_txt.getText());
						noOfQueue=Integer.parseInt(NoOfQueues_txt.getText());
						
					
							SimulationManager sim=new SimulationManager(SimulationFrame.this);
							Thread t=new Thread(sim);
							t.start();
					}
				});
			}
		
		public void displayTextOnLogger(String s) {
			
			textArea.append(s + "\n");
		}
		public int getMinAT()
		{
			return minArrivalTime;
		}
		
		public int getMaxAT()
		{
			return maxArrivalTime;
		}
		
		public int getMinPT()
		{
			return minProcessTime;
		}
		
		public int getMaxPT()
		{
			return maxProcessTime;
		}
		
		public int getNoOfQueues()
		{
			return noOfQueue;
		}
		
		public int getSimTime()
		{
			return simulationTime;
		}
		
		public void displayData(List<Server> list) {
			panel.removeAll();
			
			this.validate();
			ArrayList<JScrollPane> s = new ArrayList<JScrollPane>();
			ArrayList <JPanel> p = new ArrayList <JPanel>();
			int i=0;
			for (Iterator<Server> it = list.iterator(); it.hasNext();) {
				
				p.add(i, new JPanel());
				p.get(i).setLayout(new BoxLayout(p.get(i), BoxLayout.Y_AXIS));
				p.get(i).setBackground(Color.white);
				p.get(i).setBounds(i*200, 0, 200, 300);
				JLabel coada = new JLabel("Queue "+(i+1));
				coada.setFont(new Font("Comic Sans MS", Font.PLAIN,18));
				p.get(i).add(coada);
				
				for (Client t : it.next().getQueue()) {
							JLabel aux = new JLabel(t.getString());
							aux.setFont(new Font("Comic Sans MS", Font.PLAIN,14));
							p.get(i).add(aux);		
							
				}
				
				JScrollPane aux2 = new JScrollPane(p.get(i));
				s.add(i, aux2);	
				i++;
			}
			
			for (JPanel k: p) {
				panel.add(k);
				panel.add(Box.createRigidArea(new Dimension(100, 0)));
			}
			for (JScrollPane k: s) {
				panel.add(k);
			}
			this.setTitle("Simulator");
			this.setVisible(true);
			this.repaint();
			this.revalidate();
		}
		
		public static void main(String[] args) {
		SimulationFrame frame = new SimulationFrame();
		
		}
	}
