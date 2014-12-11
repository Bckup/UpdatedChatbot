package chatbot.view;

import javax.swing.JOptionPane;

import chatbot.controller.AppController;

public class ChatbotView
{
	
	private AppController baseController;
	
	
	public ChatbotView(AppController baseController)
	{
		this.baseController = baseController;
	}
	
	
	public String showChatbotDialog(String currentInput)
	{
		String result = "";
		
		result = JOptionPane.showInputDialog(null, baseController.mytalkingChatBot().getName() + " says: " + currentInput);
	
		return result;
	}
	
	
	public void showChatbotMessage(String currentInput)
	{
		JOptionPane.showMessageDialog(null, baseController.mytalkingChatBot().getName() + " says: " + currentInput);
	}
}
