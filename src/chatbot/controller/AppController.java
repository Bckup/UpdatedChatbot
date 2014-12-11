package chatbot.controller;

import chatbot.view.ChatbotView;
import chatbot.view.ChatbotFrame;
import chatbot.view.ChatbotPanel;
import chatbot.model.Bot;

public class AppController
{
	
	
	private String startMessage;

	private ChatbotView View;
	
	private ChatbotFrame Frame;

	private Bot mytalkingChatBot;
	
	private String quitMessage;



	public AppController()
	{
		Frame = new ChatbotFrame(this);
		View = new ChatbotView(this);
		mytalkingChatBot = new Bot("my");
		startMessage = "Welcome to " + mytalkingChatBot.getName() + " chatbot. What's your name?";
		quitMessage = "Bye!";
	}

	public Bot mytalkingChatBot()
	{
		return mytalkingChatBot;
	}

	public void start()
	{
		((ChatbotPanel) Frame.getContentPane()).showTextMessage(startMessage);

	}

	public String getChatbotDialog(String input)
	{
		String result = "";
		
		if(mytalkingChatBot.quitChecker(input))
		{
			quit();
		}
		
		result = mytalkingChatBot.processText(input);
		
		return result;
	}

	private void quit()
	{
		View.showChatbotMessage(quitMessage);
		System.exit(0);
	}

   }
