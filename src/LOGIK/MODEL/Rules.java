package LOGIK.MODEL;

import LOGIK.GEOMETRY.Rechteck;
import java.util.ArrayList;
import java.util.Random;

public class Rules
{
    public void checkNeighbour(ArrayList<ArrayList<Rechteck>> rechteck1, ArrayList<ArrayList<Rechteck>> rechteck2)
    {
        int count = 0;
        
        for (int i = 1; i < rechteck1.size() - 1; i++)
            {
		for (int j = 1; j < rechteck1.get(i).size() - 1; j++)
		{
			count = 0;
			if (rechteck1.get(i - 1).get(j - 1).alive == true)
			{
				count++;
			}
			if (rechteck1.get(i - 1).get(j).alive == true)
			{
				count++;
			}
			if (rechteck1.get(i - 1).get(j + 1).alive == true)
			{
				count++;
			}
			if (rechteck1.get(i).get(j - 1).alive == true)
			{
				count++;
			}
			if (rechteck1.get(i).get(j + 1).alive == true)
			{
				count++;
			}
			if (rechteck1.get(i + 1).get(j - 1).alive == true)
			{
				count++;
			}
			if (rechteck1.get(i + 1).get(j).alive == true)
			{
				count++;
			}
			if (rechteck1.get(i + 1).get(j + 1).alive == true)
			{
				count++;
			}
			if (count < 2)
			{
                            rechteck2.get(i).get(j).setColor(0, 0, 0);
                            rechteck2.get(i).get(j).alive = false;
			}
			else if (count > 3)
			{
                            rechteck2.get(i).get(j).setColor(0, 0, 0);
                            rechteck2.get(i).get(j).alive = false;
			}
			else if (count == 3)
			{
                            rechteck2.get(i).get(j).setColor(1, 1, 1);
                            rechteck2.get(i).get(j).alive = true;
			}   
		}  
            }
    }

    public void initRandomStartPoulation(ArrayList<ArrayList<Rechteck>> rechteck, int seed)
    {
        Random rn = new Random();
        GameField gf = new GameField();
        int rnd = 0;
        float r = 0.8f;
        float g = 0;
        float b = 0.5f;
        
        for (int i = 0; i < rechteck.size(); i++)
        {
            for (int j = 0; j < rechteck.get(i).size(); j++)
            {
                if (i == 0 || j == 0 || i == rechteck.size()-1 || j == rechteck.get(i).size()-1)
                {
                   if (r == 0.8f && b == 0.5f)
                    {
                        rechteck.get(i).get(j).setColor(0.8f, 0.5f, 0);
                        r = 0.8f;
                        g = 0.5f;
                        b = 0;
                    }
                    else if (r == 0.8f && g == 0.5f)
                    {
                        rechteck.get(i).get(j).setColor(0, 0.8f, 0.5f);
                        r = 0;
                        g = 0.8f;
                        b = 0.5f;
                    }
                    else if ( g == 0.8f && b == 0.5f)
                    {
                        rechteck.get(i).get(j).setColor(0.8f, 0, 0.5f);
                        r = 0.8f;
                        g = 0f;
                        b = 0.5f;
                    }
                }
                else
		{
                    rnd = Math.abs(rn.nextInt()% 1000);
                    if (rnd < seed)
                    {
                        rechteck.get(i).get(j).setColor(1, 1, 1);
                        rechteck.get(i).get(j).alive = true;
                    }
		}
            }
        }
    }
}