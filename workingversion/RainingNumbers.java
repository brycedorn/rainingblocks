
/**
 * @bsdorn2, otaguro2
 */
public class RainingNumbers
{
	public static void main(String[] args)
	{
		
	//Title screen
		Zen.drawImage("startscreen480.jpg", 0, 0, Zen.getZenWidth(), Zen.getZenHeight());

		Zen.waitForClick();
		
	//Consistent Variables
		int score = -1, level = 1, lives = 3;
		double dy=0, dx=0;
		
	//Text 1 Variable		
		String text = "";
		int x1=0, y1=0;
		
	//Start Time
		long startTime =System.currentTimeMillis();
		
	//Initialization
		Zen.setFont("Minecraft-26");
		
		//Main Loop
		while (Zen.isRunning()) 
		{ 
			if (lives == 0)
			{	x1=0;
				y1=0;
				dx = 0;
				dy = 3;
				Zen.flipBuffer();
				Zen.drawImage("death.jpg",0, 0, Zen.getZenWidth(), Zen.getZenHeight());
				if(Zen.getMouseClickX()>181&&Zen.getMouseClickX()<460&&Zen.getMouseClickY()>255&&Zen.getMouseClickY()<439) {lives=3; level=1;}
					
			}
		
			else	if (y1 <= 427)
				{						
					if (text.length() == 0)
					{
						x1 = (int)(Math.random() * 400);
						y1 = 0;
						
						dx = 0;
						
					//Set Levels
						if (level >= 1){	text = "" + (int)(Math.random() * 899 + 100);
												dy=(3.*level)/10+1;}
						
						score=score+level;

					}

				//Creates the Window
					Zen.setColor(255, 255, 255);
					Zen.drawImage("background480.jpg",0, 0, Zen.getZenWidth(), Zen.getZenHeight());

				//Creates the Text
					String[] textures = {"dirt.jpg","sand.jpg","cobble.jpg","wood.jpg","lava.jpg"};
					Zen.drawImage(textures[level-1],x1-4,y1-60);
					Zen.setColor(56,56,56);
					Zen.drawText(text, x1+2, y1+2);
					Zen.setColor(224,224,224);
					Zen.drawText(text, x1, y1);
					
					//Lives
					if(lives>0)
						for(int k=0;k<lives;k++){
						Zen.drawImage("heart.png",400+18*k,456);}
					
					//Shading
					Zen.setFont("Minecraft-16");
					Zen.setColor(56,56,56);
					Zen.drawText(""+level,79,474);
					Zen.drawText(""+score,187,474);
					
					//Actual text
					Zen.setColor(224,224,224);
					Zen.drawText(""+level,78,473);
					Zen.drawText(""+score,186,473);
					Zen.setFont("Minecraft-32");
					Zen.flipBuffer();
		
			
				//Creates and Draws Time in Above Box
					int time = (int) (System.currentTimeMillis() - startTime)/1000;
					long sinTime = (System.currentTimeMillis() - startTime);
					//Zen.drawText(""+time, 10, 470);
			
				//Moves the Text on next Loop (Does NOT create a new one)
					
					 if (level <2){	
						x1 += dx;}
					
					y1 += dy;

					String user = Zen.getEditText();
					Zen.setEditText("");
			
					for(int i=0;i < user.length();i++)
					{
						char c = user.charAt(i);
						
						if(c == text.charAt(0))
							text = text.substring(1);
					//	else if(c == text2.charAt(0))
					//		text2 = text2.substring(1);
						else
						{
							dy++;									//speeds it up
						}
					} //for
			
					Zen.sleep(10);
			
					if (score <10)		level = 1;
					else if (score < 20)	level = 2;
					else if (score < 30)	level = 3;
					else if (score < 50)	level = 4;
					else if (score > 50)    level = 5;

				}
				else
				{
					
					
					{
							for (int k = -1; k < lives; k++)
							{
								
								Zen.drawImage("background480.jpg",0, 0, Zen.getZenWidth(), Zen.getZenHeight());
								if(k==1)
								Zen.drawImage("wheart.png", 400 + 18*(1), 456);
								else if(k==2){ Zen.drawImage("wheart.png", 400 + 18*(0), 456);
											   Zen.drawImage("wheart.png", 400 + 18*(1), 456);
											   Zen.sleep(60);}
								else if(lives==3){  Zen.drawImage("wheart.png", 400 + 18*(0), 456);
											  		Zen.drawImage("wheart.png", 400 + 18*(1), 456);
											  		Zen.drawImage("wheart.png", 400 + 18*(2), 456);}
	
								//Actual text
								Zen.setColor(224,224,224);
								Zen.drawText(""+level,78,473);
								Zen.drawText(""+score,186,473);
								Zen.setFont("Minecraft-16");
								Zen.flipBuffer();
							}
							Zen.sleep(10);
							lives-=1;

						//Sets Hearts back to Red
							/**for (int k = 0; k < lives; k++)
							{
							
								Zen.drawImage("background480.jpg",0, 0, Zen.getZenWidth(), Zen.getZenHeight());
								Zen.drawImage("heart.png", 400 + 18*k, 456);
								//Actual text
								Zen.setColor(224,224,224);
								Zen.drawText(""+level,78,473);
								Zen.drawText(""+score,186,473);
								Zen.setFont("Minecraft-16");
								Zen.flipBuffer();}
							**/
							Zen.flipBuffer();
							
						score --;
						text = "";
						if (y1 >= 350) 		y1 = 0;
					} //if (check lives)
				}//if (check boundaries)
		} //while
	} //main
} //package
