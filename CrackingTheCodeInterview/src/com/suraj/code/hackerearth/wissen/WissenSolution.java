package com.suraj.code.hackerearth.wissen;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/*
 Input
1
Virat_Kohli 22,Steve_Smith 33,Virat_Kohli 45,Steve_Smith 55,Virat_Kohli 66

*/

/*
 * Output
 
 Steve_Smith 44.0000 2
 Virat_Kohli 44.3333 3
 
 */



public class WissenSolution {
	
	static Map<String, ArrayList<Integer>> map = new ConcurrentHashMap<String, ArrayList<Integer>>();
	
	public static class PlayerStatisticsCollectorImpl implements PlayerStatisticsCollector {
		@Override
		public void putNewInnings(String player, int runs) {
			
			ArrayList<Integer> list = map.get(player);
			if(list != null && list.size()>0) {
				list.add(runs);
			} else {
				list = new ArrayList<Integer>();
				list.add(runs);
				map.put(player, list);
			}
		}

		@Override
		public double getAverageRuns(String player) {
			double avgRun = 0;
			ArrayList<Integer> runs = map.get(player);
			if(runs != null && runs.size()>0) {
				double totalRuns = 0;
				for(Integer run: runs) {
					totalRuns = totalRuns + run;
				}
				avgRun = totalRuns/runs.size();
			}
			
			return avgRun;
		}

		@Override
		public int getInningsCount(String player) {
			ArrayList<Integer> runs = map.get(player);
			if(runs != null && runs.size()>0) {
				return runs.size();
			}
			return 0;
		}
	}

	////////////////// DO NOT MODIFY BELOW THIS LINE ///////////////////

	public interface PlayerStatisticsCollector {
		// This is an input. Make note of this player inning. Runs is a non negative
		// integer.
		void putNewInnings(String player, int runs);

		// Get the runs average(mathematical average) for a player
		double getAverageRuns(String player);

		// Get the total number of innings for the player
		int getInningsCount(String player);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numLines = Integer.parseInt(scanner.nextLine());
		int currentLine = 0;
		while (currentLine++ < numLines) {
			final PlayerStatisticsCollector stats = new PlayerStatisticsCollectorImpl();
			final Set<String> players = new TreeSet<>();

			String line = scanner.nextLine();
			String[] inputs = line.split(",");
			for (int i = 0; i < inputs.length; ++i) {
				String[] tokens = inputs[i].split(" ");
				final String player = tokens[0];
				players.add(player);
				final int runs = Integer.parseInt(tokens[1]);

				stats.putNewInnings(player, runs);

			}

			for (String player : players) {
				System.out.println(String.format("%s %.4f %d", player, stats.getAverageRuns(player),
						stats.getInningsCount(player)));
			}

		}
		scanner.close();

	}
}
