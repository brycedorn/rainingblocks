public class TextCreation
{
	void createText(String text, int x, int y, double dy, int score, int level)
	{
			x = (int)(Math.random() * 400);
			y = 0;

		//Set Levels
			if (level >= 5)			text = "" + (int)(Math.random() * 99999);
			else if (level >= 3)	text = "" + (int)(Math.random() * 9999);
			else if (level >= 1)	text = "" + (int)(Math.random() * 999);
	
			dy = level;
			score++;		
	}
}
