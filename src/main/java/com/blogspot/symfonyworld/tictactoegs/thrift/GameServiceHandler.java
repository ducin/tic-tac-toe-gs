package com.blogspot.symfonyworld.tictactoegs.thrift;

import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
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

    private Game getGame(String gameId) throws TException {
        Game game = games.get(gameId);
        if (null == game)
            throw new TException("This game doesn't exist");
        return game;
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
        Game game = new Game();
        game.players = new HashMap<>();
        game.moves = new ArrayList<>();
        games.put(uuid, game);
        logger.info("END newGame");
        return uuid;
    }

    @Override
    public Game gameInfo(String gameId) throws TException {
        logger.info("BEGIN/END gameInfo");
        return getGame(gameId);
    }

    @Override
    public void quitGame(String userToken, String gameId) throws TException {
        logger.info("BEGIN quitGame");
        Game game = getGame(gameId);
        if (game.players.containsKey(userToken))
            games.remove(gameId);
        else
            throw new TException("This user doesn't play in this game");
        logger.info("END quitGame");
    }

    @Override
    public String joinGame(String gameId) throws TException {
        logger.info("BEGIN joinGame");
        Game game = getGame(gameId);
        String uuid = UUID.randomUUID().toString();
        switch (game.players.size()) {
            case 0:
                game.players.put(uuid, Player.X);
                break;
            case 1:
                game.players.put(uuid, Player.O);
                break;
            default:
                throw new TException("Cannot join this game");
        }
        logger.info("END joinGame");
        return uuid;
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
