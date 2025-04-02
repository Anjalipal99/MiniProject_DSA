import java.util.Scanner;

class BrowserHistory2{
	Node current;

static class Node
{
	String url;
	Node prev,next;
	
	Node(String url)
	{
		this.url=url;
		this.prev=null;
		this.next=null;
	}
}
void visitPage(String url)
{
	Node newNode=new Node(url);
	if(current==null)
	{
		current=newNode;
	}else
	{
		current.next=newNode;
		newNode.prev=current;
		current=newNode;
	}
	System.out.println("Visited: "+url);
}
void moveForward()
{
	if (current!=null && current.next!=null)
	{
		current=current.next;
		System.out.println("Moved Forward: "+ current.url);
	}else
	{
		System.out.println("No forward History");
	}
}
void moveBackward()
{
	if(current!=null && current.prev!=null)
	{
		current=current.prev;
		System.out.println("Moved Backward: "+current.url);
	}else
	{
		System.out.println("No Backward History");
	}
}
void displayCurrentPage()
{
	if(current!=null)
	{
	System.out.println("Current Page!"+ current.url);
	}else
	{
		System.out.println("No history available");
	}
}
void clearHistory()
{
	current=null;
	System.out.println("History Cleared!!!!");
}

public static void main(String[] args)
{
	BrowserHistory2 B=new BrowserHistory2();
	Scanner sc=new Scanner(System.in);
	int choice;
	do
	{
		System.out.println("\nBrowser History Menu: ");
		System.out.println("1.Visit Page ");
		System.out.println("2.Move Forward ");
		System.out.println("3.Move Backward ");
		System.out.println("4.Display Current Page ");
		System.out.println("5.Clear History ");
		System.out.println("6.Exit ");
		System.out.println("Enter Your Choice ");
		
		choice=sc.nextInt();
		sc.nextLine();
		
		switch(choice)
		{
			case 1:
				System.out.println("Enter URL: ");
				String url=sc.nextLine();
				B.visitPage(url);
				break;
			case 2:
				B.moveForward();
				break;
			case 3:
				B.moveBackward();
				break;
			case 4:
				B.displayCurrentPage();
				break;
			case 5:
				B.clearHistory();
				break;
			case 6:
			System.out.println(" Exiting.....");
			break;
			default:
			System.out.println("Invalid choice, try again! :) ");
		}
	}	while(choice!=6);
		sc.close();
		

}
}