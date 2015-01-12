package chatbot.view;

import javax.swing.JFrame;

import chatbot.controller.AppController;


public class ChatbotFrame extends JFrame
{

	/**
	 * Frame (window) 
	 */
	private static final long serialVersionUID = 1L;
	private ChatbotPanel basePanel;
	
	public ChatbotFrame(AppController baseController)
	{
		basePanel = new ChatbotPanel(baseController);
		
		setupFrame();
	}
	
	/**
	 * The size and if visible or not
	 */
	private void setupFrame()
	{
		this.setContentPane(basePanel);
		this.setSize(500, 500);
		setVisible(true);
	}

}
