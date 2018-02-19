package com.paloit;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
*
* This Animation program animates a particle rolling in a particle chamber
*
* @author  Jeffrey
* @version 1.0
* @since   2018-02-12
*/
public class Animation {

   /**
   * This is the main method which makes use of animate method.
   * @param speed speed of particle
   * @param init initial condition of particles in chamber
   * @return a list of locations at each time instance
   *
   */
	public static List<String> animate(int speed, String init) {
		List<String> resultAtAllTimes = new ArrayList<>();
		Set<Particle> chamber = new HashSet<>();
		for (int i=0;i<init.length();i++) {
			Character c = init.charAt(i);
			if (c==('L') || c==('R')) {
				chamber.add(new Particle(c==('L'),i));
			}
		}

		resultAtAllTimes.add(print(chamber, init.length()));

		while(!chamber.isEmpty()) {
			List<Particle> tempC = new ArrayList<>();
			for (Particle p:chamber) {
				p.move(speed);
				if (p.getLocation()<0 || p.getLocation()>=init.length()) {
					tempC.add(p);
				}
			}

			chamber.removeAll(tempC);

			//chamber.removeIf((Particle p) -> (p.getLocation() < 0 || p.getLocation()>=init.length()));
			resultAtAllTimes.add(print(chamber, init.length()));
		}

		return resultAtAllTimes;

	}


	private static String print(Set<Particle> chamber, int initLength) {
		Set<Integer> chamberResultPosition = new HashSet<>();
		chamber.stream().forEach(p -> chamberResultPosition.add(p.getLocation()));

		StringBuilder sBuilder = new StringBuilder();
		for (int i=0; i<initLength; i++) {
			sBuilder.append(chamberResultPosition.contains(i) ? 'X':'.');
		}

		return sBuilder.toString();

	}

   /**
   * Main method which makes use of animate method.
   * @param args 1st and 2nd args are speed and initial condition of particles, respectively
   * @exception Any exception.
   */
	public static void main(String[] args) throws Exception {
		int speed = Integer.parseInt(args[0]);
		if (speed<1 || speed>10) {
			throw new Exception("First argument should be between 1 and 10 inclusive");
		}

		String init = args[1];
		if (init.length()<1 || init.length()>50) {
			throw new Exception("Second argument should contain between 1 and 50 characters inclusive");
		}

		//animate(speed,init).forEach(line -> System.out.println(line));
		
		animate(1,"LRRL.LR.LRR.R.LRRL.").forEach(line -> System.out.println(line));
		
		//List<String> myList = animate(speed,init);
		//myList = s -> System.out.println(s);
		
		
	}
}
