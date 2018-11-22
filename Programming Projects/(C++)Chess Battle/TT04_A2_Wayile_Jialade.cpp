/**********|**********|**********|
Program: TT04_A2_Wayile_Jialade.cpp
Course: TCP1101 Programming Fundamentals
Year: 2016/17 Trimester 2
Name: Wayile Jialade
ID: 1151102347
Email: 1151102347@student.mmu.edu.my
Phone: 014-6865506
**********|**********|**********/


#include <iostream>
#include <cstdlib>
#include <ctime>
#include <limits>
using namespace std;


void banner();
void position(char list[],int size);
char player1_choice(char input1);
char player2_choice(char input2);
void exit(int player1_score,int player2_score,char newlist[]);

int main()
{
	
	banner();//display the game banner
	
	int size=9;
	char list[9] = {'Q','q','R','r','B','b','K','k',' '}; //set all pieces which are going to be displayed in the game
	char list1[9] = {'b',' ','k','R','q','K','r','Q','B'};
	char list2[9] = {' ','Q','r','q','k','K','b','R','B'};
	char list3[9] = {'b','R','q',' ','K','B','k','Q','r'};
	
	int a,b=size;
	char newlist[size]; //set an array to store the position of each piece.
	
	
	int menu=0;
	while(menu<1 || menu>4)
	{
		//to display menu
		//cout << endl<<endl;
		cout << "Game Menu"<<endl;
		cout << "1.Game Sample Run 1" << endl;
		cout << "2.Game Sample Run 2" << endl;
		cout << "3.Game Sample Run 3" << endl;
		cout << "4.Game Random Sample" << endl;
		cout << "Input a game number -> ";
	
		cin >> menu;
		while(menu<1 || menu>4)
		{
			cout << "Please enter a valid number -> ";
			cout << endl<<endl;
			cout << "Game Menu" << endl;
			cout << "1.Game Sample Run 1" << endl;
			cout << "2.Game Sample Run 2" << endl;
			cout << "3.Game Sample Run 3" << endl;
			cout << "4.Game Random Sample" << endl;
			cout << "Input a game number -> ";
			cin.clear(); //prevent any illegal input
			cin.ignore(numeric_limits<streamsize>::max(),'\n');
			cin >> menu;
		}
	}
	
	//there will be different arrangement of pieces by your menu choice
	
	if(menu==1)
	{
		for(int x=0; x<size; x++)
		{
			newlist[x] = list1[x];
		}
	}
	else if(menu == 2)
	{
		for(int x=0; x<size; x++)
		{
			newlist[x] = list2[x];
		}
	}
	else if(menu == 3)
	{
		for(int x=0; x<size; x++)
		{
			newlist[x] = list3[x];
		}
	}
	else if(menu == 4)
	{
		srand(time(0));  
		for(int i=size;size>0;size--)
		{
			a = rand()%size; //generate a random number between 0 to size
			newlist[b-size]=list[a];//collects the elements for print
			while(a<size-1) //shifts the element to the left
			{
				list[a]=list[a+1];
				a++;
			}
		}
	}
	
	int number_of_game=1,player1_score=0,player2_score=0;
	
	while(number_of_game<=4) //only 4 games can be played
	{
		int coordinate1=-1,coordinate2=-1;//when piece no found, set coordinate to -1
		int pass=0;
		char letter1,letter2,input1,input2;
		while(pass==0) //loop until pass=1, which means player1 made a choice successfully
		{
			
			position(newlist,9); //display the board according to the array"newlist"
			letter1=player1_choice(input1); //get player1's input
			
			
			
			if(letter1=='Q')
			{
				for(int i=0;i<9;i++)
				{
					if(newlist[i]=='Q')
					{
						coordinate1 = i; //get the position of the queen
						break;
					}
				}
				
				
				if (coordinate1 <0) // when the queen was not found in the array"newlist"
				{
					cout << "Pieces not found!!"<<endl; 
					pass = 0;
				}
				
			
				//to shoot the opponent if Q could.
				//all possible cases are listed below
				//once Q shoot a piece, the player 2 will make a choice then. 
				while(coordinate1>=0)
				{
					if((newlist[0]=='q' || newlist[0]=='r' || newlist[0]=='b' || newlist[0]=='k')&&(coordinate1==1 || coordinate1==3 || coordinate1==4))
					{
						newlist[0]= ' ';
						pass = 1;
					}
					else if((newlist[1]=='q' || newlist[1]=='r' || newlist[1]=='b' || newlist[1]=='k')&&(coordinate1==0 || coordinate1==2 || coordinate1==3 || coordinate1==4 || coordinate1==5))
					{
						newlist[1]= ' ';
						pass = 1;
					}
					else if((newlist[2]=='q' || newlist[2]=='r' || newlist[2]=='b' || newlist[2]=='k')&&(coordinate1==1 || coordinate1==4 || coordinate1==5))
					{
						newlist[2]= ' ';
						pass = 1;
					}
					else if((newlist[3]=='q' || newlist[3]=='r' || newlist[3]=='b' || newlist[3]=='k')&&(coordinate1==0 || coordinate1==1 || coordinate1==4 || coordinate1==6 || coordinate1==7))
					{
						newlist[3]= ' ';
						pass = 1;
					}
					else if((newlist[4]=='q' || newlist[4]=='r' || newlist[4]=='b' || newlist[4]=='k')&&(coordinate1==0 || coordinate1==1 || coordinate1==2 || coordinate1==3 || coordinate1==5 || coordinate1==6 || coordinate1==7 || coordinate1==8))
					{
						newlist[4]= ' ';
						pass = 1;
					}
					else if((newlist[5]=='q' || newlist[5]=='r' || newlist[5]=='b' || newlist[5]=='k')&&(coordinate1==1 || coordinate1==2 || coordinate1==4 || coordinate1==7 || coordinate1==8))
					{
						newlist[5]= ' ';
						pass = 1;
					}
					else if((newlist[6]=='q' || newlist[6]=='r' || newlist[6]=='b' || newlist[6]=='k')&&(coordinate1==3 || coordinate1==4 || coordinate1==7))
					{
						newlist[6]= ' ';
						pass = 1;
					}
					else if((newlist[7]=='q' || newlist[7]=='r' || newlist[7]=='b' || newlist[7]=='k')&&(coordinate1==3 || coordinate1==4 || coordinate1==5 || coordinate1==6 || coordinate1==8))
					{
						newlist[7]= ' ';
						pass = 1;
					}
					else if((newlist[8]=='q' || newlist[8]=='r' || newlist[8]=='b' || newlist[8]=='k')&&(coordinate1==4 || coordinate1==5 || coordinate1==7))
					{
						newlist[8]= ' ';
						pass = 1;
					}
					else
					{
						cout << "Queen has no enemy to shoot"<<endl<<endl;
						pass = 0;
					}
					coordinate1 = -1;
					
				}
			
				
			}
			else if(letter1=='R')
			{
				for(int i=0;i<9;i++)
				{
					if(newlist[i]=='R')
					{
						coordinate1 = i;
						break;
					}
				}
				
				
				if (coordinate1 <0)
				{
					cout << "Pieces not found!!"<<endl<<endl;
					pass = 0;
				}
				
				while(coordinate1>=0)
				{ 
					if((newlist[0]=='q' || newlist[0]=='r' || newlist[0]=='b' || newlist[0]=='k')&&(coordinate1==1 || coordinate1==3))
					{
						newlist[0]= ' ';
						pass = 1;
					}
					else if((newlist[1]=='q' || newlist[1]=='r' || newlist[1]=='b' || newlist[1]=='k')&&(coordinate1==0 || coordinate1==2 || coordinate1==4))
					{
						newlist[1]= ' ';
						pass = 1;
					}
					else if((newlist[2]=='q' || newlist[2]=='r' || newlist[2]=='b' || newlist[2]=='k')&&(coordinate1==1 || coordinate1==5))
					{
						newlist[2]= ' ';
						pass = 1;
					}
					else if((newlist[3]=='q' || newlist[3]=='r' || newlist[3]=='b' || newlist[3]=='k')&&(coordinate1==0 || coordinate1==4 || coordinate1==6))
					{
						newlist[3]= ' ';
						pass = 1;
					}
					else if((newlist[4]=='q' || newlist[4]=='r' || newlist[4]=='b' || newlist[4]=='k')&&(coordinate1==1 || coordinate1==3 || coordinate1==5 || coordinate1==7))
					{
						newlist[4]= ' ';
						pass = 1;
					}
					else if((newlist[5]=='q' || newlist[5]=='r' || newlist[5]=='b' || newlist[5]=='k')&&(coordinate1==2 || coordinate1==4 || coordinate1==8))
					{
						newlist[5]= ' ';
						pass = 1;
					}
					else if((newlist[6]=='q' || newlist[6]=='r' || newlist[6]=='b' || newlist[6]=='k')&&(coordinate1==3 || coordinate1==7))
					{
						newlist[6]= ' ';
						pass = 1;
					}
					else if((newlist[7]=='q' || newlist[7]=='r' || newlist[7]=='b' || newlist[7]=='k')&&(coordinate1==4 || coordinate1==6 || coordinate1==8))
					{
						newlist[7]= ' ';
						pass = 1;
					}
					else if((newlist[8]=='q' || newlist[8]=='r' || newlist[8]=='b' || newlist[8]=='k')&&(coordinate1==5 || coordinate1==7))
					{
						newlist[8]= ' ';
						pass = 1;
					}
					else
					{
						cout << "Rook has no enemy to shoot"<<endl<<endl;
						pass = 0;
					}
					
					
					coordinate1=-1;
				}
			
			//if you select B
				
			}
			else if(letter1=='B')
			{
				for(int i=0;i<9;i++)
				{
					if(newlist[i]=='B')
					{
						coordinate1 = i;
						break;
					}
				}
				
				
				if (coordinate1 <0)
				{
					cout << "Pieces not found!!"<<endl<<endl;
					pass = 0;
				}
				
			
				
				while(coordinate1>=0)
				{
					if((newlist[0]=='q' || newlist[0]=='r' || newlist[0]=='b' || newlist[0]=='k')&&(coordinate1==4))
					{
						newlist[0]= ' ';
						pass = 1;
					}
					else if((newlist[1]=='q' || newlist[1]=='r' || newlist[1]=='b' || newlist[1]=='k')&&(coordinate1==3 || coordinate1==5))
					{
						newlist[1]= ' ';
						pass = 1;
					}
					else if((newlist[2]=='q' || newlist[2]=='r' || newlist[2]=='b' || newlist[2]=='k')&&(coordinate1==4))
					{
						newlist[2]= ' ';
						pass = 1;
					}
					else if((newlist[3]=='q' || newlist[3]=='r' || newlist[3]=='b' || newlist[3]=='k')&&(coordinate1==1 || coordinate1==7))
					{
						newlist[3]= ' ';
						pass = 1;
					}
					else if((newlist[4]=='q' || newlist[4]=='r' || newlist[4]=='b' || newlist[4]=='k')&&(coordinate1==0 || coordinate1==2 || coordinate1==6 || coordinate1==8))
					{
						newlist[4]= ' ';
						pass = 1;
					}
					else if((newlist[5]=='q' || newlist[5]=='r' || newlist[5]=='b' || newlist[5]=='k')&&(coordinate1==1 || coordinate1==7))
					{
						newlist[5]= ' ';
						pass = 1;
					}
					else if((newlist[6]=='q' || newlist[6]=='r' || newlist[6]=='b' || newlist[6]=='k')&&(coordinate1==4))
					{
						newlist[6]= ' ';
						pass = 1;
					}
					else if((newlist[7]=='q' || newlist[7]=='r' || newlist[7]=='b' || newlist[7]=='k')&&(coordinate1==3 || coordinate1==5))
					{
						newlist[7]= ' ';
						pass = 1;
					}
					else if((newlist[8]=='q' || newlist[8]=='r' || newlist[8]=='b' || newlist[8]=='k')&&(coordinate1==4))
					{
						newlist[8]= ' ';
						pass = 1;
					}
					else
					{
						cout << "Bishop has no enemy to shoot"<<endl<<endl;
						pass = 0;
					}
					coordinate1 = -1;
					
				}
			}
			else if(letter1=='K')
			{
				for(int i=0;i<9;i++)
				{
					if(newlist[i]=='K')
					{
						coordinate1 = i;
						break;
					}
				}
				
				if (coordinate1 <0)
				{
					cout << "Pieces not found!!"<<endl<<endl;
					pass = 0;
				}
				
			
				
				while(coordinate1>=0)
				{
					if((newlist[0]=='q' || newlist[0]=='r' || newlist[0]=='b' || newlist[0]=='k')&&(coordinate1==2 || coordinate1==6))
					{
						newlist[0]= ' ';
						pass = 1;
					}
					else if((newlist[1]=='q' || newlist[1]=='r' || newlist[1]=='b' || newlist[1]=='k')&&(coordinate1==7))
					{
						newlist[1]= ' ';
						pass = 1;
					}
					else if((newlist[2]=='q' || newlist[2]=='r' || newlist[2]=='b' || newlist[2]=='k')&&(coordinate1==0 || coordinate1==8))
					{
						newlist[2]= ' ';
						pass = 1;
					}
					else if((newlist[3]=='q' || newlist[3]=='r' || newlist[3]=='b' || newlist[3]=='k')&&(coordinate1==5))
					{
						newlist[3]= ' ';
						pass = 1;
					}
					else if((newlist[4]=='q' || newlist[4]=='r' || newlist[4]=='b' || newlist[4]=='k')&&(coordinate1==4))
					{
						//newlist[4]= ' ';
						//pass = 1;
						cout << "Knight has no enemy to shoot"<<endl<<endl;
						pass=0;
					}
					else if((newlist[5]=='q' || newlist[5]=='r' || newlist[5]=='b' || newlist[5]=='k')&&(coordinate1==3))
					{
						newlist[5]= ' ';
						pass = 1;
					}
					else if((newlist[6]=='q' || newlist[6]=='r' || newlist[6]=='b' || newlist[6]=='k')&&(coordinate1==0 || coordinate1==8))
					{
						newlist[6]= ' ';
						pass = 1;
					}
					else if((newlist[7]=='q' || newlist[7]=='r' || newlist[7]=='b' || newlist[7]=='k')&&(coordinate1==1))
					{
						newlist[7]= ' ';
						pass = 1;
					}
					else if((newlist[8]=='q' || newlist[8]=='r' || newlist[8]=='b' || newlist[8]=='k')&&(coordinate1==2 || coordinate1==6))
					{
						newlist[8]= ' ';
						pass = 1;
					}
					else
					{
						cout << "Knight has no enemy to shoot"<<endl<<endl;
						pass = 0;
					}
					coordinate1 = -1;
					
				}
			}
			else if(letter1=='Z'||letter1=='z')
			{
				exit(player1_score,player2_score,newlist);
				return 0;
			}
			else 
			{
				cout << "Wrong Input!!"<<endl<<endl;
				pass = 0;
				
			}
			
			//if(pass==1)
			//{
			//	player1_score = player1_score + 1;
			//}
		}
		
		
		//below are for player2
		//everything is same as above except the variable name.
		int pass2=0;
		while(pass2 == 0)
		{
			position(newlist,9);
			letter2=player2_choice(input2);
			if(letter2=='q')
			{
				for(int i=0;i<9;i++)
				{
					if(newlist[i]=='q')
					{
						coordinate2 = i;
						break;
					}
				}
				
				//cout << coordinate2;
				
				if (coordinate2 <0)
				{
					cout << "Pieces not found!!"<<endl<<endl;
					pass2 = 0;
				}
				
			
				
				while(coordinate2>=0)
				{
					if((newlist[0]=='Q' || newlist[0]=='R' || newlist[0]=='B' || newlist[0]=='K')&&(coordinate2==1 || coordinate2==3 || coordinate2==4))
					{
						newlist[0]= ' ';
						pass2 = 1;
					}
					else if((newlist[1]=='Q' || newlist[1]=='R' || newlist[1]=='B' || newlist[1]=='K')&&(coordinate2==0 || coordinate2==2 || coordinate2==3 || coordinate2==4 || coordinate2==5))
					{
						newlist[1]= ' ';
						pass2 = 1;
					}
					else if((newlist[2]=='Q' || newlist[2]=='R' || newlist[2]=='B' || newlist[2]=='K')&&(coordinate2==1 || coordinate2==4 || coordinate2==5))
					{
						newlist[2]= ' ';
						pass2 = 1;
					}
					else if((newlist[3]=='Q' || newlist[3]=='R' || newlist[3]=='B' || newlist[3]=='K')&&(coordinate2==0 || coordinate2==1 || coordinate2==4 || coordinate2==6 || coordinate2==7))
					{
						newlist[3]= ' ';
						pass2 = 1;
					}
					else if((newlist[4]=='Q' || newlist[4]=='R' || newlist[4]=='B' || newlist[4]=='K')&&(coordinate2==0 || coordinate2==1 || coordinate2==2 || coordinate2==3 || coordinate2==5 || coordinate2==6 || coordinate2==7 || coordinate2==8))
					{
						newlist[4]= ' ';
						pass2 = 1;
					}
					else if((newlist[5]=='Q' || newlist[5]=='R' || newlist[5]=='B' || newlist[5]=='K')&&(coordinate2==1 || coordinate2==2 || coordinate2==4 || coordinate2==7 || coordinate2==8))
					{
						newlist[5]= ' ';
						pass2 = 1;
					}
					else if((newlist[6]=='Q' || newlist[6]=='R' || newlist[6]=='B' || newlist[6]=='K')&&(coordinate2==3 || coordinate2==4 || coordinate2==7))
					{
						newlist[6]= ' ';
						pass2 = 1;
					}
					else if((newlist[7]=='Q' || newlist[7]=='R' || newlist[7]=='B' || newlist[7]=='K')&&(coordinate2==3 || coordinate2==4 || coordinate2==5 || coordinate2==6 || coordinate2==8))
					{
						newlist[7]= ' ';
						pass2 = 1;
					}
					else if((newlist[8]=='Q' || newlist[8]=='R' || newlist[8]=='B' || newlist[8]=='K')&&(coordinate2==4 || coordinate2==5 || coordinate2==7))
					{
						newlist[8]= ' ';
						pass2 = 1;
					}
					else
					{
						cout << "Queen has no enemy to shoot"<<endl<<endl;
						pass2 = 0;
					}
					coordinate2 = -1;
				}
			
			}
			else if(letter2=='r')
			{
				for(int i=0;i<9;i++)
				{
					if(newlist[i]=='r')
					{
						coordinate2 = i;
						break;
					}
				}
				
				
				if (coordinate2 <0)
				{
					cout << "Pieces not found!!"<<endl<<endl;
					pass2 = 0;
				}
				
				while(coordinate2>=0)
				{
					if((newlist[0]=='Q' || newlist[0]=='R' || newlist[0]=='B' || newlist[0]=='K')&&(coordinate2==1 || coordinate2==3))
					{
						newlist[0]= ' ';
						pass2 = 1;
					}
					else if((newlist[1]=='Q' || newlist[1]=='R' || newlist[1]=='B' || newlist[1]=='K')&&(coordinate2==0 || coordinate2==2 || coordinate2==4))
					{
						newlist[1]= ' ';
						pass2 = 1;
					}
					else if((newlist[2]=='Q' || newlist[2]=='R' || newlist[2]=='B' || newlist[2]=='K')&&(coordinate2==1 || coordinate2==5))
					{
						newlist[2]= ' ';
						pass2 = 1;
					}
					else if((newlist[3]=='Q' || newlist[3]=='R' || newlist[3]=='B' || newlist[3]=='K')&&(coordinate2==0 || coordinate2==4 || coordinate2==6))
					{
						newlist[3]= ' ';
						pass2 = 1;
					}
					else if((newlist[4]=='Q' || newlist[4]=='R' || newlist[4]=='B' || newlist[4]=='K')&&(coordinate2==1 || coordinate2==3 || coordinate2==5 || coordinate2==7))
					{
						newlist[4]= ' ';
						pass2 = 1;
					}
					else if((newlist[5]=='Q' || newlist[5]=='R' || newlist[5]=='B' || newlist[5]=='K')&&(coordinate2==2 || coordinate2==4 || coordinate2==8))
					{
						newlist[5]= ' ';
						pass2 = 1;
					}
					else if((newlist[6]=='Q' || newlist[6]=='R' || newlist[6]=='B' || newlist[6]=='K')&&(coordinate2==3 || coordinate2==7))
					{
						newlist[6]= ' ';
						pass2 = 1;
					}
					else if((newlist[7]=='Q' || newlist[7]=='R' || newlist[7]=='B' || newlist[7]=='K')&&(coordinate2==4 || coordinate2==6 || coordinate2==8))
					{
						newlist[7]= ' ';
						pass2 = 1;
					}
					else if((newlist[8]=='Q' || newlist[8]=='R' || newlist[8]=='B' || newlist[8]=='K')&&(coordinate2==5 || coordinate2==7))
					{
						newlist[8]= ' ';
						pass2 = 1;
					}
					else
					{
						cout << "Rook has no enemy to shoot"<<endl<<endl;
						pass2 = 0;
					}
					
					
					coordinate2=-1;
				}
			}
			else if(letter2=='b')
			{
				for(int i=0;i<9;i++)
				{
					if(newlist[i]=='b')
					{
						coordinate2 = i;
						break;
					}
				}
				
				
				if (coordinate2 <0)
				{
					cout << "Pieces not found!!"<<endl<<endl;
					pass2 = 0;
				}
				
			
				
				while(coordinate2>=0)
				{
					if((newlist[0]=='Q' || newlist[0]=='R' || newlist[0]=='B' || newlist[0]=='K')&&(coordinate2==4))
					{
						newlist[0]= ' ';
						pass2 = 1;
					}
					else if((newlist[1]=='Q' || newlist[1]=='R' || newlist[1]=='B' || newlist[1]=='K')&&(coordinate2==3 || coordinate2==5))
					{
						newlist[1]= ' ';
						pass2 = 1;
					}
					else if((newlist[2]=='Q' || newlist[2]=='R' || newlist[2]=='B' || newlist[2]=='K')&&(coordinate2==4))
					{
						newlist[2]= ' ';
						pass2 = 1;
					}
					else if((newlist[3]=='Q' || newlist[3]=='R' || newlist[3]=='B' || newlist[3]=='K')&&(coordinate2==1 || coordinate2==7))
					{
						newlist[3]= ' ';
						pass2 = 1;
					}
					else if((newlist[4]=='Q' || newlist[4]=='R' || newlist[4]=='B' || newlist[4]=='K')&&(coordinate2==0 || coordinate2==2 || coordinate2==6 || coordinate2==8))
					{
						newlist[4]= ' ';
						pass2 = 1;
					}
					else if((newlist[5]=='Q' || newlist[5]=='R' || newlist[5]=='B' || newlist[5]=='K')&&(coordinate2==1 || coordinate2==7))
					{
						newlist[5]= ' ';
						pass2 = 1;
					}
					else if((newlist[6]=='Q' || newlist[6]=='R' || newlist[6]=='B' || newlist[6]=='K')&&(coordinate2==4))
					{
						newlist[6]= ' ';
						pass2 = 1;
					}
					else if((newlist[7]=='Q' || newlist[7]=='R' || newlist[7]=='B' || newlist[7]=='K')&&(coordinate2==3 || coordinate2==5))
					{
						newlist[7]= ' ';
						pass2 = 1;
					}
					else if((newlist[8]=='Q' || newlist[8]=='R' || newlist[8]=='B' || newlist[8]=='K')&&(coordinate2==4))
					{
						newlist[8]= ' ';
						pass2 = 1;
					}
					else
					{
						cout << "Bishop has no enemy to shoot"<<endl<<endl;
						pass2 = 0;
					}
					coordinate2 = -1;
					
				}
			}
			else if(letter2=='k')
			{
				for(int i=0;i<9;i++)
				{
					if(newlist[i]=='k')
					{
						coordinate2 = i;
						break;
					}
				}
				
				
				if (coordinate2 <0)
				{
					cout << "Pieces not found!!"<<endl<<endl;
					pass2 = 0;
				}
				
			
				
				while(coordinate2>=0)
				{
					if((newlist[0]=='Q' || newlist[0]=='R' || newlist[0]=='B' || newlist[0]=='K')&&(coordinate2==2 || coordinate2==6))
					{
						newlist[0]= ' ';
						pass2 = 1;
					}
					else if((newlist[1]=='Q' || newlist[1]=='R' || newlist[1]=='B' || newlist[1]=='K')&&(coordinate2==7))
					{
						newlist[1]= ' ';
						pass2 = 1;
					}
					else if((newlist[2]=='Q' || newlist[2]=='R' || newlist[2]=='B' || newlist[2]=='K')&&(coordinate2==0 || coordinate2==8))
					{
						newlist[2]= ' ';
						pass2 = 1;
					}
					else if((newlist[3]=='Q' || newlist[3]=='R' || newlist[3]=='B' || newlist[3]=='K')&&(coordinate2==5))
					{
						newlist[3]= ' ';
						pass2 = 1;
					}
					else if((newlist[4]=='Q' || newlist[4]=='R' || newlist[4]=='B' || newlist[4]=='K')&&(coordinate2==4))
					{
						//newlist[4]= ' ';
						//pass = 1;
						cout << "Knight has no enemy to shoot"<<endl<<endl;
						pass2=0;
					}
					else if((newlist[5]=='Q' || newlist[5]=='R' || newlist[5]=='B' || newlist[5]=='K')&&(coordinate2==3))
					{
						newlist[5]= ' ';
						pass2 = 1;
					}
					else if((newlist[6]=='Q' || newlist[6]=='R' || newlist[6]=='B' || newlist[6]=='K')&&(coordinate2==0 || coordinate2==8))
					{
						newlist[6]= ' ';
						pass2 = 1;
					}
					else if((newlist[7]=='Q' || newlist[7]=='R' || newlist[7]=='B' || newlist[7]=='K')&&(coordinate2==1))
					{
						newlist[7]= ' ';
						pass2 = 1;
					}
					else if((newlist[8]=='Q' || newlist[8]=='R' || newlist[8]=='B' || newlist[8]=='K')&&(coordinate2==2 || coordinate2==6))
					{
						newlist[8]= ' ';
						pass2 = 1;
					}
					else
					{
						cout << "Knight has no enemy to shoot"<<endl<<endl;
						pass2 = 0;
					}
					coordinate2 = -1;
					
				}
			}
			else if(letter2=='Z'||letter2=='z')
			{
				exit(player1_score,player2_score,newlist);
				return 0;
			}
			else //if(letter2 != 'q' || letter2 != 'r' || letter2 != 'b' || letter2 != 'k' || letter2 != 'z' )
			{
				cout << "Wrong Input!!"<<endl<<endl;
				pass2 = 0;
			}
		}
		
		number_of_game= number_of_game+2;  
	}
	
	position(newlist,9);
	
	for(int t=0;t<9;t++)
	{
		if(newlist[t]=='Q')
		{
			player1_score=player1_score+9;
		}
		else if(newlist[t]=='R')
		{
			player1_score=player1_score+6;
		}
		else if(newlist[t]=='B')
		{
			player1_score=player1_score+4;
		}
		else if(newlist[t]=='K')
		{
			player1_score=player1_score+4;
		}
		else if(newlist[t]=='q')
		{
			player2_score=player2_score+9;
		}
		else if(newlist[t]=='r')
		{
			player2_score=player2_score+6;
		}
		else if(newlist[t]=='b')
		{
			player2_score=player2_score+4;
		}
		else if(newlist[t]=='k')
		{
			player2_score=player2_score+4;
		}
		
	}
	
	
	
	if(player1_score>player2_score)
	{
		cout << "Player 1 wins!!!";
	}
	else if(player2_score>player1_score)
	{
		cout << "Player 2 wins!!!";
	}
	else
	{
		cout << "It is a DRAW!!!";
	}
	
}


void banner()
{
	cout << "=========================" << endl;
	cout << " WELCOME TO CHESS BATTLE " << endl;
	cout << "=========================" << endl << endl;
}

void position(char newlist[],int size) //to display board and the respected piece position
{ 
	cout << endl;
	cout << "=============" << endl;
	cout << "| "<<newlist[0] << " | " <<newlist[1] <<  " | " <<newlist[2] <<  " |" << endl;
	cout << "| "<<newlist[3] << " | " <<newlist[4] <<  " | " <<newlist[5] <<  " |" << endl;
	cout << "| "<<newlist[6] << " | " <<newlist[7] <<  " | " <<newlist[8] <<  " |" << endl;
	cout << "=============" <<endl << endl;
}

char player1_choice(char input1)
{
	
	cout << "Choose your piece (Q,R,B,K) or type Z to exit ==> ";
	cin >> input1;
	return input1;
}
	
char player2_choice(char input2)
{
	cout << "Choose your piece (q,r,b,k) or type Z to exit ==> ";
	cin >> input2;
	return input2;
	
}
	
void exit(int player1_score,int player2_score,char newlist[]) //get the sum of strenths and decide who win after click z
{
	for(int t=0;t<9;t++)
	{
		if(newlist[t]=='Q')
		{
			player1_score=player1_score+9;
		}
		else if(newlist[t]=='R')
		{
			player1_score=player1_score+6;
		}
		else if(newlist[t]=='B')
		{
			player1_score=player1_score+4;
		}
		else if(newlist[t]=='K')
		{
			player1_score=player1_score+4;
		}
		else if(newlist[t]=='q')
		{
			player2_score=player2_score+9;
		}
		else if(newlist[t]=='r')
		{
			player2_score=player2_score+6;
		}
		else if(newlist[t]=='b')
		{
			player2_score=player2_score+4;
		}
		else if(newlist[t]=='k')
		{
			player2_score=player2_score+4;
		}
		
	}
	
	//cout << player1_score << endl;
	//cout << player2_score << endl;
	
	
	if(player1_score>player2_score)
	{
		cout << endl;
		cout << "Player 1 wins!!!";
	}
	else if(player2_score>player1_score)
	{
		cout << endl;
		cout << "Player 2 wins!!!";
	}
	else
	{
		cout << endl;
		cout << "It is a DRAW!!!";
	}
}	
