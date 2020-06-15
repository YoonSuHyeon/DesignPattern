package Mediator;

abstract class Mediator
{
	public abstract void Send(Friend frd, String msg);
}
class ConcreteMediator extends Mediator
{
	private Friend1 friend1;
	private Friend2 friend2;
	private Boss boss;

	public void setFriend1(Friend1 friend1) {
		this.friend1 = friend1;
	}

	public void setFriend2(Friend2 friend2) {
		this.friend2 = friend2;
	}

	public void setBoss(Boss boss) {
		this.boss = boss;
	}

	@Override
	public void Send(Friend frd,String msg)
	{
		if (frd == friend1)
		{
			friend2.Notify(msg);
			boss.Notify(friend1.name + " sends message to " + friend2.name);
		}
		if(frd==friend2)
		{
			friend1.Notify(msg);
			boss.Notify(friend2.name + " sends message to " + friend1.name);

		}
		if(frd==boss)
		{
			friend1.Notify(msg);
			friend2.Notify(msg);
		}
	}

}

abstract class Friend
{
	protected Mediator mediator;
	public String name;
	public Friend(Mediator _mediator)
	{
		mediator = _mediator;
	}
}
class Friend1 extends Friend
{
	public Friend1(Mediator mediator,String name)
	{
		super(mediator);
		this.name = name;
	}
	public void Send(String msg)
	{
		mediator.Send(this,msg);
	}
	public void Notify(String msg)
	{
		System.out.println("Amit gets message: "+ msg);
	}
}
class Friend2 extends Friend
{
	public Friend2(Mediator mediator,String name)
	{
		super(mediator);
		this.name = name;
	}
	public void Send(String msg)
	{
		mediator.Send(this,msg);
	}
	public void Notify(String msg)
	{
		System.out.println("Sohel gets message: "+ msg);
	}
}

class Boss extends Friend
{
	public Boss(Mediator mediator,String name)
	{
		super(mediator);
		this.name = name;
	}
	public void Send(String msg)
	{
		mediator.Send(this, msg);
	}
	public void Notify(String msg)
	{
		System.out.println("\nBoss sees message: " + msg);
		System.out.println("");
	}
}
class MediatorPatternEx
{
	public static void main(String[] args)
	{
		System.out.println("***Mediator Pattern Demo***\n");
		ConcreteMediator m = new ConcreteMediator();
		Friend1 Amit= new Friend1(m,"Amit");
		Friend2 Sohel = new Friend2(m,"Sohel");
		Boss Raghu = new Boss(m,"Raghu");
		m.setFriend1(Amit);
		m.setFriend2(Sohel);
		m.setBoss(Raghu);
		Amit.Send("[Amit here]Good Morrning. Can we discuss the mediator pattern?");
		Sohel.Send("[Sohel here]Good Morning.Yes, we can discuss now.");
		Raghu.Send("\n[Raghu here]:Please get back to work quickly");
	}
}