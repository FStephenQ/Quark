package net.mercuryq.quark;
import com.googlecode.lanterna.*;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.ScreenWriter;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.SwingTerminal;


public class Quark {
	static char[][] MAP = new char[250][200];
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Terminal mainTerm = new SwingTerminal(250,200);
		Screen mainScreen = new Screen(mainTerm);
		mainScreen.startScreen();
		ScreenWriter mainWriter = new ScreenWriter(mainScreen);
		String name;
		while(true){
			mainWriter.drawString(0, 0, "What Is Your Name?");
			name = getString(mainTerm);
			mainScreen.clear();
			mainWriter.drawString(0, 0, "Are you "+name+"?[y/n]");
			char ans = mainTerm.readInput().getCharacter();
			if(ans == 'y') break;
			mainScreen.clear();
		}
		Player p1 = new Player(name, new Location(50,50));
		basicMap();
		drawMap(mainWriter);
	}
	
	private static void drawMap(ScreenWriter mainWriter){
		for(int i = 0; i < 250; i++){
			for(int k = 0; k < 200; k++){
				mainWriter.drawString(i,k,""+MAP[i][k]);
			}
		}
		
	}
	
	private static String getString(Terminal t){
		String name = "" + t.readInput().getCharacter();
		while(t.readInput().getCharacter() != '\n'){
			name += t.readInput().getCharacter();
		}
		return name;
	}
	
	private boolean isLegal(Location n){
		if( 1 > n.x || n.x > 249 || n.y > 194 || n.y <= 1) return false;
		else if(MAP[n.x][n.y] != '.') return false;
		else return true;
	}
	
	private static void basicMap(){
		for(int i = 0; i < 250; i++){
			MAP[i][199] = '\n';
		}
		for(int i = 0; i <250; i++){
			for(int k = 0; k<199; k++){
				MAP[i][k]= '.';
			}
		}
	}

}
