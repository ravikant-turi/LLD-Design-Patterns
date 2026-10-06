package com.java.main;

//------------ Strategy interface for walk ------------------------------------

interface walkableRobot {
	void walk();
}

class NormalWalk implements walkableRobot {

	@Override
	public void walk() {
		System.out.println("Normal walk");
	}

}

class NoWalk implements walkableRobot {

	@Override
	public void walk() {
		System.out.println("No walk ");
	}

}

//------------ Strategy interface for fly ------------------------------------

interface FlyableRobot {
	void fly();
}

class NormalFly implements FlyableRobot {

	@Override
	public void fly() {
		System.out.println("Normal Fly ");
	}

}

class NoFly implements FlyableRobot {

	@Override
	public void fly() {
		System.out.println("No Fly");
	}

}

//------------ Strategy interface for  talk ------------------------------------

interface TalkableRobot {
	void talk();
}

class NormalTalk implements TalkableRobot {

	@Override
	public void talk() {
		System.out.println("Normal talk");
	}

}

class NoTalk implements TalkableRobot {

	@Override
	public void talk() {
		System.out.println("NoTalk");
	}

}

//----------Base class for Robot 
abstract class Robot {
	private TalkableRobot talkableRobot;
	private walkableRobot walkableRobot;
	private FlyableRobot flyableRobot;

	public Robot(TalkableRobot talkableRobot, com.java.main.walkableRobot walkableRobot, FlyableRobot flyableRobot) {

		this.talkableRobot = talkableRobot;
		this.walkableRobot = walkableRobot;
		this.flyableRobot = flyableRobot;
	}

	void walk() {
		walkableRobot.walk();
	}

	void fly() {
		flyableRobot.fly();
	}

	void talk() {
		talkableRobot.talk();
	}

	abstract void projection();

}

class CompanionRobot extends Robot {

	public CompanionRobot(TalkableRobot talkableRobot, com.java.main.walkableRobot walkableRobot,
			FlyableRobot flyableRobot) {
		super(talkableRobot, walkableRobot, flyableRobot);

	}

	@Override
	void projection() {

		System.out.println("Displaying companionRobot");
	}

}

class workerRobot extends Robot {

	public workerRobot(TalkableRobot talkableRobot, walkableRobot walkableRobot, FlyableRobot flyableRobot) {
		super(talkableRobot, walkableRobot, flyableRobot);
	}

	@Override
	void projection() {
		System.out.println("Displaying workerRobot ");

	}

}

public class Main {

	public static void main(String[] args) {

		Robot robot1 = new workerRobot(new NormalTalk(), new NoWalk(), new NoFly());

		robot1.walk();
		robot1.talk();
		robot1.fly();

		Robot robot2 = new workerRobot(new NoTalk(), new NormalWalk(), new NormalFly());

		robot2.walk();
		robot2.talk();
		robot2.fly();

	}

}
