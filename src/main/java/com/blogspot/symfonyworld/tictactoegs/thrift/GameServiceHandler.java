package com.blogspot.symfonyworld.tictactoegs.thrift;

import java.util.Map;
import java.util.HashMap;
import java.util.UUID;

import org.apache.thrift.TException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.blogspot.symfonyworld.tictactoegs.thrift.generated.GameService;
import com.blogspot.symfonyworld.tictactoegs.thrift.generated.Game;
import com.blogspot.symfonyworld.tictactoegs.thrift.generated.Player;

public class GameServiceHandler implements GameService.Iface {

	private Logger logger;

	private HashMap<String, Game> games;

	public GameServiceHandler() {
		logger = LoggerFactory.getLogger("GameServiceHandler");
		games = new HashMap<>();
	}

	@Override
	public Map<String, Integer> listGames() throws TException {
		logger.info("BEGIN listGames");
		HashMap<String, Integer> result = new HashMap<>();
		for (Map.Entry<String, Game> entry : games.entrySet()) {
			result.put(entry.getKey(), entry.getValue().getPlayersSize());
		}
		logger.info("returned {} results", result.size());
		logger.info("END listGames");
		return result;
	}

	@Override
	public String newGame() throws TException {
		logger.info("BEGIN newGame");
		String uuid = UUID.randomUUID().toString();
		games.put(uuid, new Game());
		logger.info("END newGame");
		return uuid;
	}

	@Override
	public Game gameInfo(String gameId) throws TException {
		logger.info("BEGIN gameInfo");
		logger.info("END gameInfo");
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public void quitGame(String userToken, String GameId) throws TException {
		logger.info("BEGIN quitGame");
		logger.info("END quitGame");
    throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public String registerGamePlayer(String gameId) throws TException {
		logger.info("BEGIN registerGamePlayer");
		logger.info("END registerGamePlayer");
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public Player gameNextMove(String gameId) throws TException {
		logger.info("BEGIN gameNextMove");
		logger.info("END gameNextMove");
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public boolean gameMove(String userToken, byte position) throws TException {
		logger.info("BEGIN gameMove");
		logger.info("END gameMove");
		throw new UnsupportedOperationException("Not supported yet.");
	}
}
