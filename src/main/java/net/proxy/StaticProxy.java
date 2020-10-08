package net.proxy;

public class StaticProxy implements HelloWorld
{
	HelloWorld helloWorld;

	public StaticProxy(HelloWorld helloWorld)
	{
		this.helloWorld = helloWorld;
	}

	public void print()
	{
		System.out.println("Before Hello World!");
		helloWorld.print();
		System.out.println("After Hello World!");
	}
}