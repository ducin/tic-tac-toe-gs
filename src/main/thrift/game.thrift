namespace java com.blogspot.symfonyworld.tictactoegs.thrift.generated
namespace py SymfonyWorld.TicTacToeGS

typedef i32 int

enum Player {
    X = 1,
    O = 2
}

struct Move {
    1: required Player player,
    2: required int position,
}

struct Game {
    1: required string id,
    2: required map<string, Player> players,
    3: required list<Move> moves,
    4: required Player nextMove,
}

service GameService {

  map<string,int> listGames(),

  string newGame(),

  Game gameInfo(
    1:required string gameId
  ),

  oneway void quitGame(
    1:required string userToken,
    2:required string gameId
  ),

  string joinGame(
    1:required string gameId
  ),

  Player gameNextMove(
    1:required string gameId
  ),

  bool gameMove(
    1:required string userToken,
    2:required byte position,
  )

}
