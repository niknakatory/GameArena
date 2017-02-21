public class Game
{
	public static void main(String[] args)
	{
		double playX = 400;
		double playY = 300;
		int hitcounter = 0;
		// classes: 
		// movement /
		// more balls 
		// player
		// player movement
		// collision + result
		GameArena ga = new GameArena(800,600);
		//System.out.println("xmod = " + mod + " ymod = " + ymod + "x = " + x + " y = " + y);
		Ball[] balls = new Ball[5];
		balls[0] = new Ball(100, 300, 10, "WHITE", 8, -5);
		ga.addBall(balls[0]);
		balls[1] = new Ball(700, 100, 10, "WHITE", 10, 3);
		ga.addBall(balls[1]);
		balls[2] = new Ball(100, 500, 10, "WHITE", -8, 5);
		ga.addBall(balls[2]);
		balls[3] = new Ball(700, 400, 10, "WHITE", 4, -10);
		ga.addBall(balls[3]);
		balls[4] = new Ball(100, 100, 10, "WHITE", -3, 6);
		ga.addBall(balls[4]);
		Ball player = new Ball(playX, playY, 15, "YELLOW", 0 ,0);
		ga.addBall(player);
		while(true)
		{
			playX = player.getXPosition();
			playY = player.getYPosition();
			for(int i = 0; i < 5; i++)
			{
				balls[i].move();
				if (playX <= (balls[i].getXPosition() + 10) && playX >= (balls[i].getXPosition() - 10) && playY <= (balls[i].getYPosition() + 10) && playY >= (balls[i].getYPosition() - 10))
				{
					hitcounter++;
					System.out.println("hit" + hitcounter);
				}
				if ((balls[i].getXPosition() <= (playX + 15)) && (balls[i].getXPosition() >= (playX - 15)) && (balls[i].getYPosition() <= (playY + 15)) && (balls[i].getYPosition() >= (playY - 15)))
				{
					hitcounter++;
					System.out.println("hit" + hitcounter);
				}
			}
			
			if(ga.upPressed())
			{
				player.incPymod(-0.5);
			}
			if(ga.downPressed())
			{
				player.incPymod(0.5);
			}
			if(ga.leftPressed())
			{
				player.incPmod(-0.5);
			}
			if(ga.rightPressed())
			{
				player.incPmod(0.5);
			}
			player.slowPlayer();
			player.playerMove();
			ga.pause();
			
		}
	}
}