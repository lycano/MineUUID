package net.komputerking.dev.MineUUID;

import com.mojang.api.profiles.HttpProfileRepository;
import com.mojang.api.profiles.Profile;
import com.mojang.api.profiles.ProfileCriteria;

public class Main {
	
	public static void main(String[] args){
		Windows mainWindow = new Windows();
		mainWindow.setVisible(true);
	}
	
	 private static final HttpProfileRepository profileRepository = new HttpProfileRepository();
	 private static final String AGENT = "minecraft";
	
	public static String getUUID(String name){
		 Profile[] profiles = profileRepository.findProfilesByCriteria(new ProfileCriteria(name, AGENT));
		 
		 if (profiles.length == 1) {
		 return profiles[0].getId();
		 } else {
		 return "Couldn't get the UUID! :(";
		 }
	}
	
}
