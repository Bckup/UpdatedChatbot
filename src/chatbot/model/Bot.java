package chatbot.model;

import java.util.ArrayList;


public class Bot
{
	
	private ArrayList<String> memeList;
	
	private String name;
	
	private String contentArea;
	
	private int chatCount;
	
	private ChatbotUser myUser;
	
	private ArrayList<String> userInputList;

	
	public Bot(String name)
	{
		memeList = new ArrayList<String>();
		userInputList = new ArrayList<String>();
		this.name = name;
		contentArea = "";
		chatCount = 0;
		myUser = new ChatbotUser();
		fillTheMemeList();

	}

	// Name - uses what the user sets as the name
	public String getName()
	{
		return name;
	}

	// Count - count how much is typed
	public int getChatCount()
	{
		return chatCount;
	}

	
	public ChatbotUser getMyUser()
	{
		return myUser;
	}

	public void setMyUser(ChatbotUser myUser)
	{
		this.myUser = myUser;
	}


	public void setName(String name)
	{
		this.name = name;
	}

	// MemeList - is a set of words that brings diff reactions
	private void fillTheMemeList()
	{
		memeList.add("Alone");
		memeList.add("Troll");
		memeList.add("LOL");
		memeList.add("Of Course");
		memeList.add("Candy");
		memeList.add("Rabbits");
		memeList.add("Pumpkins");
		memeList.add("hahaha");
	}

	
	public String processText(String currentInput)
	{
		String result = "";

		if (getChatCount() < 5)
		{
			result = introduceUser(currentInput);
		}
		else if (currentInput != null && currentInput.length() > 0)
		{
			result = randomChatConversation(currentInput);
		}
		else
		{
			result = "type some more ";
			chatCount--;
		}
		updateChatCount();
		return result;
	}

	//questions about the user, and reacts as if it's learning about you
	private String introduceUser(String input)
	{
		String userQuestion = "";

		if (getChatCount() == 0)
		{
			myUser.setUserName(input);
			userQuestion = "Cool " + myUser.getUserName() + "...how old are you?";
		}
		else if (getChatCount() == 1)
		{
			int userAge = Integer.parseInt(input);
			myUser.setAge(userAge);
			userQuestion = "That's younger than a new born baby! " + myUser.getUserName() + "...how much do you weigh?";
		}
		else if (getChatCount() == 2)
		{
			double userWeight = Double.parseDouble(input);
			myUser.setWeight(userWeight);
			userQuestion = "You are tiny!... By the way... " + myUser.getUserName() + " Do you have stickers?";
		}
		else if (getChatCount() == 3)
		{
			boolean userStickers = Boolean.parseBoolean(input);
			myUser.setHasStickers(userStickers);
			userQuestion = "Stickers!... and " + myUser.getUserName() + " do you like chocolate milk?";
		}
		else
		{
			boolean userMilk = Boolean.parseBoolean(input);
			myUser.setGotMilk(userMilk);
			userQuestion = "Awesome!" + myUser.getUserName() + "What else do you like?";
		}

		return userQuestion;
	}

	
	private String randomChatConversation(String input)
	{
		String conversation = "";

		int randomPosition = (int) (Math.random() * 7);
		if (randomPosition == 0)
		{
			if (stringLengthChecker(input))
			{
				conversation = "your typing way too much ";
			}
			else
			{
				conversation = "your typing so few words ";
			}
		}
		else if (randomPosition == 1)
		{
			if (contentChecker(input))
			{
				conversation = "yeah?";
			}
			else
			{
				conversation = "try again";
			}
		}
		else if (randomPosition == 5)
		{
			if (memeChecker(input))
			{
				conversation = "The word, " + input + " is a memeee ";
			}
			else
			{
				conversation = "nope. not a memeee... try again ";
			}
		}
		else if (randomPosition == 4)
		{
			conversation = userTopic(input);
		}
		else if (randomPosition == 4)
		{
			
			userInputList.add(input);
			conversation = "Thanks ";
		}
		else if (randomPosition == 5)
		{
			if (mashChecker(input))
			{
				conversation = mashingDetected(input);
			}
			else
			{
				conversation = noMashingDetected(input);
			}
		}
		else
		{
			if (userInputChecker(input))
			{
				conversation = "REMOVED";
			}
			else
			{
				conversation = "you never said that until now";
			}
		}

		return conversation;
	}

	private String mashingDetected(String input)
	{
		String mashed = "";

		mashed = input.substring(input.length() / 2);
		mashed += input.substring(input.length() / 2);
		mashed += input.substring(input.length() / 2);
		mashed += input.substring(input.length() / 2);
		mashed += input.substring(input.length() / 2);

		return mashed;
	}

	private String noMashingDetected(String input)
	{
		String noMashing = "Keep on typing ";
		if (input.length() > 1)
		{
			noMashing += input.substring(input.length() / 3, input.length() / 2);
		}
		return noMashing;
	}

	
	private boolean mashChecker(String userInput)
	{
		boolean isMashing = false;

		if (userInput.indexOf("sdf") > -1)
		{
			isMashing = true;
		}

		return isMashing;
	}


	private String userTopic(String userInput)
	{
		String userBasedResponse = "";

		int randomUserTopic = (int) (Math.random() * 4);

		switch (randomUserTopic)
		{
		case 1:
			userBasedResponse = myUser.hasStickers() + " neet";
			break;
		case 0:
			userBasedResponse = myUser.getUserName() + " cool";
			break;
		default:
			userBasedResponse = myUser.getAge() + "never expected that age";
			break;
		}

		return userBasedResponse;
	}

	
	private boolean userInputChecker(String userInput)
	{
		boolean matchesInput = false;

		for (int loopCount = 0; loopCount < userInputList.size(); loopCount++)
		{
			if (userInput.equalsIgnoreCase(userInputList.get(loopCount)))
			{
				matchesInput = true;
				userInputList.remove(loopCount);
				loopCount--;
			}
		}

		return matchesInput;
	}

	private void updateChatCount()
	{
		chatCount++;
	}

	
	private boolean stringLengthChecker(String input)
	{
		boolean isTooLong = false;

		if (input.length() >= 20)
		{
			isTooLong = true;
		}

		return isTooLong;
	}

	
	private boolean contentChecker(String input)
	{
		boolean hasMyContent = false;

		if (input.contains(contentArea))
		{
			hasMyContent = true;
		}

		return hasMyContent;
	}

	
	private boolean memeChecker(String input)
	{
		boolean isAMeme = false;

		for (String currentMeme : memeList)
		{
			if (input.equalsIgnoreCase(currentMeme))
			{
				isAMeme = true;
			}
		}

		return isAMeme;
	}

	//what it says when quitting
	public boolean quitChecker(String input)
	{
		boolean okToQuit = false;

		if (input != null && input.equals("Cya"))
		{
			okToQuit = true;
		}

		return okToQuit;
	}


 }