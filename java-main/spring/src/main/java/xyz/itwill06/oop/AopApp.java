package xyz.itwill06.oop;

public class AopApp {
	//AopOne one=new AopOne();
	//AopTwo two=new AopTwo();
	
	AopProxy one=new AopProxy(new AopOne());
	AopProxy two=new AopProxy(new AopTwo());
	
	/*
	one.display1();
	one.display2();
	one.display3();
	
	two.display1();
	two.display2();
	two.display3();
	*/
}
