package com.blogspot.symfonyworld.tictactoegs.thrift;

import org.apache.thrift.TException;

import com.blogspot.symfonyworld.tictactoegs.thrift.generated.GameService;
import java.util.Map;

public class GameServiceHandler implements GameService.Iface {

    public GameServiceHandler() {
    }

    public Map<String, Integer> listGames(String token) throws TException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
