import java.util.*; // Importing Scanner class for input

//Creating Class
public class AddressBook
{
	//Declared object for Scanner class
	Scanner me=new Scanner(System.in);

	//Declaring Variables
	public int size, choice, no_of_record, update_no, delete_no, list_length, start_limit, field;
	public String new_val, first_name, last_name, address, pincode, mobile_no, state, city;
	
	//Declaring ArrayList for storing data
	ArrayList<String> arr= new ArrayList<String>();

	//Default Constructor for displaying welcome message
	AddressBook()
	{
		System.out.println("===========================================================");
		System.out.println("Welcome Address Book Problem\n");
	}
	
	//Method for displaying main menu and getting user choice
	public void main_menu()
	{
		System.out.println("===========================================================");
		System.out.println("Please Select an option");
		System.out.println("===========================================================");
		System.out.print("1.Add  2.Update  3.Delete  4.Exit\n");
		System.out.println("===========================================================");
		choice=me.nextInt();
		this.check_choice(choice);
	}

	//Method for checking choice with switvh case
	public void check_choice(int ch)
	{
		switch(ch)
		{
			//Case 1 for Add values
			case 1:
				//Getting inputs from user
				System.out.println("Enter First Name :");
				first_name=me.next();
				System.out.println("Enter Last Name :");
				last_name=me.next();
				System.out.println("Enter Address :");
				address=me.next();
				System.out.println("Enter State :");
				state=me.next();
				System.out.println("Enter City :");
				city=me.next();
				System.out.println("Enter Pin Code :");
				pincode=me.next();
				System.out.println("Enter Mobile Number :");
				mobile_no=me.next();

				//Getting size of arraylist
				size=arr.size();
				
				//Adding data to arraylist with separations

				arr.add(first_name+" | "+last_name+" | "+address+" | "+state+" | "+city+" | "+pincode+" | "+mobile_no);
				
				System.out.println("Added successfully");

				//Calling method for displaying data in list
				this.show_book();

				//Calling method for displaying main menu
				this.main_menu();
				break;

			//Case 2 for Update values
			case 2:

				//Getting size of arraylist
				size=arr.size();

				//Checking size of arraylist
				if(size>0)
				{
					//Calling method for displaying data in list
					this.show_book();

					//Getting input for update
					System.out.println("Select serial number to update");
					update_no=me.nextInt();

					//Getting data from user selected serial number
					String line=arr.get(update_no-1);

					//Breaking string by using delimeter & converting to array
					String[] words = line.split("\\|");

					//Checking serial number and size
					if(update_no>0 && update_no<=size)
					{
						//Displaying & getting fields to select for update
						System.out.println("Select field you want to update");
						System.out.println("===========================================================");
						System.out.print("1.First Name \n2.Last Name \n3.Address \n4.State \n5.City \n6.Pin Code \n7.Mobile No  \n8.Main Menu\n");
						System.out.println("===========================================================");
						field=me.nextInt();
						if(field==8)
						{
							this.main_menu();
						}
						else if(field>=1 && field<=7)
						{
							//Getting value for field
							System.out.println("Enter value you want to Update");
							new_val=me.next();

							//Updating string by index
							words[field-1]=new_val;

							//Updating value of array list
							arr.set(update_no-1, words[0]+" | "+words[1]+" | "+words[2]+" | "+words[3]+" | "+words[4]+" | "+words[5]+" | "+words[6]);
							System.out.println("Updated successfully");

							//Calling method for displaying data in list after updation
							this.show_book();
							this.main_menu();
						}
						else
						{
							//Printing error message
							System.out.println("Invalid choice");
							this.main_menu();
						}
					}
					else
					{
					 	System.out.println("Please enter valid serial number");
					}

				}
				else
				{
					System.out.println("Nothing to update. Please add some values");
					this.main_menu();
				}
				break;

			//Case 3 for Deleting values
			case 3:

				//Getting & checking size of array list
				size=arr.size();
				if(size>0)
				{
					//Calling method for displaying data in list
					this.show_book();

					//Getting serial number for delete a value
					System.out.println("Select serial number to delete");
					delete_no=me.nextInt();

					//Checking index number from array list
					if(delete_no>0 && delete_no<=size)
					{

						//Deleting value via index number
						arr.remove(delete_no-1);
						System.out.println("Deleted successfully");

						//Calling method for displaying data in list after deletion
						this.show_book();
						this.main_menu();
					}
					else
					{
						System.out.println("Please enter valid serial number");
					}

				}
				else
				{
					System.out.println("Nothing to delete. Please add some values");
					this.main_menu();
				}
				break;

			//Case 4 for closing program
			case 4:

				//Calling method for terminating program
				java.lang.System.exit(0);
				break;
				default:
					System.out.println("Invalid choice...");
					this.main_menu();
					
		}
	}

	//Method for displaying data in list
	public void show_book()
	{
		size=arr.size();
		if(size>0)
		{
			
			System.out.println("===========================================================");
			System.out.println("Address Book List");
			System.out.println("------------------------------------------------------------");
			int i=1;

			//Special loop:= For Each loop for array list
			for(String x: arr)
			{
				System.out.println(i+". "+x);
				i++;
			}
			System.out.println("------------------------------------------------------------");
		}
		else
		{
			System.out.println("No data Found");
		}
	}


	public static void main(String args[])
	{
		AddressBook obj=new AddressBook(); //Creating object & calling default constructor
		obj.main_menu(); //Calling main menu
	}

}


