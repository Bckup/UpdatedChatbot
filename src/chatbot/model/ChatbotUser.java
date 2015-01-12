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
    /**
     * name
     * @return
     */
	public String getUserName()
	{
		return userName;
	}
    /**
     * age
     * @return
     */
	public int getAge()
	{
		return age;
	}
    /**
     * stickers
     * @return
     */
	public boolean hasStickers()
	{
		return hasStickers();
	}
    /**
     * check milk
     * @return
     */
	public boolean GotMilk()
	{
		return Milk;
	}
	/**
	 * weight
	 */
	public double getWeight()
	{
		return weight;
	}
	/**
	 * when weight more
	 * @param weight
	 */
	public void setWeight(double weight)
	{
		this.weight = weight;
	}
    /**
     * 
     * @param userName
     */
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
