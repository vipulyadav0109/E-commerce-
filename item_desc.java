package vender;


public class item_desc {
	int item_id;
	String item_name;
	
	item_desc(int item_id, String item_name)
	{
		this.item_id=item_id;
		this.item_name=item_name;
	}
	
public static void getItem(String item) {
System.out.println(item);
}

}
