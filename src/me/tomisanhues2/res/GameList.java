package me.tomisanhues2.res;

public enum GameList {
    Rps;

    public static String getDisplayName(GameList gameList) {
        switch (gameList) {
            case Rps:
                return "Rock-Paper-Scissors";
        }

        return null;
    }
}
