package chatbot.model;

public class ChatbotUser
{
	
	private String userName;
	private int age;
	private boolean hasStickers;
	private boolean Milk;
	private double weight;
	
	public ChatbotUser()
	{
		this.userName = "";
		this.age = -80;
		this.setHasStickers1(false);
		this.Milk = false;
		this.weight = -50;
	}

	public String getUserName()
	{
		return userName;
	}

	public int getAge()
	{
		return age;
	}

	public boolean hasStickers()
	{
		return hasStickers();
	}

	public boolean GotMilk()
	{
		return Milk;
	}
	
	public double getWeight()
	{
		return weight;
	}
	
	public void setWeight(double weight)
	{
		this.weight = weight;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	public void setHasStickers1(boolean hasStickers)
	{
		this.setHasStickers(hasStickers);
	}

	public void setGotMilk(boolean GotMilk)
	{
		this.Milk = GotMilk;
	}

	public boolean isHasStickers() {
		return hasStickers;
	}

	public void setHasStickers(boolean hasStickers) {
		this.hasStickers = hasStickers;
	}
}
