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
    1: required string key,
    2: required list<Move> moves,
}

service GameService {

  map<string,int> listGames(
    1:required string token
  )

}
